package com.weather.weather.weatherExternalApis;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class BulkRequest {
    @JsonProperty("locations")
    ArrayList<LocationReq> locations;

    public BulkRequest() {
        locations = new ArrayList<LocationReq>();
    }

    public ArrayList<LocationReq> getLocations() {
        return locations;
    }

    public void setLocations(ArrayList<LocationReq> locations) {
        this.locations = locations;
    }

    @Override
    public String toString() {
        return "BulkRequest{" +
                "locations=" + locations +
                '}';
    }
}

class LocationReq {
    @JsonProperty("q")
    String query;

    @JsonProperty("custom_id")
    String customId;

    public LocationReq() {
    }

    public LocationReq(String query, String customId) {
        this.query = query;
        this.customId = customId;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getCustomId() {
        return customId;
    }

    public void setCustomId(String customId) {
        this.customId = customId;
    }

    @Override
    public String toString() {
        return "LocationReq{" +
                "query='" + query + '\'' +
                ", customId='" + customId + '\'' +
                '}';
    }
}
