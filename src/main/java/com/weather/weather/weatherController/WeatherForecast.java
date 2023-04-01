package com.weather.weather.weatherController;

import com.weather.weather.weatherExternalApis.WeatherResponse;
import com.weather.weather.weatherService.WeatherService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherForecast {
    @Autowired
    private WeatherService weatherService;
    @GetMapping("/")
    @CrossOrigin(origins = "http://localhost:3000")
    WeatherResponse getCurrentWeather(@PathParam("query") String query) {
        String city = query;
        System.out.println("city =" + city);
        if(city == "" || city == null) {
            city = "Mumbai";
        }
        return weatherService.getWeatherData(city);
    }
}
