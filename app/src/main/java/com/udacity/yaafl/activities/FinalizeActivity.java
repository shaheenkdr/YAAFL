package com.udacity.yaafl.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.elmargomez.typer.Font;
import com.elmargomez.typer.Typer;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.udacity.yaafl.R;
import com.udacity.yaafl.cohesion.CohesionMain;
import com.udacity.yaafl.event_bus.WinEvent;
import com.udacity.yaafl.neuron.MainNeuron;
import com.udacity.yaafl.utility.TeamInfo;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class FinalizeActivity extends AppCompatActivity
{
    private ProgressDialog pr;
    private int homeTeam;
    private String awayTeam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        setupWindowAnimations();
        pr = new ProgressDialog(FinalizeActivity.this);
        EventBus.getDefault().register(this);
        Bundle extras = getIntent().getExtras();
        homeTeam = extras.getInt("HOME");
        awayTeam = extras.getString("AWAY");
        String x = "e"+homeTeam;
        TextView t1 = (TextView)findViewById(R.id.team1ResultText);
        TextView t2 = (TextView)findViewById(R.id.team2ResultText);
        Typeface font = Typer.set(this).getFont(Font.ROBOTO_MEDIUM);
        t1.setText(TeamInfo.getTeamNameForView(homeTeam));
        t2.setText(awayTeam);
        t1.setTypeface(font);
        t2.setTypeface(font);

        int resourceId = this.getResources().getIdentifier(x, "drawable", "com.udacity.yaafl");
        ImageView im1 =(ImageView)findViewById(R.id.team1Result);
        im1.setImageResource(resourceId);

        resourceId = this.getResources().getIdentifier(TeamInfo.getTeamLogo(awayTeam), "drawable", "com.udacity.yaafl");
        ImageView im2 =(ImageView)findViewById(R.id.team2Result);
        im2.setImageResource(resourceId);





        final Button b1 = (Button)findViewById(R.id.processButton);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                pr.setMessage("processing data");
                pr.isIndeterminate();
                pr.show();
                getPasses(homeTeam,TeamInfo.getTeamId(awayTeam));
            }
        });

    }

    private void setupWindowAnimations() {
        Explode exp = new Explode();
        exp.setDuration(1000);

        getWindow().setEnterTransition(exp);
    }


    private void getPasses(final int home, final int away)
    {
        Firebase fRef = new Firebase("https://yaafl-f20f2.firebaseio.com/Cohesion");
        fRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {

                CohesionMain data = dataSnapshot.getValue(CohesionMain.class);
                MainNeuron mm = new MainNeuron(data,home,away);
                mm.processData();
            }

            @Override
            public void onCancelled(FirebaseError firebaseError)
            {
                Log.e("data error",firebaseError.getMessage());

            }
        });

    }

    @Subscribe
    public void onEvent(WinEvent event)
    {
        pr.dismiss();
        Intent intent = new Intent(FinalizeActivity.this,FinalResultActivity.class);
        Bundle extras = new Bundle();
        if(event.getHomeScore()>event.getAwayScore())
            extras.putInt("SCORE",event.getHomeID());
        else
            extras.putInt("SCORE",event.getAwayID());
        intent.putExtras(extras);
        startActivity(intent);
        finish();

    }



}
