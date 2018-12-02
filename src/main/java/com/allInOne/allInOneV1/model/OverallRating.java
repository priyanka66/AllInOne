package com.allInOne.allInOneV1.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "OverallRating")
public class OverallRating {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer overallRatingId;
	
	private float overallRatingValue;
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Review_Rating",
            joinColumns = { @JoinColumn(name = "overall_rating_id", referencedColumnName = "overallRatingId") },
            inverseJoinColumns = { @JoinColumn(name = "review_id", referencedColumnName = "reviewId") }
    )
    Set<Review> reviews = new HashSet<>();

	public Integer getOverallRatingId() {
		return overallRatingId;
	}

	public void setOverallRatingId(Integer overallRatingId) {
		this.overallRatingId = overallRatingId;
	}

	public float getOverallRatingValue() {
		return overallRatingValue;
	}

	public void setOverallRatingValue(float overallRatingValue) {
		this.overallRatingValue = overallRatingValue;
	}

	public Set<Review> getReviews() {
		return reviews;
	}

	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}
	
}
