package com.weather.weather.weatherExternalApis;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.weather.weather.entities.City;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeatherAPIs {
    String City;

    public WeatherAPIs() {
    }

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

    ArrayList<WeatherApiResponse> convertToSuccessResponse(BulkRequestResponse bulkRes) {
        ArrayList<WeatherApiResponse> res = new ArrayList<WeatherApiResponse>();
        for(Bulk response : bulkRes.getBulk()) {
            Query q = response.getQuery();
            res.add(new WeatherApiResponse(
                q.getLocation(),q.getCurrent(),null,true
            ));
        }
        return res;
    }

//    ArrayList<WeatherApiResponse> convertToErrorResponseResponse(BulkRequestResponse bulkRes) {
//        ArrayList<WeatherApiResponse> res = new ArrayList<WeatherApiResponse>();
//        res.add(new WeatherApiResponse(
//                new Location(),new Current(),new Error(false,500,"Something went wrong"),true
//        ));
//        return res;
//    }

    public List<WeatherApiResponse> getBulkWeatherDataFromWeatherApi(ArrayList<City> cities) throws IOException {
        String baseURL="http://api.weatherapi.com/v1/";
        String getURL="current.json";

        HttpHeaders headers = new HttpHeaders();
        BulkRequest bulkReq =  new BulkRequest();

        LocationReq loc = new LocationReq();
        for(City c:cities) {
            bulkReq.locations.add(new LocationReq(c.getName(),c.getId().toString()));
        }
        HttpEntity<BulkRequest> requestEntity = new HttpEntity<>(bulkReq,headers);
        String urlTemplate = UriComponentsBuilder.fromHttpUrl(baseURL+getURL)
                .queryParam("key", "{key}")
                .queryParam("q", "{q}")
                .encode()
                .toUriString();

        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("key", "d6380343be614533abb201619233003");
        uriVariables.put("q", "bulk");

        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<Map> response = restTemplate.exchange(
                urlTemplate,
                HttpMethod.POST,
                requestEntity,
                Map.class,
                uriVariables
        );
        ObjectMapper mapper = new ObjectMapper();
        BulkRequestResponse bulkResponse = mapper.convertValue(response.getBody(),BulkRequestResponse.class);
        return convertToSuccessResponse(bulkResponse);

    }
}
