package com.allInOne.allInOneV1.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.allInOne.allInOneV1.model.Restaurant;
import com.allInOne.allInOneV1.model.RestaurantBooking;
import com.allInOne.allInOneV1.model.User;
import com.allInOne.allInOneV1.repository.RestaurantBookingRepositoryCustom;

@Repository
@Transactional
public class RestaurantBookingRepositoryImpl implements RestaurantBookingRepositoryCustom{
	
	 @PersistenceContext
	    EntityManager entityManager;

	 @Override
		public List<RestaurantBooking> getAllBookings(int user_id) {
			Query query = entityManager.createNativeQuery("SELECT * FROM restaurant_booking  " +
	                "WHERE user_id LIKE ?1", RestaurantBooking.class);
	        query.setParameter(1, user_id);
	        return query.getResultList();
		}

	
}
