package com.weather.weather.weatherController;

import com.weather.weather.weatherExternalApis.WeatherResponse;
import com.weather.weather.weatherService.WeatherService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class WeatherForecast {
    @Autowired
    private WeatherService weatherService;
    @GetMapping("/")
    @CrossOrigin(origins = "http://localhost:3000")
    WeatherResponse getCurrentWeather(@RequestParam(name="city_name",required=false) String cityName,
                                      @RequestParam(name="city_region",required=false) String cityRegion,
                                      @RequestParam(name="user_id",required=false) Long userId
    ) {
        if(cityName == "" || cityName == null) {
            cityName = "Mumbai";
            cityRegion = "Maharashtra";
        }
        if(userId == null) {
            userId = 0l;
        }
        return weatherService.getWeatherData(userId,cityName,cityRegion);
    }
}
