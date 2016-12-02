package com.udacity.yaafl.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.elmargomez.typer.Font;
import com.elmargomez.typer.Typer;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.udacity.yaafl.R;
import com.udacity.yaafl.utility.TeamInfo;

public class FinalResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_final_result);
        Bundle extras = getIntent().getExtras();
        ImageView im1 = (ImageView)findViewById(R.id.winImage);
        final String val ="e"+extras.getInt("SCORE");
        int resourceId = this.getResources().getIdentifier(val, "drawable", "com.udacity.yaafl");
        im1.setImageResource(resourceId);
        StringBuilder sx = new StringBuilder();
        sx.append(TeamInfo.getTeamNameForView(extras.getInt("SCORE")));
        sx.append(" ");
        sx.append("wins");
        TextView t1 = (TextView)findViewById(R.id.winningText);
        Typeface font = Typer.set(this).getFont(Font.ROBOTO_BOLD);
        t1.setTypeface(font);
        t1.setText(sx.toString().toUpperCase());
        t1.setContentDescription(sx.toString()+"Wins");
        MobileAds.initialize(getApplicationContext(), "ca-app-pub-3940256099942544~3347511713");
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        FloatingActionButton fabRefresh = (FloatingActionButton)findViewById(R.id.fabRefresh);
        fabRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                new AlertDialog.Builder(FinalResultActivity.this)
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {
                                finish();
                                Intent intent = new Intent(FinalResultActivity.this,HomeTeamSelector.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("No", null)
                        .setTitle("Predict")
                        .setMessage("Would you like to predict another match?")
                        .show();


            }
        });

        FloatingActionButton fabShare = (FloatingActionButton)findViewById(R.id.fabShare);
        fabShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                new AlertDialog.Builder(FinalResultActivity.this)
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {
                                Intent sendIntent = new Intent();
                                sendIntent.setAction(Intent.ACTION_SEND);
                                sendIntent.putExtra(Intent.EXTRA_TEXT,
                                        "Hey check out my app at: https://play.google.com/store/apps/details?id=com.google.android.apps.plus");
                                sendIntent.setType("text/plain");
                                startActivity(sendIntent);
                            }
                        })
                        .setNegativeButton("No", null)
                        .setTitle("Share")
                        .setMessage("Share the app with friends?")
                        .show();



            }
        });
    }
}
