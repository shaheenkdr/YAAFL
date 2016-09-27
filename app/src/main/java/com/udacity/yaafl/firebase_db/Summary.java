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
        "Arsenal",
        "Bournemouth",
        "Burnley",
        "Chelsea",
        "Crystal_Palace",
        "Everton",
        "Hull",
        "Leicester",
        "Liverpool",
        "Manchester_City",
        "Manchester_United",
        "Middlesbrough",
        "Southampton",
        "Stoke",
        "Sunderland",
        "Swansea",
        "Tottenham",
        "Watford",
        "West_Bromwich_Albion",
        "West_Ham"
})
public class Summary {

    @JsonProperty("Arsenal")
    private Double arsenal;
    @JsonProperty("Bournemouth")
    private Double bournemouth;
    @JsonProperty("Burnley")
    private Double burnley;
    @JsonProperty("Chelsea")
    private Double chelsea;
    @JsonProperty("Crystal_Palace")
    private Double crystalPalace;
    @JsonProperty("Everton")
    private Double everton;
    @JsonProperty("Hull")
    private Double hull;
    @JsonProperty("Leicester")
    private Double leicester;
    @JsonProperty("Liverpool")
    private Double liverpool;
    @JsonProperty("Manchester_City")
    private Double manchesterCity;
    @JsonProperty("Manchester_United")
    private Double manchesterUnited;
    @JsonProperty("Middlesbrough")
    private Double middlesbrough;
    @JsonProperty("Southampton")
    private Double southampton;
    @JsonProperty("Stoke")
    private Double stoke;
    @JsonProperty("Sunderland")
    private Double sunderland;
    @JsonProperty("Swansea")
    private Double swansea;
    @JsonProperty("Tottenham")
    private Double tottenham;
    @JsonProperty("Watford")
    private Double watford;
    @JsonProperty("West_Bromwich_Albion")
    private Double westBromwichAlbion;
    @JsonProperty("West_Ham")
    private Double westHam;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The arsenal
     */
    @JsonProperty("Arsenal")
    public Double getArsenal() {
        return arsenal;
    }

    /**
     *
     * @param arsenal
     * The Arsenal
     */
    @JsonProperty("Arsenal")
    public void setArsenal(Double arsenal) {
        this.arsenal = arsenal;
    }

    /**
     *
     * @return
     * The bournemouth
     */
    @JsonProperty("Bournemouth")
    public Double getBournemouth() {
        return bournemouth;
    }

    /**
     *
     * @param bournemouth
     * The Bournemouth
     */
    @JsonProperty("Bournemouth")
    public void setBournemouth(Double bournemouth) {
        this.bournemouth = bournemouth;
    }

    /**
     *
     * @return
     * The burnley
     */
    @JsonProperty("Burnley")
    public Double getBurnley() {
        return burnley;
    }

    /**
     *
     * @param burnley
     * The Burnley
     */
    @JsonProperty("Burnley")
    public void setBurnley(Double burnley) {
        this.burnley = burnley;
    }

    /**
     *
     * @return
     * The chelsea
     */
    @JsonProperty("Chelsea")
    public Double getChelsea() {
        return chelsea;
    }

    /**
     *
     * @param chelsea
     * The Chelsea
     */
    @JsonProperty("Chelsea")
    public void setChelsea(Double chelsea) {
        this.chelsea = chelsea;
    }

    /**
     *
     * @return
     * The crystalPalace
     */
    @JsonProperty("Crystal_Palace")
    public Double getCrystalPalace() {
        return crystalPalace;
    }

    /**
     *
     * @param crystalPalace
     * The Crystal_Palace
     */
    @JsonProperty("Crystal_Palace")
    public void setCrystalPalace(Double crystalPalace) {
        this.crystalPalace = crystalPalace;
    }

    /**
     *
     * @return
     * The everton
     */
    @JsonProperty("Everton")
    public Double getEverton() {
        return everton;
    }

    /**
     *
     * @param everton
     * The Everton
     */
    @JsonProperty("Everton")
    public void setEverton(Double everton) {
        this.everton = everton;
    }

    /**
     *
     * @return
     * The hull
     */
    @JsonProperty("Hull")
    public Double getHull() {
        return hull;
    }

    /**
     *
     * @param hull
     * The Hull
     */
    @JsonProperty("Hull")
    public void setHull(Double hull) {
        this.hull = hull;
    }

    /**
     *
     * @return
     * The leicester
     */
    @JsonProperty("Leicester")
    public Double getLeicester() {
        return leicester;
    }

    /**
     *
     * @param leicester
     * The Leicester
     */
    @JsonProperty("Leicester")
    public void setLeicester(Double leicester) {
        this.leicester = leicester;
    }

    /**
     *
     * @return
     * The liverpool
     */
    @JsonProperty("Liverpool")
    public Double getLiverpool() {
        return liverpool;
    }

    /**
     *
     * @param liverpool
     * The Liverpool
     */
    @JsonProperty("Liverpool")
    public void setLiverpool(Double liverpool) {
        this.liverpool = liverpool;
    }

    /**
     *
     * @return
     * The manchesterCity
     */
    @JsonProperty("Manchester_City")
    public Double getManchesterCity() {
        return manchesterCity;
    }

    /**
     *
     * @param manchesterCity
     * The Manchester_City
     */
    @JsonProperty("Manchester_City")
    public void setManchesterCity(Double manchesterCity) {
        this.manchesterCity = manchesterCity;
    }

    /**
     *
     * @return
     * The manchesterUnited
     */
    @JsonProperty("Manchester_United")
    public Double getManchesterUnited() {
        return manchesterUnited;
    }

    /**
     *
     * @param manchesterUnited
     * The Manchester_United
     */
    @JsonProperty("Manchester_United")
    public void setManchesterUnited(Double manchesterUnited) {
        this.manchesterUnited = manchesterUnited;
    }

    /**
     *
     * @return
     * The middlesbrough
     */
    @JsonProperty("Middlesbrough")
    public Double getMiddlesbrough() {
        return middlesbrough;
    }

    /**
     *
     * @param middlesbrough
     * The Middlesbrough
     */
    @JsonProperty("Middlesbrough")
    public void setMiddlesbrough(Double middlesbrough) {
        this.middlesbrough = middlesbrough;
    }

    /**
     *
     * @return
     * The southampton
     */
    @JsonProperty("Southampton")
    public Double getSouthampton() {
        return southampton;
    }

    /**
     *
     * @param southampton
     * The Southampton
     */
    @JsonProperty("Southampton")
    public void setSouthampton(Double southampton) {
        this.southampton = southampton;
    }

    /**
     *
     * @return
     * The stoke
     */
    @JsonProperty("Stoke")
    public Double getStoke() {
        return stoke;
    }

    /**
     *
     * @param stoke
     * The Stoke
     */
    @JsonProperty("Stoke")
    public void setStoke(Double stoke) {
        this.stoke = stoke;
    }

    /**
     *
     * @return
     * The sunderland
     */
    @JsonProperty("Sunderland")
    public Double getSunderland() {
        return sunderland;
    }

    /**
     *
     * @param sunderland
     * The Sunderland
     */
    @JsonProperty("Sunderland")
    public void setSunderland(Double sunderland) {
        this.sunderland = sunderland;
    }

    /**
     *
     * @return
     * The swansea
     */
    @JsonProperty("Swansea")
    public Double getSwansea() {
        return swansea;
    }

    /**
     *
     * @param swansea
     * The Swansea
     */
    @JsonProperty("Swansea")
    public void setSwansea(Double swansea) {
        this.swansea = swansea;
    }

    /**
     *
     * @return
     * The tottenham
     */
    @JsonProperty("Tottenham")
    public Double getTottenham() {
        return tottenham;
    }

    /**
     *
     * @param tottenham
     * The Tottenham
     */
    @JsonProperty("Tottenham")
    public void setTottenham(Double tottenham) {
        this.tottenham = tottenham;
    }

    /**
     *
     * @return
     * The watford
     */
    @JsonProperty("Watford")
    public Double getWatford() {
        return watford;
    }

    /**
     *
     * @param watford
     * The Watford
     */
    @JsonProperty("Watford")
    public void setWatford(Double watford) {
        this.watford = watford;
    }

    /**
     *
     * @return
     * The westBromwichAlbion
     */
    @JsonProperty("West_Bromwich_Albion")
    public Double getWestBromwichAlbion() {
        return westBromwichAlbion;
    }

    /**
     *
     * @param westBromwichAlbion
     * The West_Bromwich_Albion
     */
    @JsonProperty("West_Bromwich_Albion")
    public void setWestBromwichAlbion(Double westBromwichAlbion) {
        this.westBromwichAlbion = westBromwichAlbion;
    }

    /**
     *
     * @return
     * The westHam
     */
    @JsonProperty("West_Ham")
    public Double getWestHam() {
        return westHam;
    }

    /**
     *
     * @param westHam
     * The West_Ham
     */
    @JsonProperty("West_Ham")
    public void setWestHam(Double westHam) {
        this.westHam = westHam;
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