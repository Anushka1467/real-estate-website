package com.realestate.listing.repository;

import com.realestate.listing.model.Property;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRepository extends MongoRepository<Property, String> {

    List<Property> findByCityContainingIgnoreCase(String city);

    List<Property> findByTitleContainingIgnoreCase(String title);

    List<Property> findByPropertyTypeIgnoreCase(String propertyType);

    List<Property> findByTitleContainingIgnoreCaseOrCityContainingIgnoreCase(
            String title,
            String city
    );
}