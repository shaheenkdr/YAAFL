package com.udacity.yaafl.firebase_db;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Draw",
        "MatchID",
        "Team1",
        "Team2"
})
public class Head2Head {

    @JsonProperty("Draw")
    private Integer draw;
    @JsonProperty("MatchID")
    private String matchID;
    @JsonProperty("Team1")
    private Integer team1;
    @JsonProperty("Team2")
    private Integer team2;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The draw
     */
    @JsonProperty("Draw")
    public Integer getDraw() {
        return draw;
    }

    /**
     *
     * @param draw
     * The Draw
     */
    @JsonProperty("Draw")
    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    /**
     *
     * @return
     * The matchID
     */
    @JsonProperty("MatchID")
    public String getMatchID() {
        return matchID;
    }

    /**
     *
     * @param matchID
     * The MatchID
     */
    @JsonProperty("MatchID")
    public void setMatchID(String matchID) {
        this.matchID = matchID;
    }

    /**
     *
     * @return
     * The team1
     */
    @JsonProperty("Team1")
    public Integer getTeam1() {
        return team1;
    }

    /**
     *
     * @param team1
     * The Team1
     */
    @JsonProperty("Team1")
    public void setTeam1(Integer team1) {
        this.team1 = team1;
    }

    /**
     *
     * @return
     * The team2
     */
    @JsonProperty("Team2")
    public Integer getTeam2() {
        return team2;
    }

    /**
     *
     * @param team2
     * The Team2
     */
    @JsonProperty("Team2")
    public void setTeam2(Integer team2) {
        this.team2 = team2;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}