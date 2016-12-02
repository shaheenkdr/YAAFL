package com.udacity.yaafl.neuron;


import com.udacity.yaafl.utility.TeamInfo;

import java.util.List;

/**
 *Neuron that calculates the motivation level of a team
 */
public class TeamMotivation
{
    private int team_id;
    private boolean home_away;
    private int home_away_score;
    private int motivation_score;
    private List<com.udacity.yaafl.cohesion.Recent> recent;


    public TeamMotivation(List<com.udacity.yaafl.cohesion.Recent> recent,int teamId, boolean homeAway, int homeAwayScore)
    {
        this.recent = recent;
        this.team_id = teamId;
        this.home_away = homeAway;
        this.home_away_score = homeAwayScore;
        motivation_score = 0;

    }


    public int calculateMotivation()
    {
        for(com.udacity.yaafl.cohesion.Recent r:recent)
        {
            if(r.getTeam().equals(TeamInfo.getTeamName(team_id)))
            {
                List<Integer> values = r.getGames();
                int temp = 0;
                for(int i=0;i<values.size();i++)
                    temp+=values.get(i);
                temp = temp*10;

                if(home_away)
                {
                    motivation_score = temp+(TeamInfo.getHomeWinAvg()/4)+(home_away_score/4);
                }

                else
                {
                    motivation_score = temp+(TeamInfo.getAwayWinAvg()/4)+(home_away_score/4);
                }

            }

        }

        return motivation_score;

    }

}