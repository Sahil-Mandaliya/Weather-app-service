package com.weather.weather.dataSrc.user;

import com.weather.weather.entities.UserCityMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserCityMappingDataSrc extends JpaRepository<UserCityMapping,Long> {
//    @Modifying
//    @Query("update UserCityMapping u set u.isDeleted = :is_deleted where u.userId = :user_id  and u.cityId = :city_id")
//    void updateDeleteStatus(@Param(value = "is_deleted") Short isDeleted, @Param(value = "user_id") Long userId, @Param(value = "city_id") Long cityId);
    UserCityMapping findByUserIdAndCityId(Long userId, Long cityId);
}
