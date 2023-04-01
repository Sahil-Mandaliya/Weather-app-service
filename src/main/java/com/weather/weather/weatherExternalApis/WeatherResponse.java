package com.weather.weather.weatherExternalApis;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class WeatherResponse {
    @JsonProperty("status")
    private HttpStatus status;
    @JsonProperty("message")
    private String message;
    @JsonProperty("weather_data")
    private WeatherApiResponse weatherApiResponse;

    public WeatherResponse() {
    }

    public WeatherResponse(HttpStatus status, String message, WeatherApiResponse weatherApiResponse) {
        this.status = status;
        this.message = message;
        this.weatherApiResponse = weatherApiResponse;
    }


    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public WeatherApiResponse getWeatherApiResponse() {
        return weatherApiResponse;
    }

    public void setWeatherApiResponse(WeatherApiResponse weatherApiResponse) {
        this.weatherApiResponse = weatherApiResponse;
    }

    public WeatherResponse weatherDataFromWeatherApi(String city) {
        try {
            WeatherAPIs res = new WeatherAPIs(city);
            WeatherApiResponse weatherApiResponse= res.getWeatherDataFromWeatherApi();
            return new WeatherResponse(HttpStatus.OK, "Success", weatherApiResponse);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new WeatherResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), null);
        }
    }
}
