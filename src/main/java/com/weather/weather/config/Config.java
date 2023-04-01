package com.weather.weather.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties("weatherapi")
public class Config {
    private String baseURL;
    private String getCurrentDataURL;

    public String getBaseURL() {
        return baseURL;
    }

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }

    public String getGetCurrentDataURL() {
        return getCurrentDataURL;
    }

    public void setGetCurrentDataURL(String getCurrentDataURL) {
        this.getCurrentDataURL = getCurrentDataURL;
    }
}