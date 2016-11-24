
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
    "OffTarget",
    "OnTarget",
    "Team",
    "Total"
})
public class Shot {

    @JsonProperty("OffTarget")
    private Double offTarget;
    @JsonProperty("OnTarget")
    private Double onTarget;
    @JsonProperty("Team")
    private String team;
    @JsonProperty("Total")
    private Double total;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The offTarget
     */
    @JsonProperty("OffTarget")
    public Double getOffTarget() {
        return offTarget;
    }

    /**
     * 
     * @param offTarget
     *     The OffTarget
     */
    @JsonProperty("OffTarget")
    public void setOffTarget(Double offTarget) {
        this.offTarget = offTarget;
    }

    /**
     * 
     * @return
     *     The onTarget
     */
    @JsonProperty("OnTarget")
    public Double getOnTarget() {
        return onTarget;
    }

    /**
     * 
     * @param onTarget
     *     The OnTarget
     */
    @JsonProperty("OnTarget")
    public void setOnTarget(Double onTarget) {
        this.onTarget = onTarget;
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
     *     The total
     */
    @JsonProperty("Total")
    public Double getTotal() {
        return total;
    }

    /**
     * 
     * @param total
     *     The Total
     */
    @JsonProperty("Total")
    public void setTotal(Double total) {
        this.total = total;
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
