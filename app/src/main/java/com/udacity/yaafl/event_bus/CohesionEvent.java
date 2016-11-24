package com.udacity.yaafl.event_bus;

public class CohesionEvent
{
    private final int COHESION_SCORE;
    private final boolean FLAG;

    public CohesionEvent(int cohesion,boolean flag)
    {
        this.COHESION_SCORE = cohesion;
        this.FLAG = flag;
    }

    public int getCohesionScore()
    {
        return COHESION_SCORE;
    }

    public boolean isHomeorAway()
    {
        return FLAG;
    }
}
