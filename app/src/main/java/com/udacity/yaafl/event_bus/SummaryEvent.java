package com.udacity.yaafl.event_bus;


public class SummaryEvent
{
    private final double SUMMARY_SCORE;

    public SummaryEvent(double score)
    {
        this.SUMMARY_SCORE = score;
    }

    public double getSummaryScore()
    {
        return SUMMARY_SCORE;
    }
}
