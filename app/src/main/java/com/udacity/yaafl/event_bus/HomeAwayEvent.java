package com.udacity.yaafl.event_bus;


public class HomeAwayEvent
{
    private final int HOME_AWAY_SCORE;
    private final boolean HOME_AWAY_FLAG;

    public HomeAwayEvent(int score,boolean flag)
    {
        this.HOME_AWAY_SCORE = score;
        this.HOME_AWAY_FLAG = flag;

    }

    public int getHomeAwayScore()
    {
        return HOME_AWAY_SCORE;
    }

    public boolean isHomeOrAway()
    {
        return HOME_AWAY_FLAG;
    }

}
