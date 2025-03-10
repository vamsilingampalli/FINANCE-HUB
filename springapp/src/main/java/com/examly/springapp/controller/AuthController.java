//AuthController
/*
 * AuthController class
 * Controller acts as intermediatory between the Service Logic and Client
 * All HTTP Request handling is done in controller 
 */
package com.examly.springapp.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.examly.springapp.model.LoginDTO;
import com.examly.springapp.model.User;
import com.examly.springapp.service.UserServiceImpl;

 
@RestController
public class AuthController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    /**
     * Registers a new user.
     * 
     * @param user the user to be registered
     * @return ResponseEntity with the registered user and appropriate HTTP status
     */
 
    @PostMapping("/api/register")
    public ResponseEntity<User> registerUser(@RequestBody User user){
        User obj = userServiceImpl.registerUser(user);
        if(obj!=null){
            return ResponseEntity.status(201).body(obj);
        }
        return ResponseEntity.status(500).body(null);
    }


    @PostMapping("/api/login")
    public ResponseEntity<LoginDTO> loginUser(@RequestBody User user){
        return ResponseEntity.status(200).body(userServiceImpl.loginUser(user));
    }
   
}
 