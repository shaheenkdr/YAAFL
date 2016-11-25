package com.udacity.yaafl.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.crashlytics.android.Crashlytics;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.udacity.yaafl.R;
import com.udacity.yaafl.cohesion.CohesionMain;
import com.udacity.yaafl.event_bus.CohesionEvent;
import com.udacity.yaafl.event_bus.Head2HeadEvent;
import com.udacity.yaafl.event_bus.HomeAwayEvent;
import com.udacity.yaafl.event_bus.MotivationEvent;
import com.udacity.yaafl.event_bus.PassesEvent;
import com.udacity.yaafl.firebase_db.Passes;
import com.udacity.yaafl.neuron.HomeAway;
import com.udacity.yaafl.neuron.MainNeuron;
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

        Intent intent = new Intent(SplashActivity.this,HomeTeamSelector.class);
        startActivity(intent);
        finish();
        //getPasses();


    }

    private void getPasses()
    {
        Firebase fRef = new Firebase("https://yaafl-f20f2.firebaseio.com/Cohesion");
        fRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {

                CohesionMain chTest = dataSnapshot.getValue(CohesionMain.class);
                MainNeuron mm = new MainNeuron(chTest,8,0);
                Log.e("TEST_FB",chTest.getSituational().get(0).getTeam());
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }




    @Subscribe
    public void onEvent(MotivationEvent event)
    {
        Log.e("Thenga2",""+event.getMotivationScore());
    }



    @Subscribe
    public void onEvent(CohesionEvent event)
    {
        Log.e("Alas lololol",""+event.getCohesionScore());
    }
}
