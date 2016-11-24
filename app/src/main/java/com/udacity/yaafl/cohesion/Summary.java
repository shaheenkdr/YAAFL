
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
    "Score",
    "Team"
})
public class Summary {

    @JsonProperty("Score")
    private Double score;
    @JsonProperty("Team")
    private String team;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The score
     */
    @JsonProperty("Score")
    public Double getScore() {
        return score;
    }

    /**
     * 
     * @param score
     *     The Score
     */
    @JsonProperty("Score")
    public void setScore(Double score) {
        this.score = score;
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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
