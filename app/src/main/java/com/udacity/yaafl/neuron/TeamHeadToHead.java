package com.udacity.yaafl.neuron;


import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

import com.udacity.yaafl.sqlite.TeamProvider;
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
    private Context mContext;

    private List<com.udacity.yaafl.cohesion.Head2Head> head;

    public TeamHeadToHead(List<com.udacity.yaafl.cohesion.Head2Head> head, int team1, int team2, Context mContext) {
        this.head = head;
        this.mTeam1Id = team1;
        this.mTeam2Id = team2;
        mScore = new int[2];
        this.mContext = mContext;
    }

    public int[] computeScore() {
        final String MID = generateMatchId(TeamInfo.getTeamNameHead(mTeam1Id) + " VS " + TeamInfo.getTeamNameHead(mTeam2Id));

        if (!MID.equals("")) {
            for (com.udacity.yaafl.cohesion.Head2Head versus : head) {

                if (versus.getMatchID().equals(MID)) {
                    mScore[0] = versus.getTeam1() * 4;
                    mScore[1] = versus.getTeam2() * 4;
                    Log.e("" + mScore[0], "" + mScore[1]);
                    break;
                }
            }
            return mScore;
        } else
            return mScore;

    }

    public String generateMatchId(String x) {
        String URL = "content://com.udacity.yaafl.sqlite.TeamProvider";
        String match_code = "";

        Uri teams = Uri.parse(URL);
        Cursor c = mContext.getContentResolver().query(teams, null, null, null, "matchteam");

        if (c.moveToFirst()) {
            do {
                if (c.getString(c.getColumnIndex(TeamProvider.MATCH_TEAM)).equals(x)) {

                    match_code = c.getString(c.getColumnIndex(TeamProvider.MATCH_CODE));
                }
            } while (c.moveToNext());
        }
        c.close();

        return match_code;
    }
}