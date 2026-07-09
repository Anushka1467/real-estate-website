package com.realestate.listing.controller;

import com.realestate.listing.model.Property;
import com.realestate.listing.model.Review;
import com.realestate.listing.service.PropertyService;
import com.realestate.listing.service.ReviewService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/properties")
public class PropertyController {

    private final PropertyService propertyService;
    private final ReviewService reviewService;

    public PropertyController(PropertyService propertyService,
                              ReviewService reviewService) {
        this.propertyService = propertyService;
        this.reviewService = reviewService;
    }

    // Show All Properties
    @GetMapping
    public String getAllProperties(Model model) {

        model.addAttribute("properties",
                propertyService.getAllProperties());

        return "properties";
    }

    // Search & Filter Properties
    @GetMapping("/search")
    public String searchProperties(
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) String propertyType,
            Model model) {

        List<Property> properties;

        if (propertyType != null &&
                !propertyType.isBlank() &&
                !propertyType.equalsIgnoreCase("All")) {

            properties = propertyService.filterByPropertyType(propertyType);

        } else if (keyword != null &&
                !keyword.isBlank()) {

            properties = propertyService.search(keyword);

        } else {

            properties = propertyService.getAllProperties();
        }

        model.addAttribute("properties", properties);

        return "properties";
    }

    // Show Add Property Form
    @GetMapping("/add")
    public String showAddForm(Model model) {

        model.addAttribute("property", new Property());

        return "add-property";
    }

    // Save Property
    @PostMapping("/save")
    public String saveProperty(@ModelAttribute Property property) {

        propertyService.addProperty(property);

        return "redirect:/properties";
    }

    // Property Details
    @GetMapping("/{id}")
    public String propertyDetails(@PathVariable String id,
                                  Model model) {

        Property property =
                propertyService.getPropertyById(id).orElse(null);

        if (property == null) {
            return "redirect:/properties";
        }

        model.addAttribute("property", property);

        // Review form object
        model.addAttribute("review", new Review());

        // Reviews
        model.addAttribute("reviews",
                reviewService.getReviewsByPropertyId(id));

        // Average Rating
        model.addAttribute("averageRating",
                reviewService.getAverageRating(id));

        // Total Review Count
        model.addAttribute("reviewCount",
                reviewService.getReviewCount(id));

        return "property-details";
    }

    // Edit Property Form
    @GetMapping("/edit/{id}")
    public String editProperty(@PathVariable String id,
                               Model model) {

        model.addAttribute("property",
                propertyService.getPropertyById(id).orElse(null));

        return "edit-property";
    }

    // Update Property
    @PostMapping("/update")
    public String updateProperty(@ModelAttribute Property property) {

        propertyService.updateProperty(property);

        return "redirect:/properties";
    }

    // Delete Property
    @GetMapping("/delete/{id}")
    public String deleteProperty(@PathVariable String id) {

        propertyService.deleteProperty(id);

        return "redirect:/properties";
    }
}