package com.sapient.football.util;

public class Constants {
    public static final String API_VERSONING = "/api/v1";
    public static final String FOOTBALL_API_BASEURL = "https://apiv2.apifootball.com/?";
    public static final String FOOTBALL_COUNTRIES_API= FOOTBALL_API_BASEURL+"action=get_countries";
    public static final String FOOTBALL_COMPETITION_API= FOOTBALL_API_BASEURL+"action=get_leagues&country_id=";
    public static final String FOOTBALL_STANDING_API= FOOTBALL_API_BASEURL+"action=get_standings&league_id=";
    public static final String FOOTBALL_TEAM_API= FOOTBALL_API_BASEURL+"action=get_teams&league_id=";


}
