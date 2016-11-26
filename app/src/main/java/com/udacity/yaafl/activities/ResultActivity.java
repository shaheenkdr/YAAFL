package com.udacity.yaafl.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.udacity.yaafl.R;
import com.udacity.yaafl.cohesion.CohesionMain;
import com.udacity.yaafl.event_bus.MotivationEvent;
import com.udacity.yaafl.event_bus.WinEvent;
import com.udacity.yaafl.neuron.MainNeuron;
import com.udacity.yaafl.utility.TeamInfo;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class ResultActivity extends AppCompatActivity
{
    private TextView sample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        EventBus.getDefault().register(this);
        sample = (TextView)findViewById(R.id.resultText);
        Bundle extras = getIntent().getExtras();
        int homeTeam = extras.getInt("HOME");
        int awayTeam = extras.getInt("AWAY");
        MobileAds.initialize(getApplicationContext(), "ca-app-pub-3940256099942544~3347511713");
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        getPasses(homeTeam,awayTeam);

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
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }

    @Subscribe
    public void onEvent(WinEvent event)
    {
        if(event.getHomeScore()>event.getAwayScore())
            sample.setText(TeamInfo.getTeamName(event.getHomeID())+" Wins");
        else
            sample.setText(TeamInfo.getTeamName(event.getAwayID())+" Wins");
    }

}
