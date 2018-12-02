package com.allInOne.allInOneV1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.allInOne.allInOneV1.model.Restaurant;
import com.allInOne.allInOneV1.model.User;
import org.springframework.stereotype.Repository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer>, RestaurantRepositoryCustom {

	
}
