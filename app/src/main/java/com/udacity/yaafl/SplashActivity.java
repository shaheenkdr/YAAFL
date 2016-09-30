package com.udacity.yaafl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.crashlytics.android.Crashlytics;
import com.udacity.yaafl.event_bus.CohesionEvent;
import com.udacity.yaafl.event_bus.Head2HeadEvent;
import com.udacity.yaafl.event_bus.HomeAwayEvent;
import com.udacity.yaafl.event_bus.MotivationEvent;
import com.udacity.yaafl.neuron.HomeAway;
import com.udacity.yaafl.neuron.TeamCohesion;
import com.udacity.yaafl.neuron.TeamHeadToHead;
import com.udacity.yaafl.neuron.TeamMotivation;
import com.udacity.yaafl.neuron.TeamValue;
import com.udacity.yaafl.utility.TeamInfo;

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

        Log.e("THENGA",""+ TeamInfo.getMatchId("WestHam VS ManchesterUnited"));

        TeamValue t1 = new TeamValue(1);


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

    @Subscribe
    public void onEvent(Head2HeadEvent event)
    {
        Log.e("OHOHOHOH",""+event.getHeadToHeadScore());
    }

    @Subscribe
    public void onEvent(CohesionEvent event)
    {
        Log.e("Alas lololol",""+event.getCohesionScore());
    }
}
