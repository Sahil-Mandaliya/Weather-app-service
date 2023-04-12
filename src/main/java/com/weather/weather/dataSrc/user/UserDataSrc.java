package com.weather.weather.dataSrc.user;

import com.weather.weather.entities.City;
import com.weather.weather.entities.UserCityMapping;
import com.weather.weather.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDataSrc extends JpaRepository<User,Long> {
    @Override
    <S extends User> S save(S entity);
    <S extends City> S save(S entity);
    <S extends UserCityMapping> S save(S entity);
}
