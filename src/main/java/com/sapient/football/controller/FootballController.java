package com.sapient.football.controller;

import com.sapient.football.model.FootballResponseDto;
import com.sapient.football.service.FootballService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.sapient.football.util.Constants.API_VERSONING;

@RestController
@RequestMapping(API_VERSONING)
public class FootballController {

    @Autowired
    private FootballService footballService;

    @GetMapping("/football/standing")
    public ResponseEntity<?> getStandingTeam(@RequestParam(name = "countryName", required = false) String countryName,
                                             @RequestParam(name = "leagueName",required = false) String leagueName, @RequestParam(name = "teamName",required = false) String teamName){

        List<FootballResponseDto> footballResponseDtos = footballService.getTeamStanding(countryName,teamName,leagueName);
        return new ResponseEntity<>(footballResponseDtos, HttpStatus.OK);
    }
}
