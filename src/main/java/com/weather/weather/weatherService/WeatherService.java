package com.weather.weather.weatherService;

import com.weather.weather.weatherExternalApis.WeatherResponse;

public interface WeatherService {
    WeatherResponse getWeatherData(Long userId,String cityName, String cityRegion);
}
