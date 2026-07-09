package com.realestate.listing.controller;

import com.realestate.listing.model.Review;
import com.realestate.listing.service.ReviewService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    // Save Review
    @PostMapping("/save")
    public String saveReview(@ModelAttribute Review review) {

        // Set today's date automatically
        review.setReviewDate(LocalDate.now());

        // Save review
        reviewService.addReview(review);

        // Redirect back to the property details page
        return "redirect:/properties/" + review.getPropertyId();
    }

}