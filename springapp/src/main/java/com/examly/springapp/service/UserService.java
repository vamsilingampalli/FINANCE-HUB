//UserService
/*
 * UserService is an interface
 * this interface contains all the abstract methods which are implemented in SavingsPlanServiceImpl class
 */
package com.examly.springapp.service;

import org.springframework.stereotype.Service;

import com.examly.springapp.model.User;

@Service
public interface UserService{

    /**
     * Registers a new user.
     * 
     * @param user the user to be registered
     * @return the registered user
     */
    public User registerUser(User user);
    
}