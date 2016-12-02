package com.udacity.yaafl.neuron;


import com.udacity.yaafl.utility.TeamInfo;


import java.util.List;

/**
 * Neuron to measure the head to head match results of
 * two teams to be played and generate score .
 */

public class TeamHeadToHead
{
    private int team1_id;
    private int team2_id;
    private int[] score;

    private List<com.udacity.yaafl.cohesion.Head2Head> head;
    public TeamHeadToHead(List<com.udacity.yaafl.cohesion.Head2Head>head,int team1, int team2)
    {
        this.head = head;
        this.team1_id = team1;
        this.team2_id = team2;
        score = new int[2];
    }

    public int[] computeScore()
    {
        final String MID = TeamInfo.getMatchId(TeamInfo.getTeamName(team1_id)+" VS "+TeamInfo.getTeamName(team2_id));

                if(!MID.equals(""))
                {
                    for(com.udacity.yaafl.cohesion.Head2Head versus:head)
                    {

                        if(versus.getMatchID().equals(MID))
                        {
                            score[0] = versus.getTeam1()*4;
                            score[1] = versus.getTeam2()*4;
                            break;
                        }
                    }
                    return score;
                }
                else
                    return score;

    }
}