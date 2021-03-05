package com.sapient.football.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sapient.football.model.FootballResponseDto;
import com.sapient.football.service.FootballService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class FootballControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FootballService footballService;

    private static ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testGetExample() throws Exception {
        List<FootballResponseDto> footballResponseDtos = new ArrayList<>();
        FootballResponseDto footballResponseDto = new FootballResponseDto();
        footballResponseDto.setCountryId("England");
        footballResponseDtos.add(footballResponseDto);
        Mockito.when(footballService.getTeamStanding(Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn(footballResponseDtos);
        mockMvc.perform(get("/api/v1/football/standing")).andExpect(status().isOk());
    }
}
