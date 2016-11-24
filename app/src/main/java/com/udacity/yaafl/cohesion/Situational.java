
package com.udacity.yaafl.cohesion;

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
    "Away",
    "Counter_Attack",
    "Home",
    "Lose",
    "Match_Played",
    "Open_Play",
    "Own_goal",
    "Penalty",
    "Set_Piece",
    "Team",
    "Won"
})
public class Situational {

    @JsonProperty("Away")
    private Boolean away;
    @JsonProperty("Counter_Attack")
    private Integer counterAttack;
    @JsonProperty("Home")
    private Boolean home;
    @JsonProperty("Lose")
    private Integer lose;
    @JsonProperty("Match_Played")
    private Integer matchPlayed;
    @JsonProperty("Open_Play")
    private Integer openPlay;
    @JsonProperty("Own_goal")
    private Integer ownGoal;
    @JsonProperty("Penalty")
    private Integer penalty;
    @JsonProperty("Set_Piece")
    private Integer setPiece;
    @JsonProperty("Team")
    private String team;
    @JsonProperty("Won")
    private Integer won;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The away
     */
    @JsonProperty("Away")
    public Boolean getAway() {
        return away;
    }

    /**
     * 
     * @param away
     *     The Away
     */
    @JsonProperty("Away")
    public void setAway(Boolean away) {
        this.away = away;
    }

    /**
     * 
     * @return
     *     The counterAttack
     */
    @JsonProperty("Counter_Attack")
    public Integer getCounterAttack() {
        return counterAttack;
    }

    /**
     * 
     * @param counterAttack
     *     The Counter_Attack
     */
    @JsonProperty("Counter_Attack")
    public void setCounterAttack(Integer counterAttack) {
        this.counterAttack = counterAttack;
    }

    /**
     * 
     * @return
     *     The home
     */
    @JsonProperty("Home")
    public Boolean getHome() {
        return home;
    }

    /**
     * 
     * @param home
     *     The Home
     */
    @JsonProperty("Home")
    public void setHome(Boolean home) {
        this.home = home;
    }

    /**
     * 
     * @return
     *     The lose
     */
    @JsonProperty("Lose")
    public Integer getLose() {
        return lose;
    }

    /**
     * 
     * @param lose
     *     The Lose
     */
    @JsonProperty("Lose")
    public void setLose(Integer lose) {
        this.lose = lose;
    }

    /**
     * 
     * @return
     *     The matchPlayed
     */
    @JsonProperty("Match_Played")
    public Integer getMatchPlayed() {
        return matchPlayed;
    }

    /**
     * 
     * @param matchPlayed
     *     The Match_Played
     */
    @JsonProperty("Match_Played")
    public void setMatchPlayed(Integer matchPlayed) {
        this.matchPlayed = matchPlayed;
    }

    /**
     * 
     * @return
     *     The openPlay
     */
    @JsonProperty("Open_Play")
    public Integer getOpenPlay() {
        return openPlay;
    }

    /**
     * 
     * @param openPlay
     *     The Open_Play
     */
    @JsonProperty("Open_Play")
    public void setOpenPlay(Integer openPlay) {
        this.openPlay = openPlay;
    }

    /**
     * 
     * @return
     *     The ownGoal
     */
    @JsonProperty("Own_goal")
    public Integer getOwnGoal() {
        return ownGoal;
    }

    /**
     * 
     * @param ownGoal
     *     The Own_goal
     */
    @JsonProperty("Own_goal")
    public void setOwnGoal(Integer ownGoal) {
        this.ownGoal = ownGoal;
    }

    /**
     * 
     * @return
     *     The penalty
     */
    @JsonProperty("Penalty")
    public Integer getPenalty() {
        return penalty;
    }

    /**
     * 
     * @param penalty
     *     The Penalty
     */
    @JsonProperty("Penalty")
    public void setPenalty(Integer penalty) {
        this.penalty = penalty;
    }

    /**
     * 
     * @return
     *     The setPiece
     */
    @JsonProperty("Set_Piece")
    public Integer getSetPiece() {
        return setPiece;
    }

    /**
     * 
     * @param setPiece
     *     The Set_Piece
     */
    @JsonProperty("Set_Piece")
    public void setSetPiece(Integer setPiece) {
        this.setPiece = setPiece;
    }

    /**
     * 
     * @return
     *     The team
     */
    @JsonProperty("Team")
    public String getTeam() {
        return team;
    }

    /**
     * 
     * @param team
     *     The Team
     */
    @JsonProperty("Team")
    public void setTeam(String team) {
        this.team = team;
    }

    /**
     * 
     * @return
     *     The won
     */
    @JsonProperty("Won")
    public Integer getWon() {
        return won;
    }

    /**
     * 
     * @param won
     *     The Won
     */
    @JsonProperty("Won")
    public void setWon(Integer won) {
        this.won = won;
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
