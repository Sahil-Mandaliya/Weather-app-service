package com.weather.weather.dataSrc.user;

import com.weather.weather.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityDataSrc extends JpaRepository<City,Long> {
    City findByNameAndRegion(String name, String region);
}
