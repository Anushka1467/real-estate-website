package com.realestate.listing.service.impl;

import com.realestate.listing.model.Property;
import com.realestate.listing.repository.PropertyRepository;
import com.realestate.listing.service.PropertyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {

    private final PropertyRepository propertyRepository;

    public PropertyServiceImpl(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @Override
    public Property addProperty(Property property) {
        return propertyRepository.save(property);
    }

    @Override
    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }

    @Override
    public Optional<Property> getPropertyById(String id) {
        return propertyRepository.findById(id);
    }

    @Override
    public Property updateProperty(Property property) {
        return propertyRepository.save(property);
    }

    @Override
    public void deleteProperty(String id) {
        propertyRepository.deleteById(id);
    }

    @Override
    public List<Property> searchByCity(String city) {
        return propertyRepository.findByCity(city);
    }

    @Override
    public List<Property> searchByTitle(String title) {
        return propertyRepository.findByTitleContainingIgnoreCase(title);
    }
}