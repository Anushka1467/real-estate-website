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

    List<Property> searchByCity(String city);

    List<Property> searchByTitle(String title);

}