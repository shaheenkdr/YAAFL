package com.udacity.yaafl.firebase_db;

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
        "Team",
        "games"
})
public class Recent {

    @JsonProperty("Team")
    private String team;
    @JsonProperty("games")
    private List<Integer> games = new ArrayList<Integer>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The team
     */
    @JsonProperty("Team")
    public String getTeam() {
        return team;
    }

    /**
     *
     * @param team
     * The Team
     */
    @JsonProperty("Team")
    public void setTeam(String team) {
        this.team = team;
    }

    /**
     *
     * @return
     * The games
     */
    @JsonProperty("games")
    public List<Integer> getGames() {
        return games;
    }

    /**
     *
     * @param games
     * The games
     */
    @JsonProperty("games")
    public void setGames(List<Integer> games) {
        this.games = games;
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