package com.weather.weather.weatherExternalApis;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.weather.weather.dataSrc.user.CityDataSrc;
import com.weather.weather.dataSrc.user.UserCityMappingDataSrc;
import com.weather.weather.entities.City;
import com.weather.weather.entities.UserCityMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class WeatherResponse {
    @JsonProperty("status")
    private HttpStatus status;
    @JsonProperty("message")
    private String message;
    @JsonProperty("weather_data")
    private WeatherApiResponse weatherApiResponse;
    @JsonProperty("user_id")
    private Long userId;
    @JsonProperty("user_saved_cities_data")
    private ArrayList<WeatherApiResponse> userSavedCitiesData;

    @Autowired
    UserCityMappingDataSrc userCityMappingDataSrc;

    @Autowired
    CityDataSrc cityDataSrc;
    public WeatherResponse() {
    }

    public WeatherResponse(HttpStatus status, String message, WeatherApiResponse weatherApiResponse) {
        this.status = status;
        this.message = message;
        this.weatherApiResponse = weatherApiResponse;
    }

    public WeatherResponse(HttpStatus status, String message, WeatherApiResponse weatherApiResponse, Long userId, ArrayList<WeatherApiResponse> userSavedCitiesData) {
        this.status = status;
        this.message = message;
        this.weatherApiResponse = weatherApiResponse;
        this.userId = userId;
        this.userSavedCitiesData = userSavedCitiesData;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public ArrayList<WeatherApiResponse> getUserSavedCitiesData() {
        return userSavedCitiesData;
    }

    public void setUserSavedCitiesData(ArrayList<WeatherApiResponse> userSavedCitiesData) {
        this.userSavedCitiesData = userSavedCitiesData;
    }

    public WeatherResponse weatherDataFromWeatherApi(Long userId,String cityName, String cityRegion) {
        try {
            WeatherAPIs res = new WeatherAPIs(cityName);
            WeatherApiResponse weatherApiResponse= res.getWeatherDataFromWeatherApi();

            if(userId > 0 && cityRegion != null && cityRegion != "") {
                City city = cityDataSrc.findByNameAndRegion(cityName,cityRegion);
                if(city!= null && city.getId() > 0 ){
                    UserCityMapping ucm = userCityMappingDataSrc.findByUserIdAndCityId(userId,city.getId());
                    if(ucm.getId() > 0 && ucm.getIsDeleted() == 0) {
                        weatherApiResponse.setBookmarkedCity(true);
                    }
                }
            }
            return new WeatherResponse(HttpStatus.OK, "Success", weatherApiResponse,userId,new ArrayList());
        } catch (Exception e) {
            return new WeatherResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), null);
        }
    }
}
