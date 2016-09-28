package com.udacity.yaafl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.crashlytics.android.Crashlytics;
import com.udacity.yaafl.event_bus.HomeAwayEvent;
import com.udacity.yaafl.neuron.HomeAway;

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
        HomeAway h1 = new HomeAway(0,false);


    }

    @Subscribe
    public void onEvent(HomeAwayEvent event)
    {
       Log.e("Thenga",""+event.getHomeAwayScore());
    }
}
