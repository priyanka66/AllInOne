package com.allInOne.allInOneV1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.allInOne.allInOneV1.model.Movie;
import com.allInOne.allInOneV1.model.Restaurant;
import com.allInOne.allInOneV1.model.RestaurantBooking;
import com.allInOne.allInOneV1.repository.RestaurantBookingRepository;
import com.allInOne.allInOneV1.repository.RestaurantRepository;

@RestController
@RequestMapping(path="/restaurantBooking")
public class RestaurantBookingController {

	@Autowired
	private RestaurantBookingRepository restaurantBookingRepository;

	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@RequestMapping(path="/all", method = RequestMethod.GET, produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<RestaurantBooking> getAllBookings(@RequestParam("userId") int userId) {
        return restaurantBookingRepository.getAllBookings(userId);
    }

	@RequestMapping(path="/add", method = RequestMethod.POST, produces = "application/json")
	ResponseEntity createRestaurant(@RequestBody RestaurantBooking newRestaurantBooking) {

		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, "application/json");
		restaurantBookingRepository.save(newRestaurantBooking);

		updateAvailableSeats(newRestaurantBooking.getRestaurant().getRestaurantId(), 
				newRestaurantBooking.getNumSeats());

		return ResponseEntity.status(HttpStatus.CREATED)
				.headers(headers)
				.body(newRestaurantBooking);
		
		
	}

	private void updateAvailableSeats(int restaurantId, int reservedSeats) {
		Restaurant restaurant = restaurantRepository.getOne(restaurantId);
		restaurant.setAvailableSeats(restaurant.getAvailableSeats()-reservedSeats);
		restaurantRepository.update(restaurant);
	}
}
