package com.udacity.yaafl.activities;


import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.crashlytics.android.Crashlytics;
import com.udacity.yaafl.R;
import io.fabric.sdk.android.Fabric;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        setupWindowAnimations();
        View view = getLayoutInflater().inflate(R.layout.activity_splash, null);
        final ActivityOptionsCompat options = ActivityOptionsCompat.
                makeSceneTransitionAnimation(this, view, "splash");

        int secondsDelayed = 1;
        new Handler().postDelayed(new Runnable() {
            public void run() {



                Intent intent = new Intent(SplashActivity.this,HomeTeamSelector.class);
                startActivity(intent,options.toBundle());
                finish();


            }
        }, secondsDelayed * 2000);


    }


    private void setupWindowAnimations() {
        Fade fade = new Fade();
        fade.setDuration(1000);
        getWindow().setExitTransition(fade);
    }



}
