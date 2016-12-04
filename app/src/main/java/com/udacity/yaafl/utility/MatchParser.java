package com.udacity.yaafl.utility;


public class MatchParser {
    private final String MATCH_NAME;
    private final String MATCH_ID;

    public MatchParser(String MATCH_NAME, String MATCH_ID) {
        this.MATCH_NAME = MATCH_NAME;
        this.MATCH_ID = MATCH_ID;
    }

    public String getMatchName() {
        return MATCH_NAME;
    }

    public String getMatchId() {
        return MATCH_ID;
    }
}
