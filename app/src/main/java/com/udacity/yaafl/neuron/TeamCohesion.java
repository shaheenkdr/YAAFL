package com.udacity.yaafl.neuron;



import com.udacity.yaafl.cohesion.Pass;
import com.udacity.yaafl.cohesion.Shot;

import com.udacity.yaafl.utility.TeamInfo;


import java.util.List;

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


    private List<com.udacity.yaafl.cohesion.Summary> summary;
    private List<com.udacity.yaafl.cohesion.Pass> passes;
    private List<com.udacity.yaafl.cohesion.Shot> shots;
    private List<com.udacity.yaafl.cohesion.Situational> situation;





    public TeamCohesion(int teamId, boolean homeAwayId, int homeAwayScore, List<com.udacity.yaafl.cohesion.Summary> summary, List<Pass> passes, List<Shot> shots, List<com.udacity.yaafl.cohesion.Situational> situation)
    {

        this.team_id = teamId;
        this.home_away_id = homeAwayId;
        this.home_away_score = homeAwayScore;
        this.summary = summary;
        this.passes = passes;
        this.shots = shots;
        this.situation = situation;


    }

    public int computeTeamCohesion()
    {
        int result = (getSummary()+getShots()+getPasses()+(getSituationalAnalysis()/2))/4;
        return 3*result;
    }


    private int getSummary()
    {

        for(com.udacity.yaafl.cohesion.Summary team_summary: summary)
        {
            if(team_summary.getTeam().equals(TeamInfo.getTeamName(team_id)))
            {

                double x = team_summary.getScore()*10;
                return (int)x;
            }
        }
        return 0;
    }

    private int getPasses()
    {
        int passes_score = 0;
        for(Pass pass_val:passes)
        {
            if(home_away_id)
            {

                if(pass_val.getTeam().equals(TeamInfo.getTeamName(team_id)) && pass_val.getHomeFactor())
                {
                    passes_score = pass_val.getCross()+pass_val.getLongBall()+(pass_val.getShortPass()/10)+(pass_val.getThroughBall()*10);
                }
            }
            else
            {

                if(pass_val.getTeam().equals(TeamInfo.getTeamName(team_id)) && pass_val.getAwayFactor())
                {
                    passes_score = pass_val.getCross()+pass_val.getLongBall()+(pass_val.getShortPass()/10)+(pass_val.getThroughBall()*10);
                }

            }
        }
        return  passes_score;
    }

    private int getShots()
    {
        int score=0;
        for(Shot s:shots)
        {
            if(s.getTeam().equals(TeamInfo.getTeamName(team_id)))
            {
                score = (int)((s.getOnTarget()/s.getTotal())*100);
                break;
            }
        }
        return  score;
    }

    private int getSituationalAnalysis()
    {
        int ret_score =0;

            if(home_away_id)
            {
                for(com.udacity.yaafl.cohesion.Situational s_data:situation)
                {

                    if(s_data.getTeam().equals(TeamInfo.getTeamName(team_id)) && s_data.getHome())
                    {
                        final int lose = s_data.getLose()*-10;
                        final int won = (int)(((double)s_data.getWon()/(double)s_data.getMatchPlayed())*10);
                        final int open = s_data.getOpenPlay()*5;
                        final int set_piece = s_data.getSetPiece()*10;
                        final int own_goal = s_data.getOwnGoal()*-10;
                        ret_score = lose+won+open+set_piece+own_goal;
                        break;
                    }
                }
            }
            else
            {
                for(com.udacity.yaafl.cohesion.Situational s_data:situation)
                {

                    if(s_data.getTeam().equals(TeamInfo.getTeamName(team_id)) && s_data.getAway())
                    {
                        final int lose = s_data.getLose()*-5;
                        final int won = (int)(((double)s_data.getWon()/(double)s_data.getMatchPlayed())*20);
                        final int open = s_data.getOpenPlay()*7;
                        final int set_piece = s_data.getSetPiece()*20;
                        final int own_goal = s_data.getOwnGoal()*-5;
                        ret_score = lose+won+open+set_piece+own_goal;
                        break;
                    }

                }

            }

        return ret_score;

    }

}