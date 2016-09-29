package com.udacity.yaafl.event_bus;

public class CohesionEvent
{
    private final int COHESION_SCORE;

    public CohesionEvent(int cohesion)
    {
        this.COHESION_SCORE = cohesion;
    }

    public int getCohesionScore()
    {
        return COHESION_SCORE;
    }
}
