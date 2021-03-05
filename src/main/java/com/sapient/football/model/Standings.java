package com.sapient.football.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Standings {
    @JsonProperty("country_name")
    private String countryName;

    @JsonProperty("league_name")
    private String leagueName;

    @JsonProperty("league_id")
    private String leagueId;

    @JsonProperty("team_id")
    private String teamName;

    @JsonProperty("team_name")
    private String teamId;

    @JsonProperty("overall_league_position")
    private String overallLeaguePosition;

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public String getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(String leagueId) {
        this.leagueId = leagueId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getOverallLeaguePosition() {
        return overallLeaguePosition;
    }

    public void setOverallLeaguePosition(String overallLeaguePosition) {
        this.overallLeaguePosition = overallLeaguePosition;
    }
}
