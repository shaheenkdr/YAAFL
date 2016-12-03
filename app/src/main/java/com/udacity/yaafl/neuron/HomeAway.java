package com.udacity.yaafl.neuron;


import com.udacity.yaafl.utility.TeamInfo;

import java.util.List;

/**
 * Neuron which generates chances of success for home and
 * Away team based on team id and home or away value
 */
public class HomeAway {
    private int mTeamId;
    private boolean mHomeAwayId;
    private int mHomeWins;
    private int mAwayWins;
    private List<com.udacity.yaafl.cohesion.Situational> s_data;


    public HomeAway(int team, boolean home_away, List<com.udacity.yaafl.cohesion.Situational> s_data) {
        this.mTeamId = team;
        this.mHomeAwayId = home_away;
        this.s_data = s_data;
    }

    public int computeHomeAwayScore() {

        if (mHomeAwayId) {
            for (com.udacity.yaafl.cohesion.Situational situation_data : s_data) {
                if (situation_data.getHome() && situation_data.getTeam().equals(TeamInfo.getTeamName(mTeamId))) {
                    mHomeWins = (int) ((double) (situation_data.getWon()) / (double) (situation_data.getMatchPlayed()) * 100);
                    mAwayWins -= situation_data.getLose() * 10;
                }
            }
            return mHomeWins * 2;
        } else {
            for (com.udacity.yaafl.cohesion.Situational situation_data : s_data) {
                if (situation_data.getAway() && situation_data.getTeam().equals(TeamInfo.getTeamName(mTeamId))) {
                    mAwayWins = (int) ((double) (situation_data.getWon()) / (double) (situation_data.getMatchPlayed()) * 100);
                    mAwayWins -= situation_data.getLose() * 5;
                }
            }
            return mAwayWins * 2;
        }


    }


}