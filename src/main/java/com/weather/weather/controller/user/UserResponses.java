package com.weather.weather.controller.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.weather.weather.entities.City;
import com.weather.weather.weatherExternalApis.WeatherApiResponse;

import java.util.ArrayList;
import java.util.List;

public class UserResponses {

}
//
//@JsonIgnoreProperties(ignoreUnknown = true)
//public class Status {
//    @JsonProperty("success")
//    Boolean success;
//    @JsonProperty("message")
//    String message;
//    @JsonProperty("code")
//    String code;
//
//    public Status(Boolean success, String message, String code) {
//        this.success = success;
//        this.message = message;
//        this.code = code;
//    }
//}

@JsonIgnoreProperties(ignoreUnknown = true)
class BookmarkCityRequest {
    @JsonProperty("user_id")
    private Long userId;
    @JsonProperty("city_data")
    private City cityData;

    public BookmarkCityRequest() {
    }

    public BookmarkCityRequest(Long userId, City cityData) {
        this.userId = userId;
        this.cityData = cityData;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public City getCityData() {
        return cityData;
    }

    public void setCityData(City cityData) {
        this.cityData = cityData;
    }
}
@JsonIgnoreProperties(ignoreUnknown = true)
class UserSavedCitiesResponse {
    @JsonProperty("user_id")
    Long userId;
    @JsonProperty("name")
    String name;
    @JsonProperty("city_data")
    List<WeatherApiResponse> cityData;
    @JsonProperty("error")
    Error error;

    public UserSavedCitiesResponse() {
    }

    public UserSavedCitiesResponse(Long userId, String name, List<WeatherApiResponse> cityData, Error error) {
        this.userId = userId;
        this.name = name;
        this.cityData = cityData;
        this.error = error;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCityData(List<WeatherApiResponse> cityData) {
        this.cityData = cityData;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public List<WeatherApiResponse> getCityData() {
        return this.cityData;
    }

    public void setCityData(ArrayList<WeatherApiResponse> cityData) {
        this.cityData = cityData;
    }
}

class RemoveFromBookmarkRequest {
    @JsonProperty("user_id")
    Long userId;

    @JsonProperty("city_id")
    Long cityId;

    public RemoveFromBookmarkRequest() {
    }

    public RemoveFromBookmarkRequest(Long userId, Long cityId) {
        this.userId = userId;
        this.cityId = cityId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }
}