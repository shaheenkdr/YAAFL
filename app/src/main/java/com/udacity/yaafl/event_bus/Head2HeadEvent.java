package com.udacity.yaafl.event_bus;


public class Head2HeadEvent
{
    private final int[] VERSUS_SCORE;

    public Head2HeadEvent(int[] score)
    {
        this.VERSUS_SCORE = score;
    }

    public int[] getHeadToHeadScore()
    {
        return VERSUS_SCORE;
    }

}
