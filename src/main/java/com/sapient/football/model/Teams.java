package com.sapient.football.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Teams {
    /**
     * "team_key": "2611",
     *     "team_name": "Leicester",
     */
    @JsonProperty("team_key")
    private String teamKey;

    @JsonProperty("team_name")
    private String teamName;

    @JsonProperty("coaches")
    private List<Object> coaches;

    @JsonProperty("players")
    private List<Object> players;

    public String getTeamKey() {
        return teamKey;
    }

    public void setTeamKey(String teamKey) {
        this.teamKey = teamKey;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public List<Object> getCoaches() {
        return coaches;
    }

    public void setCoaches(List<Object> coaches) {
        this.coaches = coaches;
    }

    public List<Object> getPlayers() {
        return players;
    }

    public void setPlayers(List<Object> players) {
        this.players = players;
    }
}
