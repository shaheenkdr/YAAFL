
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
    "Away_Win",
    "Draw",
    "Home_Win"
})
public class Stats {

    @JsonProperty("Away_Win")
    private Double awayWin;
    @JsonProperty("Draw")
    private Double draw;
    @JsonProperty("Home_Win")
    private Double homeWin;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The awayWin
     */
    @JsonProperty("Away_Win")
    public Double getAwayWin() {
        return awayWin;
    }

    /**
     * 
     * @param awayWin
     *     The Away_Win
     */
    @JsonProperty("Away_Win")
    public void setAwayWin(Double awayWin) {
        this.awayWin = awayWin;
    }

    /**
     * 
     * @return
     *     The draw
     */
    @JsonProperty("Draw")
    public Double getDraw() {
        return draw;
    }

    /**
     * 
     * @param draw
     *     The Draw
     */
    @JsonProperty("Draw")
    public void setDraw(Double draw) {
        this.draw = draw;
    }

    /**
     * 
     * @return
     *     The homeWin
     */
    @JsonProperty("Home_Win")
    public Double getHomeWin() {
        return homeWin;
    }

    /**
     * 
     * @param homeWin
     *     The Home_Win
     */
    @JsonProperty("Home_Win")
    public void setHomeWin(Double homeWin) {
        this.homeWin = homeWin;
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
