package com.weather.weather.services.user;

import com.weather.weather.controller.user.Status;
import com.weather.weather.entities.City;
import com.weather.weather.entities.user.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();

    public User addNewUser(User user);
    public List<City> getSavedCity(Long userId);

    public Status bookmarkCity(Long userId, City city);

//    public Status removeFromBookmark(Long userId, Long cityId);removeFromBookmark
    public Status removeFromBookmark(Long userId, City city);
}
