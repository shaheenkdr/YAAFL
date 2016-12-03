package com.udacity.yaafl.neuron;


import com.udacity.yaafl.utility.TeamInfo;


import java.util.List;

/**
 * Neuron to measure the head to head match results of
 * two teams to be played and generate score .
 */

public class TeamHeadToHead {
    private int mTeam1Id;
    private int mTeam2Id;
    private int[] mScore;

    private List<com.udacity.yaafl.cohesion.Head2Head> head;

    public TeamHeadToHead(List<com.udacity.yaafl.cohesion.Head2Head> head, int team1, int team2) {
        this.head = head;
        this.mTeam1Id = team1;
        this.mTeam2Id = team2;
        mScore = new int[2];
    }

    public int[] computeScore() {
        final String MID = TeamInfo.getMatchId(TeamInfo.getTeamName(mTeam1Id) + " VS " + TeamInfo.getTeamName(mTeam2Id));

        if (!MID.equals("")) {
            for (com.udacity.yaafl.cohesion.Head2Head versus : head) {

                if (versus.getMatchID().equals(MID)) {
                    mScore[0] = versus.getTeam1() * 4;
                    mScore[1] = versus.getTeam2() * 4;
                    break;
                }
            }
            return mScore;
        } else
            return mScore;

    }
}