//package com.allInOne.allInOneV1.model;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "MovieBooking")
//public class MovieBooking {
//	
//	@Id
//	@GeneratedValue(strategy= GenerationType.AUTO)
//	private Integer movieBookingId;
//	
//	@OneToOne
//	@JoinColumn(name="user_id", nullable=false)
//	private User user;
//	
//	private Shows show;
//	
//}
