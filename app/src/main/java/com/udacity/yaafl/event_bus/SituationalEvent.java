package com.udacity.yaafl.event_bus;


public class SituationalEvent
{
    private final double summary;
    private final int pass;
    private final int shots;
    private final int situational;

    public SituationalEvent(double summ,int pass,int shots,int situational)
    {
        this.summary = summ;
        this.pass = pass;
        this.shots = shots;
        this.situational = situational;
    }

    public double getSummary()
    {
        return summary;
    }

    public int getPass()
    {
        return pass;
    }

    public int getShots()
    {
        return shots;
    }

    public int getSituational()
    {
        return situational;
    }
}
