package com.allInOne.allInOneV1.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.allInOne.allInOneV1.model.Restaurant;
import com.allInOne.allInOneV1.model.RestaurantBooking;
import com.allInOne.allInOneV1.model.Review;
import com.allInOne.allInOneV1.model.User;
import com.allInOne.allInOneV1.repository.RestaurantRepositoryCustom;

@Repository
@Transactional
public class RestaurantRepositoryImpl implements RestaurantRepositoryCustom{

    @PersistenceContext
    EntityManager entityManager;
    
	@Override
	public List<Restaurant> getRestaurantNamesLike(String restaurant_name) {
		Query query = entityManager.createNativeQuery("SELECT * FROM Restaurant  " +
                "WHERE restaurant_name LIKE ?1", Restaurant.class);
        query.setParameter(1, restaurant_name + "%");
        return query.getResultList();
	}
	
	@Override
	public List<Restaurant> getTopRestaurants(int count) {
		Query query = entityManager.createQuery("SELECT m FROM Restaurant m JOIN OverallRating r ON " +
                "m.rating.overallRatingId = r.overallRatingId ORDER BY r.overallRatingValue DESC");
        return query.setMaxResults(count).getResultList();
	}

	@Override
	public void postRestaurantReview(Review review) {
//		Query query = entityManager.createNativeQuery("SELECT u.* FROM user u JOIN user_community_organization uco ON "
//                + "u.user_id = uco.user_id "
//                + "WHERE uco.community_id = ?1 "
//                + "AND lower(u.email) = ?2", User.class)
//                .setParameter(1, communityId)
//                .setParameter(2, email.toLowerCase());
		
	}

	@Override
	public void update(Restaurant restaurant) {
		entityManager.merge(restaurant);
	    return;
	}

	
}
