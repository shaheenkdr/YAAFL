package com.udacity.yaafl.neuron;


import com.udacity.yaafl.utility.TeamInfo;

import java.util.List;

/**
 * Neuron that calculates the motivation level of a team
 */
public class TeamMotivation {
    private int mTeamId;
    private boolean mHomeAway;
    private int mHomeAwayScore;
    private int mMotivationScore;
    private List<com.udacity.yaafl.cohesion.Recent> mRecent;


    public TeamMotivation(List<com.udacity.yaafl.cohesion.Recent> recent, int teamId, boolean homeAway, int homeAwayScore) {
        this.mRecent = recent;
        this.mTeamId = teamId;
        this.mHomeAway = homeAway;
        this.mHomeAwayScore = homeAwayScore;
        mMotivationScore = 0;

    }


    public int calculateMotivation() {
        for (com.udacity.yaafl.cohesion.Recent r : mRecent) {
            if (r.getTeam().equals(TeamInfo.getTeamName(mTeamId))) {
                List<Integer> values = r.getGames();
                int temp = 0;
                for (int i = 0; i < values.size(); i++)
                    temp += values.get(i);
                temp = temp * 10;

                if (mHomeAway) {
                    mMotivationScore = temp + (TeamInfo.getHomeWinAvg() / 4) + (mHomeAwayScore / 4);
                } else {
                    mMotivationScore = temp + (TeamInfo.getAwayWinAvg() / 4) + (mHomeAwayScore / 4);
                }

            }

        }

        return mMotivationScore;

    }

}