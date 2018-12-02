package com.allInOne.allInOneV1.repository;

		import java.util.List;
		import java.util.Optional;

		import com.allInOne.allInOneV1.model.Restaurant;
		import com.allInOne.allInOneV1.model.RestaurantBooking;
		import com.allInOne.allInOneV1.model.Review;

public interface RestaurantRepositoryCustom {
	List<Restaurant> getRestaurantNamesLike(String restaurant_name);
	List<Restaurant> getTopRestaurants(int count);

	public void update(Restaurant restaurant);
	void postRestaurantReview(Review review);
}
