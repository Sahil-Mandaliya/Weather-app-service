package com.weather.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
//		(exclude = {DataSourceAutoConfiguration.class })
public class WeatherForecastApplication {
	public static void main(String[] args) {
		SpringApplication.run(WeatherForecastApplication.class, args);
	}

}
