package com.udacity.yaafl.event_bus;


public class WinEvent
{
    private final int homeScore;
    private final int awayScore;
    private final int homeID;
    private final int awayID;

    public WinEvent(int homeScore,int awayScore,int homeID,int awayID)
    {
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this.homeID = homeID;
        this.awayID = awayID;
    }

    public int getHomeScore()
    {
        return homeScore;
    }

    public int getAwayScore()
    {
        return awayScore;
    }

    public int getHomeID()
    {
        return homeID;
    }

    public int getAwayID()
    {
        return awayID;
    }
}
