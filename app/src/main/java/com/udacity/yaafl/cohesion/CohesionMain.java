
package com.udacity.yaafl.cohesion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Head2Head",
    "Passes",
    "Recent",
    "Shots",
    "Situational",
    "Stats",
    "Summary"
})
public class CohesionMain {

    @JsonProperty("Head2Head")
    private List<Head2Head> head2Head = new ArrayList<Head2Head>();
    @JsonProperty("Passes")
    private List<Pass> passes = new ArrayList<Pass>();
    @JsonProperty("Recent")
    private List<Recent> recent = new ArrayList<Recent>();
    @JsonProperty("Shots")
    private List<Shot> shots = new ArrayList<Shot>();
    @JsonProperty("Situational")
    private List<Situational> situational = new ArrayList<Situational>();
    @JsonProperty("Stats")
    private Stats stats;
    @JsonProperty("Summary")
    private List<Summary> summary = new ArrayList<Summary>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The head2Head
     */
    @JsonProperty("Head2Head")
    public List<Head2Head> getHead2Head() {
        return head2Head;
    }

    /**
     * 
     * @param head2Head
     *     The Head2Head
     */
    @JsonProperty("Head2Head")
    public void setHead2Head(List<Head2Head> head2Head) {
        this.head2Head = head2Head;
    }

    /**
     * 
     * @return
     *     The passes
     */
    @JsonProperty("Passes")
    public List<Pass> getPasses() {
        return passes;
    }

    /**
     * 
     * @param passes
     *     The Passes
     */
    @JsonProperty("Passes")
    public void setPasses(List<Pass> passes) {
        this.passes = passes;
    }

    /**
     * 
     * @return
     *     The recent
     */
    @JsonProperty("Recent")
    public List<Recent> getRecent() {
        return recent;
    }

    /**
     * 
     * @param recent
     *     The Recent
     */
    @JsonProperty("Recent")
    public void setRecent(List<Recent> recent) {
        this.recent = recent;
    }

    /**
     * 
     * @return
     *     The shots
     */
    @JsonProperty("Shots")
    public List<Shot> getShots() {
        return shots;
    }

    /**
     * 
     * @param shots
     *     The Shots
     */
    @JsonProperty("Shots")
    public void setShots(List<Shot> shots) {
        this.shots = shots;
    }

    /**
     * 
     * @return
     *     The situational
     */
    @JsonProperty("Situational")
    public List<Situational> getSituational() {
        return situational;
    }

    /**
     * 
     * @param situational
     *     The Situational
     */
    @JsonProperty("Situational")
    public void setSituational(List<Situational> situational) {
        this.situational = situational;
    }

    /**
     * 
     * @return
     *     The stats
     */
    @JsonProperty("Stats")
    public Stats getStats() {
        return stats;
    }

    /**
     * 
     * @param stats
     *     The Stats
     */
    @JsonProperty("Stats")
    public void setStats(Stats stats) {
        this.stats = stats;
    }

    /**
     * 
     * @return
     *     The summary
     */
    @JsonProperty("Summary")
    public List<Summary> getSummary() {
        return summary;
    }

    /**
     * 
     * @param summary
     *     The Summary
     */
    @JsonProperty("Summary")
    public void setSummary(List<Summary> summary) {
        this.summary = summary;
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
