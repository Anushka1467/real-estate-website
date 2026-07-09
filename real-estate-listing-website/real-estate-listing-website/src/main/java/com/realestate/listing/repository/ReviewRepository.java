package com.realestate.listing.repository;

import com.realestate.listing.model.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends MongoRepository<Review, String> {

    // Get all reviews for a property
    List<Review> findByPropertyId(String propertyId);

}