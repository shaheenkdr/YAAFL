package com.udacity.yaafl.neuron;

import android.util.Log;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.udacity.yaafl.event_bus.HomeAwayEvent;
import com.udacity.yaafl.firebase_db.Situational;
import com.udacity.yaafl.utility.TeamInfo;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 *Neuron which generates chances of success for home and
 *Away team based on team id and home or away value
 */
public class HomeAway
{
    private int team_id;
    private boolean home_away_id;
    private int home_wins;
    private int away_wins;
    private Firebase fRef;
    private static final String SITUATIONAL_URL = "https://yaafl-f20f2.firebaseio.com/Cohesion/Situational";



    public HomeAway(int team, boolean home_away)
    {
        this.team_id = team;
        this.home_away_id = home_away;
        fRef = new Firebase(SITUATIONAL_URL);
        computeHomeAwayScore();
    }

    private void computeHomeAwayScore()
    {



        fRef.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                if(home_away_id)
                {

                    for(DataSnapshot objData : dataSnapshot.getChildren())
                    {
                        Situational situational_value= objData.getValue(Situational.class);
                        if(situational_value.getHome() && situational_value.getTeam().equals(TeamInfo.getTeamName(team_id)))
                        {
                            home_wins = (int)((double)(situational_value.getWon())/(double)(situational_value.getMatchPlayed())*100);
                            EventBus.getDefault().post(new HomeAwayEvent(home_wins,true));
                            break;
                        }
                    }
                }
                else
                {
                    for(DataSnapshot objData : dataSnapshot.getChildren())
                    {
                        Situational situational_value= objData.getValue(Situational.class);
                        if((!situational_value.getHome()) && situational_value.getTeam().equals(TeamInfo.getTeamName(team_id)))
                        {
                            away_wins = (int)((double)(situational_value.getWon())/(double)(situational_value.getMatchPlayed())*100);
                            EventBus.getDefault().post(new HomeAwayEvent(away_wins,false));
                            break;
                        }
                    }
                }


            }

            @Override
            public void onCancelled(FirebaseError firebaseError)
            {

            }
        });

    }
/*
    private void calculateChances()
    {
        if(home_away_id)
        {
            for(Situational x:situational_data)
            {
                if(x.getHome() && x.getTeam().equals(TeamInfo.getTeamName(team_id)))
                {
                    home_wins = (int)((double)(x.getWon())/(double)(x.getMatchPlayed())*100);
                }
            }
        }
        else
        {
            for(Situational x:situational_data)
            {
                if((!x.getHome()) && x.getTeam().equals(TeamInfo.getTeamName(team_id)))
                {
                    away_wins = (int)((double)(x.getWon())/(double)(x.getMatchPlayed())*100);
                }
            }
        }


    }
    */


}