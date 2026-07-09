package com.realestate.listing.service;

import com.realestate.listing.model.Property;

import java.util.List;
import java.util.Optional;

public interface PropertyService {

    Property addProperty(Property property);

    List<Property> getAllProperties();

    Optional<Property> getPropertyById(String id);

    Property updateProperty(Property property);

    void deleteProperty(String id);

    // Search by City
    List<Property> searchByCity(String city);

    // Search by Title
    List<Property> searchByTitle(String title);

    // Search by Title OR City
    List<Property> search(String keyword);

    // Filter by Property Type
    List<Property> filterByPropertyType(String propertyType);

}