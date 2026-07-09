package com.realestate.listing.service.impl;

import com.realestate.listing.model.Review;
import com.realestate.listing.repository.ReviewRepository;
import com.realestate.listing.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Review addReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public List<Review> getReviewsByPropertyId(String propertyId) {
        return reviewRepository.findByPropertyId(propertyId);
    }

    @Override
    public double getAverageRating(String propertyId) {

        List<Review> reviews = reviewRepository.findByPropertyId(propertyId);

        if (reviews.isEmpty()) {
            return 0.0;
        }

        double total = 0;

        for (Review review : reviews) {
            total += review.getRating();
        }

        return total / reviews.size();
    }

    @Override
    public long getReviewCount(String propertyId) {

        return reviewRepository.findByPropertyId(propertyId).size();
    }
}