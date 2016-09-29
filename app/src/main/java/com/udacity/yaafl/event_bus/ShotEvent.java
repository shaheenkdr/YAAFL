package com.udacity.yaafl.event_bus;


public class ShotEvent
{
    private final double summary;
    private final int pass;
    private final int shots;

    public ShotEvent(double summ,int pass,int shots)
    {
        this.summary = summ;
        this.pass = pass;
        this.shots = shots;
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
}
