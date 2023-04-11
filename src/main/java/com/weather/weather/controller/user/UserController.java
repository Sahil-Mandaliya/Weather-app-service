package com.weather.weather.controller.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.weather.entities.user.User;
import com.weather.weather.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/create_user")
    public User addNewUser(@RequestBody User user) {
        return userService.addNewUser(user);
    }

    @GetMapping("/user_saved_cities")
    public UserSavedCitiesResponse getUserSavedCitiesData(@RequestParam("user_id") Long userId) {
        UserSavedCitiesResponse res = new UserSavedCitiesResponse();
        res.userId =  userId;
        res.cityData = userService.getSavedCity(userId);
        return res;
    }

    @PostMapping("/bookmark_city")
    public Status BookmarkCityForAUser(@RequestBody BookmarkCityRequest cityData) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Status status = userService.bookmarkCity(cityData.getUserId(),cityData.getCityData());
            return status;
        } catch (Exception e) {
            return new Status(false,e.getMessage()   ,"");
        }
    }

    @PostMapping("/remove_from_bookmark")
    public Status removeFromBookmark(@RequestBody BookmarkCityRequest req) {
        try {
            return userService.removeFromBookmark(req.getUserId(), req.getCityData());
        } catch (Exception e) {
            return new Status(false,"Something went wrong","");
        }
    }
}
