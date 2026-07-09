package com.realestate.listing.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "properties")
public class Property {

    @Id
    private String id;

    private String title;

    private String description;

    private double price;

    private String address;

    private String city;

    private String state;

    private String propertyType;

    private int bedrooms;

    private int bathrooms;

    private double area;

    private String imageUrl;
}