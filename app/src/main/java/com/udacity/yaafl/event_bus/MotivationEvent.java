package com.udacity.yaafl.event_bus;


public class MotivationEvent
{
    private final int MOTIVATION_SCORE;

    public MotivationEvent(int score)
    {
        this.MOTIVATION_SCORE = score;
    }

    public int getMotivationScore()
    {
        return MOTIVATION_SCORE;
    }
}
