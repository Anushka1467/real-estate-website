package com.realestate.listing.service;

import com.realestate.listing.model.User;

import java.util.Optional;

public interface UserService {

    User registerUser(User user);

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
}