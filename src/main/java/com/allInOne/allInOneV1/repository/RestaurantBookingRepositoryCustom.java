package com.allInOne.allInOneV1.repository;

import java.util.List;

import com.allInOne.allInOneV1.model.RestaurantBooking;
import com.allInOne.allInOneV1.model.User;

public interface RestaurantBookingRepositoryCustom {
	List<RestaurantBooking> getAllBookings(int userId);
}
