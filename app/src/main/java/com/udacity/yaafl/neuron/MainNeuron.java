package com.udacity.yaafl.neuron;


import android.util.Log;

import com.udacity.yaafl.cohesion.CohesionMain;
import com.udacity.yaafl.event_bus.Head2HeadEvent;
import com.udacity.yaafl.event_bus.HomeAwayEvent;
import com.udacity.yaafl.firebase_db.Head2Head;
import com.udacity.yaafl.utility.TeamInfo;

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
        //teams_head_to_head = new TeamHeadToHead(team_id_1,team_id_2);
        computeHomeScore();
        computeAwayScore();
    }

    private void computeHomeScore()
    {
        home = new HomeAway(team_id_1,true,data.getSituational());
        home_score = home.computeHomeAwayScore();

        team1 = new TeamValue(team_id_1);
        team_value_score_1 = team1.getTeamValueScore();

        home_team = new TeamCohesion(team_id_1,true,home_score,data.getSummary(),data.getPasses(),data.getShots(),data.getSituational());
        cohesion_score_1 = home_team.computeTeamCohesion();

        team_motivation_1 = new TeamMotivation(data.getRecent(),team_id_1,true,home_score);
        motivation_score_1 = team_motivation_1.calculateMotivation();

        int s = home_score + team_value_score_1+cohesion_score_1+motivation_score_1;
        Log.e(""+ TeamInfo.getTeamName(team_id_1),""+s);

    }

    private void computeAwayScore()
    {
        away = new HomeAway(team_id_2,false,data.getSituational());
        away_score = away.computeHomeAwayScore();

        team2 = new TeamValue(team_id_2);
        team_value_score_2 = team2.getTeamValueScore();

        away_team = new TeamCohesion(team_id_2,false,away_score,data.getSummary(),data.getPasses(),data.getShots(),data.getSituational());
        cohesion_score_2 = away_team.computeTeamCohesion();

        team_motivation_2 = new TeamMotivation(data.getRecent(),team_id_2,false,away_score);
        motivation_score_2 = team_motivation_2.calculateMotivation();

        int s = away_score + team_value_score_2+cohesion_score_2+motivation_score_2;
        Log.e(TeamInfo.getTeamName(team_id_2),""+s);

    }





}
