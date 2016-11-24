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
    private List<com.udacity.yaafl.cohesion.Situational>s_data;





    public HomeAway(int team, boolean home_away, List<com.udacity.yaafl.cohesion.Situational> s_data)
    {
        this.team_id = team;
        this.home_away_id = home_away;
        this.s_data = s_data;
    }

    public int computeHomeAwayScore()
    {

        if(home_away_id)
        {
            for(com.udacity.yaafl.cohesion.Situational situation_data: s_data)
            {
                if(situation_data.getHome() && situation_data.getTeam().equals(TeamInfo.getTeamName(team_id)))
                {
                    home_wins = (int)((double)(situation_data.getWon())/(double)(situation_data.getMatchPlayed())*100);
                }
            }
            return home_wins;
        }

        else
        {
            for(com.udacity.yaafl.cohesion.Situational situation_data: s_data)
            {
                if(situation_data.getAway() && situation_data.getTeam().equals(TeamInfo.getTeamName(team_id)))
                {
                    away_wins = (int)((double)(situation_data.getWon())/(double)(situation_data.getMatchPlayed())*100);
                }
            }
            return away_wins;
        }



    }


}