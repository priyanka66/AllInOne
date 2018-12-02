//package com.allInOne.allInOneV1.service;
//
//import com.allInOne.allInOneV1.model.RestaurantBooking;
//import com.allInOne.allInOneV1.model.TheatreBooking;
//import com.allInOne.allInOneV1.repository.TheatreBookingRespositoryCustom;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.Query;
//import javax.transaction.Transactional;
//import java.util.ArrayList;
//import java.util.List;
//
//@Repository
//@Transactional
//public class TheatreBookingRepositoryImpl implements TheatreBookingRespositoryCustom{
//
//	 @PersistenceContext
//	    EntityManager entityManager;
//
//	 @Override
//		public List<TheatreBooking> getAllBookings(int user_id) {
////			Query query = entityManager.createNativeQuery("SELECT * FROM restaurant_booking  " +
////	                "WHERE user_id LIKE ?1", RestaurantBooking.class);
////	        query.setParameter(1, user_id);
////	        return query.getResultList();
//		 return new ArrayList<>();
//		}
//
//
//}
