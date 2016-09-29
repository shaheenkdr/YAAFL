package com.udacity.yaafl.neuron;

import android.util.Log;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.udacity.yaafl.event_bus.CohesionEvent;
import com.udacity.yaafl.event_bus.HomeAwayEvent;
import com.udacity.yaafl.event_bus.MotivationEvent;
import com.udacity.yaafl.event_bus.PassesEvent;
import com.udacity.yaafl.event_bus.ShotEvent;
import com.udacity.yaafl.event_bus.SituationalEvent;
import com.udacity.yaafl.event_bus.SummaryEvent;
import com.udacity.yaafl.firebase_db.Passes;
import com.udacity.yaafl.firebase_db.Shots;
import com.udacity.yaafl.firebase_db.Situational;
import com.udacity.yaafl.firebase_db.Summary;
import com.udacity.yaafl.utility.TeamInfo;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 *Neuron that generates score on team cohesion,ie
 *the score on how well players play as a team.
 */

public class TeamCohesion
{
    private int team_id;
    private boolean home_away_id;
    private int home_away_score;
    private int cohesion_score;
    private Firebase fRef;
    private static final String SUMMARY_URL="https://yaafl-f20f2.firebaseio.com/Cohesion/Summary";
    private static final String PASSES_URL="https://yaafl-f20f2.firebaseio.com/Cohesion/Passes";
    private static final String SHOTS_URL="https://yaafl-f20f2.firebaseio.com/Cohesion/Shots";
    private static final String SITUATIONAL_URL="https://yaafl-f20f2.firebaseio.com/Cohesion/Situational";


    public TeamCohesion(int teamId, boolean homeAwayId, int homeAwayScore)
    {
        EventBus.getDefault().register(this);
        this.team_id = teamId;
        this.home_away_id = homeAwayId;
        this.home_away_score = homeAwayScore;
        getSummary();

    }



    private void getSummary()
    {
        fRef = new Firebase(SUMMARY_URL);
        fRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                for(DataSnapshot objData:dataSnapshot.getChildren())
                {
                    Summary team_summary = objData.getValue(Summary.class);
                    if(team_summary.getTeam().equals(TeamInfo.getTeamName(team_id)))
                    {

                        EventBus.getDefault().post(new SummaryEvent(team_summary.getScore()));
                        break;
                    }
                }


            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });



    }

    private void getPasses(final double summary_score)
    {
        fRef = new Firebase(PASSES_URL);
        fRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                for(DataSnapshot objData:dataSnapshot.getChildren())
                {
                    if(home_away_id)
                    {
                        Passes team_passes = objData.getValue(Passes.class);
                        if(team_passes.getTeam().equals(TeamInfo.getTeamName(team_id)) && team_passes.getHomeFactor())
                        {
                            final int pass_score = team_passes.getCross()+team_passes.getLongBall()+team_passes.getShortPass()+team_passes.getThroughBall();
                            EventBus.getDefault().post(new PassesEvent(summary_score,pass_score));
                            break;
                        }
                    }
                    else
                    {
                        Passes team_passes = objData.getValue(Passes.class);
                        if(team_passes.getTeam().equals(TeamInfo.getTeamName(team_id)) && team_passes.getAwayFactor())
                        {
                            final int pass_score = team_passes.getCross()+team_passes.getLongBall()+team_passes.getShortPass()+team_passes.getThroughBall();
                            EventBus.getDefault().post(new PassesEvent(summary_score,pass_score));
                            break;
                        }

                    }

                }


            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }

    private void getShots(final double summary,final int pass)
    {
        fRef = new Firebase(SHOTS_URL);
        fRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                for(DataSnapshot objData:dataSnapshot.getChildren())
                {
                    Shots shots_played = objData.getValue(Shots.class);
                    if(shots_played.getTeam().equals(TeamInfo.getTeamName(team_id)))
                    {
                        final int shot_score = (int)((shots_played.getOnTarget()/shots_played.getTotal())*100);
                        EventBus.getDefault().post(new ShotEvent(summary,pass,shot_score));
                        break;
                    }
                }


            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }

    private void getSituationalAnalysis(final double summary,final int pass,final int shots)
    {
        fRef = new Firebase(SITUATIONAL_URL);
        fRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                if(home_away_id)
                {
                    for(DataSnapshot objData:dataSnapshot.getChildren())
                    {
                        Situational s_data = objData.getValue(Situational.class);
                        if(s_data.getTeam().equals(TeamInfo.getTeamName(team_id)) && s_data.getHome())
                        {
                            final int lose = s_data.getLose()*-10;
                            final int won = (int)(((double)s_data.getWon()/(double)s_data.getMatchPlayed())*10);
                            final int open = s_data.getOpenPlay()*5;
                            final int set_piece = s_data.getSetPiece()*10;
                            final int own_goal = s_data.getOwnGoal()*-10;
                            final int score = lose+won+open+set_piece+own_goal;
                            EventBus.getDefault().post(new SituationalEvent(summary,pass,shots,score));
                            break;
                        }
                    }
                }
                else
                {
                    for(DataSnapshot objData:dataSnapshot.getChildren())
                    {
                        Situational s_data = objData.getValue(Situational.class);
                        if(s_data.getTeam().equals(TeamInfo.getTeamName(team_id)) && s_data.getAway())
                        {
                            final int lose = s_data.getLose()*-5;
                            final int won = (int)(((double)s_data.getWon()/(double)s_data.getMatchPlayed())*20);
                            final int open = s_data.getOpenPlay()*7;
                            final int set_piece = s_data.getSetPiece()*20;
                            final int own_goal = s_data.getOwnGoal()*-5;
                            final int score = lose+won+open+set_piece+own_goal;
                            EventBus.getDefault().post(new SituationalEvent(summary,pass,shots,score));
                            break;
                        }

                    }

                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


    }


    @Subscribe
    public void onEvent(SummaryEvent event)
    {
        Log.e("Hellooo",""+event.getSummaryScore());
        getPasses(event.getSummaryScore());
    }

    @Subscribe
    public void onEvent(PassesEvent event)
    {
        Log.e("Hellooo2",""+event.getPassesScore());
        getShots(event.getSummaryScore(),event.getPassesScore());

    }

    @Subscribe
    public void onEvent(ShotEvent event)
    {
        Log.e("SHOTS",""+event.getShots());
        getSituationalAnalysis(event.getSummary(),event.getPass(),event.getShots());

    }

    @Subscribe
    public void onEvent(SituationalEvent event)
    {
        Log.e("ALAS",""+event.getSituational());
        cohesion_score = (int)(event.getSummary())+event.getSituational()+(event.getShots())+(event.getPass());
        EventBus.getDefault().post(new CohesionEvent(cohesion_score));

    }
}