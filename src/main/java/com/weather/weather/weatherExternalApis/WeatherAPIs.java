package com.weather.weather.weatherExternalApis;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WeatherAPIs {
    String City;

    public WeatherAPIs(String city) {
        City = city;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public WeatherApiResponse getWeatherDataFromWeatherApi() throws IOException {
        String baseURL="http://api.weatherapi.com/v1/";
        String getURL="current.json";

        HttpHeaders headers = new HttpHeaders();
        HttpEntity requestEntity = new HttpEntity<>(headers);

        String urlTemplate = UriComponentsBuilder.fromHttpUrl(baseURL+getURL)
                .queryParam("key", "{key}")
                .queryParam("q", "{q}")
                .encode()
                .toUriString();

        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("key", "d6380343be614533abb201619233003");
        uriVariables.put("q", getCity()==null ? "Mumbai":getCity());

        RestTemplate restTemplate = new RestTemplate();
        try {
            HttpEntity<Map> response = restTemplate.exchange(
                    urlTemplate,
                    HttpMethod.GET,
                    requestEntity,
                    Map.class,
                    uriVariables
            );
            ObjectMapper mapper = new ObjectMapper();
            WeatherApiResponse weatherResponse = mapper.convertValue(response.getBody(),WeatherApiResponse.class);
            weatherResponse.setBookmarkedCity(false);
            return weatherResponse;
        } catch(HttpClientErrorException e) {
            ObjectMapper mapper = new ObjectMapper();
            WeatherApiResponse weatherResponse = mapper.readValue(e.getResponseBodyAsString(),WeatherApiResponse.class);
            return weatherResponse;
        }

    }
}
