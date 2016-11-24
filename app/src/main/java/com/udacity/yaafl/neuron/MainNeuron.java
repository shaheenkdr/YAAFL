package com.udacity.yaafl.neuron;


import android.util.Log;

import com.udacity.yaafl.cohesion.CohesionMain;
import com.udacity.yaafl.event_bus.Head2HeadEvent;
import com.udacity.yaafl.event_bus.HomeAwayEvent;
import com.udacity.yaafl.firebase_db.Head2Head;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainNeuron
{
    private int team_id_1;
    private int team_id_2;
    private HomeAway home;
    private HomeAway away;
    private TeamCohesion home_team;
    private TeamCohesion away_team;
    private TeamValue team1;
    private TeamValue team2;
    private TeamMotivation team_motivation_1;
    private TeamMotivation team_motivation_2;
    private TeamHeadToHead teams_head_to_head;
    private int home_score;
    private int away_score;
    private int team_value_score_1;
    private int team_value_score_2;
    private int[] head2headscore;
    private int motivation_score_1;
    private int motivation_score_2;
    private int cohesion_score_1;
    private int cohesion_score_2;
    private CohesionMain data;



    public MainNeuron(CohesionMain data,int team_id_1, int team_id_2)
    {
        this.data = data;
        this.team_id_1 = team_id_1;
        this.team_id_2 = team_id_2;
        teams_head_to_head = new TeamHeadToHead(team_id_1,team_id_2);
        computeHomeScore();
        //computeAwayScore();
    }

    private void computeHomeScore()
    {
        home = new HomeAway(team_id_1,true,data.getSituational());
        home_score = home.computeHomeAwayScore();

        team1 = new TeamValue(team_id_1);
        team_value_score_1 = team1.getTeamValueScore();

        home_team = new TeamCohesion(team_id_1,true,home_score,data.getSummary(),data.getPasses(),data.getShots(),data.getSituational());
        cohesion_score_1 = home_team.computeTeamCohesion();



    }

    private void computeAwayScore()
    {

    }





}
