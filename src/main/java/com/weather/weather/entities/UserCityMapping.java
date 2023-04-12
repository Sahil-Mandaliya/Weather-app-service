package com.weather.weather.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "user_city_mapping")
public class UserCityMapping {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty("id")
    Long id;
    @Column(name = "city_id")
    @JsonProperty("city_id")
    Long cityId;
    @Column(name = "user_id")
    @JsonProperty("user_id")
    Long userId;
    @Column(name = "is_deleted")
    @JsonProperty("is_deleted")
    Short isDeleted;

    public UserCityMapping() {
    }

    public UserCityMapping(Long cityId, Long userId, Short isDeleted) {
        this.cityId = cityId;
        this.userId = userId;
        this.isDeleted = isDeleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Short getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Short isDeleted) {
        this.isDeleted = isDeleted;
    }
}
