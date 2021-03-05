package com.sapient.football.model;

public class FootballResponseDto {
    private String countryName;
    private String countryId;
    private String leagueName;
    private String leagueId;
    private String teamName;
    private String teamId;
    private String overallLeaguePosition;

    public FootballResponseDto(){}
    public FootballResponseDto(Standings standings){
        this.countryName = standings.getCountryName();
        this.leagueName = standings.getLeagueName();
        this.leagueId = standings.getLeagueId();
        this.teamName = standings.getTeamName();
        this.teamId = standings.getTeamId();
        this.overallLeaguePosition = standings.getOverallLeaguePosition();
    }

    public FootballResponseDto(String countryName, String countryId, String leagueName, String leagueId, String teamName, String teamId, String overallLeaguePosition) {
        this.countryName = countryName;
        this.countryId = countryId;
        this.leagueName = leagueName;
        this.leagueId = leagueId;
        this.teamName = teamName;
        this.teamId = teamId;
        this.overallLeaguePosition = overallLeaguePosition;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
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

    @Override
    public String toString() {
        return "FootballResponseDto{" +
                "countryName='" + countryName + '\'' +
                ", countryId='" + countryId + '\'' +
                ", leagueName='" + leagueName + '\'' +
                ", leagueId='" + leagueId + '\'' +
                ", teamName='" + teamName + '\'' +
                ", teamId='" + teamId + '\'' +
                ", overallLeaguePosition='" + overallLeaguePosition + '\'' +
                '}';
    }
}
