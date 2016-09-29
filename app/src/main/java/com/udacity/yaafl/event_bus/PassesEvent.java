package com.udacity.yaafl.event_bus;


public class PassesEvent
{
    private final double summary_score;
    private final int passes_score;

    public PassesEvent(double summary,int passes)
    {
        this.summary_score = summary;
        this.passes_score = passes;
    }

    public double getSummaryScore()
    {
        return summary_score;
    }

    public int getPassesScore()
    {
        return passes_score;
    }
}
