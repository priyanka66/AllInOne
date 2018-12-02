package com.allInOne.allInOneV1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.allInOne.allInOneV1.model.RestaurantBooking;

public interface RestaurantBookingRepository extends JpaRepository<RestaurantBooking, Integer>, RestaurantBookingRepositoryCustom {

}
