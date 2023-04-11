package com.weather.weather.weatherExternalApis;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
class Location {
//    @JsonProperty("city_reference_id")
//    private String cityReferenceId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("region")
    private String region;
    @JsonProperty("country")
    private String country;
    @JsonProperty("localtime")
    private String localtime;

    public String getLocaltime() {
        return localtime;
    }

    public void setLocaltime(String localtime) {
        this.localtime = localtime;
    }

    public Location() {
//        cityReferenceId="";
        name="";
        region="";
        country="";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", country='" + country + '\'' +
                ", localtime='" + localtime + '\'' +
                '}';
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Current {
    @JsonProperty("temp_c")
    private Float tempC;
    @JsonProperty("is_day")
    private Integer isDay;
    @JsonProperty("condition")
    private Condition condition;

    @JsonProperty("wind_mph")
    private Integer windMph;

    @JsonProperty("wind_degree")
    private Integer windDegree;

    @JsonProperty("wind_dir")
    private String windDirection;

    @JsonProperty("humidity")
    private Integer humidity;

    public Current() {

    }

    public Float getTempC() {
        return tempC;
    }

    public void setTempC(Float tempC) {
        this.tempC = tempC;
    }

    public Integer getDay() {
        return isDay;
    }

    public void setDay(Integer day) {
        this.isDay = day;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public Integer getWindMph() {
        return windMph;
    }

    public Integer getWindDegree() {
        return windDegree;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public Integer getHumidity() {
        return humidity;
    }

    @Override
    public String toString() {
        return "Current{" +
                "tempC=" + tempC +
                ", isDay=" + isDay +
                ", condition=" + condition +
                ", windMph=" + windMph +
                ", windDegree=" + windDegree +
                ", windDirection=" + windDirection +
                ", humidity=" + humidity +
                '}';
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Condition  {
    @JsonProperty("text")
    String text;
    @JsonProperty("icon")
    String icon;

    public Condition() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "Condition{" +
                "text='" + text + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}


@JsonIgnoreProperties(ignoreUnknown = true)
class Error  {
    @JsonProperty("code")
    Integer text;
    @JsonProperty("message")
    String message;

    public Error() {
    }

    public Integer getText() {
        return text;
    }

    public void setText(Integer text) {
        this.text = text;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Error{" +
                "text=" + text +
                ", message='" + message + '\'' +
                '}';
    }
}
//
//@JsonIgnoreProperties(ignoreUnknown = true)
//class Forecast {
//    @JsonProperty("forecastday")
//    ArrayList<ForecastDayData> forecastDay;
//}
//
//@JsonIgnoreProperties(ignoreUnknown = true)
//class ForecastDayData {
//    @JsonProperty("date")
//    String date;
//    @JsonProperty("astro")
//    AstroData astro;
//    @JsonProperty("hour")
//    ArrayList<HourData> hourData;
//}
//
//@JsonIgnoreProperties(ignoreUnknown = true)
//class AstroData {
//
//}
//
//@JsonIgnoreProperties(ignoreUnknown = true)
//class HourData {
//    @JsonProperty("time")
//    String time;
//    @JsonProperty("temp_c")
//    Float tempC;
//    @JsonProperty("condition")
//    Condition condition;
//    @JsonProperty("wind_mph")
//    Float windMph;
//    @JsonProperty("humidity")
//    Float humidity;
//}
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherApiResponse {
    @JsonProperty("location")
    Location location;
    @JsonProperty("current")
    Current current;
//    @JsonProperty("forecast")
//    Forecast forecast;
    @JsonProperty("error")
    Error error;

    @JsonProperty("isBookMarkedCity")
    Boolean isBookmarkedCity;

    public WeatherApiResponse() {
        isBookmarkedCity = false;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public Boolean getBookmarkedCity() {
        return isBookmarkedCity;
    }

    public void setBookmarkedCity(Boolean bookmarkedCity) {
        isBookmarkedCity = bookmarkedCity;
    }

    @Override
    public String toString() {
        return "WeatherApiResponse{" +
                "location=" + location +
                ", current=" + current +
                ", error=" + error +
                ", isBookmarkedCity=" + isBookmarkedCity +
                '}';
    }
}
