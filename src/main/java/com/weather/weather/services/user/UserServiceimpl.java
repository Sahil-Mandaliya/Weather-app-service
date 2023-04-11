package com.weather.weather.services.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.weather.config.DBConfig;
import com.weather.weather.controller.user.Status;
import com.weather.weather.dataSrc.user.CityDataSrc;
import com.weather.weather.dataSrc.user.UserCityMappingDataSrc;
import com.weather.weather.entities.City;
import com.weather.weather.entities.UserCityMapping;
import com.weather.weather.entities.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import com.weather.weather.dataSrc.user.UserDataSrc;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceimpl implements UserService {

    @Autowired
    private UserDataSrc userDataSrc;

    @Autowired
    private CityDataSrc cityDataSrc;

    @Autowired
    private UserCityMappingDataSrc cityMappingDataSrc;

    @Override
    public List<User> getAllUsers() {
        List<User> l = new ArrayList<>();
//        l.add(new User(1,"name","email@gmail.com","password"));
        l = userDataSrc.findAll();
        return l;
    }

    @Override
    public User addNewUser(User user) {
        User u = userDataSrc.save(user);
        return u;
    }

    @Override
    public List<City> getSavedCity(Long userId) {
        List<City> cities =  new ArrayList<>();
        String query = "select ucm.user_id, c.id, c.name, c.region, c.country, c.latitude, c.longitude " +
                "from user_city_mapping as ucm join city as c on ucm.city_id = c.id " +
                "where ucm.user_id = ? and ucm.is_deleted = 0";
        try {
            Connection con = DBConfig.getDBConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setLong(1,userId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Long cityId = rs.getLong("id");
                String cityName = rs.getString("name");
                String cityRegion = rs.getString("region");
                String cityCountry = rs.getString("country");
                Float latitude = rs.getFloat("latitude");
                Float longitude = rs.getFloat("longitude");

                cities.add(new City(cityId,cityName,cityRegion,cityCountry,latitude,longitude));
            }
        } catch (SQLException e) {
            return cities;
        }
        return cities;
    }

    public Status changeBookmarkStatus(Long userId, City city, Short newStatus) {
        try {
            ObjectMapper obj = new ObjectMapper();

            User user = userDataSrc.findById(userId).get();
            if(user.getId() != userId) {
                return new Status(false,"Invalid user","400");
            }

            String query = "select * from city where name = ? and region = ?";
            Connection con = DBConfig.getDBConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1,city.getName());
            stmt.setString(2,city.getRegion());

            ResultSet rs = stmt.executeQuery();
            Boolean cityExists = false;
            while (rs.next()) {
                Long id = rs.getLong("id");
                if(id > 0 ) {
                    city.setId(id);
                    cityExists = true;
                }
            }
            if(!cityExists) {
                city = userDataSrc.save(city);
            }

            // USER CITY MAPPINGS
            stmt = con.prepareStatement("select * from user_city_mapping where user_id = ? and city_id = ? ");
            stmt.setLong(1,userId);
            stmt.setLong(2,city.getId());

            rs = stmt.executeQuery();
            UserCityMapping ucm= new UserCityMapping(city.getId(),userId,  (short)newStatus);
            while (rs.next()) {
                ucm.setId(rs.getLong("id"));
                ucm.setUserId(rs.getLong("user_id"));
                ucm.setCityId(rs.getLong("city_id"));
            }

            UserCityMapping newUserCityMapping = userDataSrc.save(ucm);
            if(newStatus == 0) {
                return new Status(true,"Added to watch list","200");
            }
            return new Status(true,"Removed from watch list","200");
        } catch(NoSuchElementException e) {
            return new Status(false,"Invalid user / city","400");
        } catch (Exception e) {
            return new Status(false,"Something went wrong","400");
        }
    }
    @Override
    public Status bookmarkCity(Long userId, City city) {
        return changeBookmarkStatus(userId,city,(short) 0);
    }
    @Override
    public Status removeFromBookmark(Long userId, City city) {
        return changeBookmarkStatus(userId,city,(short) 1);
    }
}

