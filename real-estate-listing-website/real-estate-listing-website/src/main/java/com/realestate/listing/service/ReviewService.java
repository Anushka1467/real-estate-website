package com.realestate.listing.service;

import com.realestate.listing.model.Review;

import java.util.List;

public interface ReviewService {

    // Add a new review
    Review addReview(Review review);

    // Get all reviews for a property
    List<Review> getReviewsByPropertyId(String propertyId);

    // Calculate average rating of a property
    double getAverageRating(String propertyId);

    // Total number of reviews for a property
    long getReviewCount(String propertyId);
}