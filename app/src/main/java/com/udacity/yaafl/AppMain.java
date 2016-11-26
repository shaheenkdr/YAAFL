package com.udacity.yaafl;

import android.app.Application;

import com.firebase.client.Firebase;

import org.greenrobot.eventbus.EventBus;


public class AppMain extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();
        Firebase.setAndroidContext(this);
        EventBus myEventBus = EventBus.getDefault();

    }
}
