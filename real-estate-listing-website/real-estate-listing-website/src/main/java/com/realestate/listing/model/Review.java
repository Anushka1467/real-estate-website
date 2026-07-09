package com.realestate.listing.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "reviews")
public class Review {

    @Id
    private String id;

    private String propertyId;

    private String userName;

    private int rating;

    private String comment;

    private LocalDate reviewDate;

    public Review() {
    }

    public Review(String id, String propertyId, String userName,
                  int rating, String comment, LocalDate reviewDate) {
        this.id = id;
        this.propertyId = propertyId;
        this.userName = userName;
        this.rating = rating;
        this.comment = comment;
        this.reviewDate = reviewDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDate getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(LocalDate reviewDate) {
        this.reviewDate = reviewDate;
    }
}