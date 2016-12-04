package com.udacity.yaafl.neuron;


import android.content.Context;

import com.udacity.yaafl.cohesion.CohesionMain;
import com.udacity.yaafl.event_bus.WinEvent;

import org.greenrobot.eventbus.EventBus;


public class MainNeuron {
    private int mTeamId1;
    private int mTeamId2;
    private CohesionMain mData;
    private Context mContext;

    public MainNeuron(CohesionMain data, int team_id_1, int team_id_2, Context mContext) {
        this.mData = data;
        this.mTeamId1 = team_id_1;
        this.mTeamId2 = team_id_2;
        this.mContext = mContext;


    }


    public void processData() {
        int home = computeHomeScore();
        int away = computeAwayScore();
        TeamHeadToHead teams_head_to_head = new TeamHeadToHead(mData.getHead2Head(), mTeamId1, mTeamId2, mContext);
        int[] headToHead = teams_head_to_head.computeScore();
        home += headToHead[0];
        away += headToHead[1];
        EventBus.getDefault().post(new WinEvent(home, away, mTeamId1, mTeamId2));

    }

    private int computeHomeScore() {
        HomeAway home = new HomeAway(mTeamId1, true, mData.getSituational());
        int home_score = home.computeHomeAwayScore();


        TeamValue team1 = new TeamValue(mTeamId1);
        int team_value_score_1 = team1.getTeamValueScore();


        TeamCohesion home_team = new TeamCohesion(mTeamId1, true, home_score, mData.getSummary(), mData.getPasses(), mData.getShots(), mData.getSituational());
        int cohesion_score_1 = home_team.computeTeamCohesion();

        TeamMotivation team_motivation_1 = new TeamMotivation(mData.getRecent(), mTeamId1, true, home_score);
        int motivation_score_1 = team_motivation_1.calculateMotivation();


        return home_score + team_value_score_1 + cohesion_score_1 + motivation_score_1;

    }

    private int computeAwayScore() {
        HomeAway away = new HomeAway(mTeamId2, false, mData.getSituational());
        int away_score = away.computeHomeAwayScore();


        TeamValue team2 = new TeamValue(mTeamId2);
        int team_value_score_2 = team2.getTeamValueScore();

        TeamCohesion away_team = new TeamCohesion(mTeamId2, false, away_score, mData.getSummary(), mData.getPasses(), mData.getShots(), mData.getSituational());
        int cohesion_score_2 = away_team.computeTeamCohesion();


        TeamMotivation team_motivation_2 = new TeamMotivation(mData.getRecent(), mTeamId2, false, away_score);
        int motivation_score_2 = team_motivation_2.calculateMotivation();


        return away_score + team_value_score_2 + cohesion_score_2 + motivation_score_2;
    }


}
