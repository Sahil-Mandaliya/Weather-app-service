package com.weather.weather.controller.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Status {
    @JsonProperty("success")
    Boolean success;
    @JsonProperty("message")
    String message;
    @JsonProperty("code")
    String code;

    public Status(Boolean success, String message, String code) {
        this.success = success;
        this.message = message;
        this.code = code;
    }
}
