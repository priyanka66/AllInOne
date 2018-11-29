package com.allInOne.allInOneV1.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RestaurantBooking")
public class RestaurantBooking {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer restaurantBookingId;

	@OneToOne
	@JoinColumn(name="restaurant_id", nullable=false)
	private Restaurant restaurant;

	private Date startTime;

	private Date endTime;

	private int numSeats;

	private String status;
	
	@OneToOne
	@JoinColumn(name="user_id", nullable=false)
	private User user;

	public Integer getRestaurantBookingId() {
		return restaurantBookingId;
	}

	public void setRestaurantBookingId(Integer restaurantBookingId) {
		this.restaurantBookingId = restaurantBookingId;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public int getNumSeats() {
		return numSeats;
	}

	public void setNumSeats(int numSeats) {
		this.numSeats = numSeats;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
