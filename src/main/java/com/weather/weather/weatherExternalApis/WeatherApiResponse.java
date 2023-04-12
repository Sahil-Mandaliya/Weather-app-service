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
    @JsonProperty("lat")
    private Float latitude;
    @JsonProperty("lon")
    private Float longitude;
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

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", country='" + country + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
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
    @JsonProperty("success")
    Boolean success;
    @JsonProperty("code")
    Integer text;
    @JsonProperty("message")
    String message;

    public Error() {
    }

    public Error(Boolean success, Integer text, String message) {
        this.success = success;
        this.text = text;
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
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

    public WeatherApiResponse(Location location, Current current, Error error, Boolean isBookmarkedCity) {
        this.location = location;
        this.current = current;
        this.error = error;
        this.isBookmarkedCity = isBookmarkedCity;
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

class BulkRequestResponse {
    @JsonProperty("bulk")
    ArrayList<Bulk> bulk;

    public BulkRequestResponse() {
    }

    public ArrayList<Bulk> getBulk() {
        return bulk;
    }

    public void setBulk(ArrayList<Bulk> bulk) {
        this.bulk = bulk;
    }

    @Override
    public String toString() {
        return "BulkRequestResponse{" +
                "bulk=" + bulk +
                '}';
    }
}

class Bulk {
    @JsonProperty("query")
    Query query;

    public Bulk() {
    }

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

    @Override
    public String toString() {
        return "Bulk{" +
                "query=" + query +
                '}';
    }
}

class Query {
    @JsonProperty("custom_id")
    String customId;
    @JsonProperty("q")
    String query;
    @JsonProperty("location")
    Location location;
    @JsonProperty("current")
    Current current;

    public Query() {
    }

    public String getCustomId() {
        return customId;
    }

    public void setCustomId(String customId) {
        this.customId = customId;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
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

    @Override
    public String toString() {
        return "Query{" +
                "customId='" + customId + '\'' +
                ", query='" + query + '\'' +
                ", location=" + location +
                ", current=" + current +
                '}';
    }
}