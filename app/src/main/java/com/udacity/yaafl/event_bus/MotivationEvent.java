package com.udacity.yaafl.event_bus;


public class MotivationEvent
{
    private final int MOTIVATION_SCORE;
    private final boolean FLAG;

    public MotivationEvent(int score,boolean flag)
    {
        this.MOTIVATION_SCORE = score;
        this.FLAG = flag;
    }

    public int getMotivationScore()
    {
        return MOTIVATION_SCORE;
    }

    public boolean isHomeOrAway()
    {
        return FLAG;
    }
}
