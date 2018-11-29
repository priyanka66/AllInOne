package com.allInOne.allInOneV1.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.allInOne.allInOneV1.service.SendSMS;
import com.allInOne.allInOneV1.model.Movie;
import com.allInOne.allInOneV1.model.OverallRating;
import com.allInOne.allInOneV1.model.Restaurant;
import com.allInOne.allInOneV1.repository.OverallRatingRepository;
import com.allInOne.allInOneV1.repository.RestaurantRepository;


@RestController
@RequestMapping(path="/restaurant")
public class RestaurantController {
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Autowired
	private OverallRatingRepository overallRatingrepository;
	
	SendSMS sms = new SendSMS();
	
	@RequestMapping(path="/add", method = RequestMethod.POST, produces = "application/json")
	ResponseEntity createRestaurant(@RequestBody Restaurant newRestaurant) {

		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, "application/json");
		restaurantRepository.save(newRestaurant);

		return ResponseEntity.status(HttpStatus.CREATED)
				.headers(headers)
				.body(newRestaurant);
	}

	@RequestMapping(path="/all", method = RequestMethod.GET)
	public ResponseEntity <Iterable<Restaurant>> getAllUsers() {
		return new ResponseEntity<>(restaurantRepository.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(path="/restaurantName", method = RequestMethod.GET, produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<Restaurant> getRestaurantNamesLike(@RequestParam("restaurantName") String name) {
        return restaurantRepository.getRestaurantNamesLike(name);
    }

    @RequestMapping(path="/top", method = RequestMethod.GET, produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<Restaurant> getRestaurantNamesLike(@RequestParam("count") int count) {
        return restaurantRepository.getTopRestaurants(count);
    }
    
	
	@RequestMapping(path="/{restaurantId}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Restaurant restaurant(@PathVariable(value = "restaurantId") int restaurantId) {
		Restaurant restaurant = verifyRestaurant(restaurantId);
		return restaurant;
	}
	
//    @RequestMapping(path="/{restaurantId}/rating", method = RequestMethod.POST)
//    @ResponseStatus(HttpStatus.CREATED)
//    public void createRestaurantRating(@PathVariable(value = "restaurantId") int restaurantId, @RequestBody OverallRating overallRatingValue) {
//    	Restaurant restaurant = verifyRestaurant(restaurantId);
//    	OverallRating newOverallRating = new OverallRating();
//    	overallRatingrepository.save(newOverallRating);
//    	restaurant.setRating(newOverallRating);
//    	restaurantRepository.save(restaurant);
//    	sms.sendSMS("+13153954566", "+2012385937");
////        sms.sendSMS("+13159499748","+13203350324");
//    }

	private Restaurant verifyRestaurant(int restaurantId) throws NoSuchElementException {
		Restaurant restaurant = restaurantRepository.findById(restaurantId).get();

        if (restaurant == null) {
            throw new NoSuchElementException("Restaurant does not exist " + restaurantId);
        }

        return restaurant;
	}
}
