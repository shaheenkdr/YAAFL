package com.udacity.yaafl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.crashlytics.android.Crashlytics;
import com.udacity.yaafl.event_bus.HomeAwayEvent;
import com.udacity.yaafl.event_bus.MotivationEvent;
import com.udacity.yaafl.neuron.HomeAway;
import com.udacity.yaafl.neuron.TeamMotivation;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import io.fabric.sdk.android.Fabric;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_splash);
        EventBus.getDefault().register(this);
        TeamMotivation m1 = new TeamMotivation(1,true,66);


    }

    @Subscribe
    public void onEvent(HomeAwayEvent event)
    {
       Log.e("Thenga",""+event.getHomeAwayScore());
    }

    @Subscribe
    public void onEvent(MotivationEvent event)
    {
        Log.e("Thenga2",""+event.getMotivationScore());
    }
}
