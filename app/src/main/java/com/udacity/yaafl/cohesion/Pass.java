
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
    "AwayFactor",
    "Cross",
    "HomeFactor",
    "LongBall",
    "ShortPass",
    "Team",
    "ThroughBall"
})
public class Pass {

    @JsonProperty("AwayFactor")
    private Boolean awayFactor;
    @JsonProperty("Cross")
    private Integer cross;
    @JsonProperty("HomeFactor")
    private Boolean homeFactor;
    @JsonProperty("LongBall")
    private Integer longBall;
    @JsonProperty("ShortPass")
    private Integer shortPass;
    @JsonProperty("Team")
    private String team;
    @JsonProperty("ThroughBall")
    private Integer throughBall;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The awayFactor
     */
    @JsonProperty("AwayFactor")
    public Boolean getAwayFactor() {
        return awayFactor;
    }

    /**
     * 
     * @param awayFactor
     *     The AwayFactor
     */
    @JsonProperty("AwayFactor")
    public void setAwayFactor(Boolean awayFactor) {
        this.awayFactor = awayFactor;
    }

    /**
     * 
     * @return
     *     The cross
     */
    @JsonProperty("Cross")
    public Integer getCross() {
        return cross;
    }

    /**
     * 
     * @param cross
     *     The Cross
     */
    @JsonProperty("Cross")
    public void setCross(Integer cross) {
        this.cross = cross;
    }

    /**
     * 
     * @return
     *     The homeFactor
     */
    @JsonProperty("HomeFactor")
    public Boolean getHomeFactor() {
        return homeFactor;
    }

    /**
     * 
     * @param homeFactor
     *     The HomeFactor
     */
    @JsonProperty("HomeFactor")
    public void setHomeFactor(Boolean homeFactor) {
        this.homeFactor = homeFactor;
    }

    /**
     * 
     * @return
     *     The longBall
     */
    @JsonProperty("LongBall")
    public Integer getLongBall() {
        return longBall;
    }

    /**
     * 
     * @param longBall
     *     The LongBall
     */
    @JsonProperty("LongBall")
    public void setLongBall(Integer longBall) {
        this.longBall = longBall;
    }

    /**
     * 
     * @return
     *     The shortPass
     */
    @JsonProperty("ShortPass")
    public Integer getShortPass() {
        return shortPass;
    }

    /**
     * 
     * @param shortPass
     *     The ShortPass
     */
    @JsonProperty("ShortPass")
    public void setShortPass(Integer shortPass) {
        this.shortPass = shortPass;
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
     *     The throughBall
     */
    @JsonProperty("ThroughBall")
    public Integer getThroughBall() {
        return throughBall;
    }

    /**
     * 
     * @param throughBall
     *     The ThroughBall
     */
    @JsonProperty("ThroughBall")
    public void setThroughBall(Integer throughBall) {
        this.throughBall = throughBall;
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
