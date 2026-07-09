package com.realestate.listing.controller;

import com.realestate.listing.model.Property;
import com.realestate.listing.service.PropertyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/properties")
public class PropertyController {

    private final PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    // Show all properties
    @GetMapping
    public String getAllProperties(Model model) {

        model.addAttribute("properties",
                propertyService.getAllProperties());

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

        model.addAttribute("property",
                propertyService.getPropertyById(id).orElse(null));

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