package com.sapient.football.service;

import com.sapient.football.model.Competetions;
import com.sapient.football.model.Countries;
import com.sapient.football.model.FootballResponseDto;
import com.sapient.football.model.Standings;
import com.sapient.football.util.RestRequestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class FootballServiceTest {
    @Mock
    private RestRequestUtils restRequestUtils;

    @InjectMocks
    private FootballService footballService;

    @Test
    public void testStanding() throws Exception{
        List<Countries> countriesList = new ArrayList<>();
        Countries countries = new Countries();
        countries.setCountryId("123");
        countries.setCountryName("France");
        countriesList.add(countries);

        Competetions competetions = new Competetions();
        competetions.setCountryId("123");
        competetions.setCountryName("France");
        competetions.setLeagueName("League-22");
        competetions.setLeagueId("League-22");
        List<Competetions> competetionsList = new ArrayList<>();
        competetionsList.add(competetions);

        Standings standings = new Standings();
        standings.setCountryName("France");
        standings.setLeagueId("League-22");
        standings.setOverallLeaguePosition("11");
        standings.setTeamName("Team1");
        standings.setTeamId("Team1");
        List<Standings> standingsList = new ArrayList<>();
        standingsList.add(standings);

        Mockito.when(restRequestUtils.getStandings(Mockito.anyString())).thenReturn(standingsList);
        Mockito.when(restRequestUtils.getCountries(Mockito.anyString())).thenReturn(countriesList);
        Mockito.when(restRequestUtils.getCompetitions(Mockito.anyString())).thenReturn(competetionsList);
        List<FootballResponseDto> footballResponseDtos = footballService.getTeamStanding(null,null,null);
        Assertions.assertTrue(footballResponseDtos.get(0).getCountryName().equalsIgnoreCase("France"));
    }

}
