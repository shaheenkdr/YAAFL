package com.udacity.yaafl.neuron;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.udacity.yaafl.event_bus.Head2HeadEvent;
import com.udacity.yaafl.event_bus.MotivationEvent;
import com.udacity.yaafl.firebase_db.Head2Head;
import com.udacity.yaafl.utility.TeamInfo;

import org.greenrobot.eventbus.EventBus;

/**
 * Neuron to measure the head to head match results of
 * two teams to be played and generate score .
 */

public class TeamHeadToHead
{
    private int team1_id;
    private int team2_id;
    private int[] score;
    private Firebase fRef;
    private static final String HEADTOHEAD_URL = "https://yaafl-f20f2.firebaseio.com/Cohesion/Head2Head";

    public TeamHeadToHead(int team1,int team2)
    {
        this.team1_id = team1;
        this.team2_id = team2;
        score = new int[2];
        fRef = new Firebase(HEADTOHEAD_URL);
        computeScore();

    }

    private void computeScore()
    {
        final String MID = TeamInfo.getMatchId(TeamInfo.getTeamName(team1_id)+" VS "+TeamInfo.getTeamName(team2_id));
        fRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                if(!MID.equals(""))
                {
                    for(DataSnapshot objData:dataSnapshot.getChildren())
                    {
                        Head2Head versus_value = objData.getValue(Head2Head.class);
                        if(versus_value.getMatchID().equals(MID))
                        {
                            score[0] = versus_value.getTeam1();
                            score[1] = versus_value.getTeam2();
                            EventBus.getDefault().post(new Head2HeadEvent(score));
                            break;

                        }
                    }
                }
                else
                    EventBus.getDefault().post(new Head2HeadEvent(score));


            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


    }


}