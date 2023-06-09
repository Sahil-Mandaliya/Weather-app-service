package com.weather.weather.weatherService;

import com.weather.weather.weatherExternalApis.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class weatherServiceImpl implements WeatherService {
    @Autowired
    private WeatherResponse weatherResponse;

    @Override
    public WeatherResponse getWeatherData(Long userId, String cityName, String cityRegion) {
        return weatherResponse.weatherDataFromWeatherApi(userId, cityName, cityRegion);
    }
}
