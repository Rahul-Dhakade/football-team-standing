package com.sapient.football.util;

import com.sapient.football.model.Competetions;
import com.sapient.football.model.Countries;
import com.sapient.football.model.Standings;
import com.sapient.football.model.Teams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Component
public class RestRequestUtils {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.key}")
    private String apiKey;

    private HttpHeaders headers(){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        return headers;
    }

    private UriComponents uriComponents(String uri){

        UriComponents builder = UriComponentsBuilder.fromHttpUrl(uri)
                .queryParam("APIkey",apiKey).build();
        return builder;
    }

    @Cacheable(value = "countries")
    public  List<Countries> getCountries(String uri){
        HttpEntity<String> requestEntity = new HttpEntity<>(null, headers());
        ResponseEntity<List<Countries>> response = restTemplate.exchange(uriComponents(uri).toUriString(), HttpMethod.GET, requestEntity,
                new ParameterizedTypeReference<List<Countries>>(){});
        return response.getBody();
    }

    @Cacheable(value = "competitions")
    public  List<Competetions> getCompetitions(String uri){
        HttpEntity<String> requestEntity = new HttpEntity<>(null, headers());
        ResponseEntity<List<Competetions>> response = restTemplate.exchange(uriComponents(uri).toUriString(), HttpMethod.GET, requestEntity,
                new ParameterizedTypeReference<List<Competetions>>(){});
        return response.getBody();
    }

    @Cacheable(value = "teams")
    public  List<Teams> getTeams(String uri){
        HttpEntity<String> requestEntity = new HttpEntity<>(null, headers());
        ResponseEntity<List<Teams>> response = restTemplate.exchange(uriComponents(uri).toUriString(), HttpMethod.GET, requestEntity,
                new ParameterizedTypeReference<List<Teams>>(){});
        return response.getBody();
    }

    @Cacheable(value = "standings")
    public  List<Standings> getStandings(String uri){
        HttpEntity<String> requestEntity = new HttpEntity<>(null, headers());
        ResponseEntity<List<Standings>> response = restTemplate.exchange(uriComponents(uri).toUriString(), HttpMethod.GET, requestEntity,
                new ParameterizedTypeReference<List<Standings>>(){});
        return response.getBody();
    }
}
