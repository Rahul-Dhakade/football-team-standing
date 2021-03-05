package com.sapient.football.service;

import com.sapient.football.model.*;
import com.sapient.football.util.RestRequestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.sapient.football.util.Constants.*;

@Service
public class FootballService {
    Logger logger = LoggerFactory.getLogger(FootballService.class);

    @Autowired
    private RestRequestUtils restRequestUtils;

    public List<FootballResponseDto> getTeamStanding(String countryName, String teamName, String leagueName) {
        logger.info("Inside service to get team standing countryName{}:teamName:{} leagueName:{}",countryName,
                teamName,leagueName);

        List<Countries> countriesList = restRequestUtils.getCountries(FOOTBALL_COUNTRIES_API);

        List<FootballResponseDto> footballResponseDtoList = new ArrayList<>();

        for (Countries countries : countriesList) {

            List<Competetions> competetionsList = restRequestUtils.getCompetitions(FOOTBALL_COMPETITION_API+ countries.getCountryId());

            for (Competetions competetions : competetionsList) {

                List<Standings> standingsList = restRequestUtils.getStandings(FOOTBALL_STANDING_API+ competetions.getLeagueId());
                for (Standings standings: standingsList){

                    if(!StringUtils.isEmpty(countryName) && !StringUtils.isEmpty(leagueName) && !StringUtils.isEmpty(teamName)){
                        if(countryName.equalsIgnoreCase(standings.getCountryName()) && leagueName.equalsIgnoreCase(standings.getLeagueName())
                                && teamName.equalsIgnoreCase(standings.getTeamName())){
                            getFootBallStanding(footballResponseDtoList,standings,countries);
                        }
                    }else if(!StringUtils.isEmpty(countryName) &&  !StringUtils.isEmpty(leagueName) ){
                        if(countryName.equalsIgnoreCase(standings.getCountryName()) && leagueName.equalsIgnoreCase(standings.getLeagueName())){
                            getFootBallStanding(footballResponseDtoList,standings,countries);
                        }
                    }else if(!StringUtils.isEmpty(countryName) &&  !StringUtils.isEmpty(teamName) ){
                        if(countryName.equalsIgnoreCase(standings.getCountryName()) && teamName.equalsIgnoreCase(standings.getTeamName())){
                            getFootBallStanding(footballResponseDtoList,standings,countries);
                        }
                    }else if(!StringUtils.isEmpty(leagueName) &&  !StringUtils.isEmpty(teamName) ){
                        if(leagueName.equalsIgnoreCase(standings.getLeagueName()) && teamName.equalsIgnoreCase(standings.getTeamName())){
                            getFootBallStanding(footballResponseDtoList,standings,countries);
                        }
                    }else if(!StringUtils.isEmpty(leagueName)){
                        if(leagueName.equalsIgnoreCase(standings.getLeagueName())){
                            getFootBallStanding(footballResponseDtoList,standings,countries);
                        }
                    }else if(!StringUtils.isEmpty(teamName)){
                        if(teamName.equalsIgnoreCase(standings.getTeamName())){
                            getFootBallStanding(footballResponseDtoList,standings,countries);
                        }
                    }else if(!StringUtils.isEmpty(countryName)){
                        if(countryName.equalsIgnoreCase(countries.getCountryName())){
                            getFootBallStanding(footballResponseDtoList,standings,countries);
                        }
                    }else if(StringUtils.isEmpty(countryName) && StringUtils.isEmpty(leagueName) && StringUtils.isEmpty(teamName)){
                        getFootBallStanding(footballResponseDtoList,standings,countries);
                    }
                }
            }
        }
        return footballResponseDtoList;
    }

    private void getFootBallStanding(List<FootballResponseDto> footballResponseDtoList,
                                                    Standings standings,Countries countries){
        FootballResponseDto footballResponseDto = new FootballResponseDto(standings);
        footballResponseDto.setCountryName(countries.getCountryName());
        footballResponseDto.setCountryId(countries.getCountryId());
        footballResponseDtoList.add(footballResponseDto);
    }
}
