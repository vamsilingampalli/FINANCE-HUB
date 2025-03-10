//UserServiceImpl
/*
 * UserServiceImpl class
 * service have all logics
 */
package com.examly.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.examly.springapp.config.JwtUtils;
import com.examly.springapp.exceptions.EmailAlreadyExistsException;
import com.examly.springapp.exceptions.InternalServerErrorException;
import com.examly.springapp.exceptions.PageNotFoundException;
import com.examly.springapp.model.LoginDTO;
import com.examly.springapp.model.User;
import com.examly.springapp.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;
    /**
     * Registers a new user.
     * 
     * @param user the user to be registered
     * @return the registered user
     * @throws InternalServerErrorException if the user cannot be saved
     */

    public User registerUser(User user) {
        User existingUser = userRepo.findByEmail(user.getEmail());
        if (existingUser != null) {
            throw new EmailAlreadyExistsException("This Email Id already exists.");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    public LoginDTO loginUser(User user) {
        User existingUser = userRepo.findByEmail(user.getEmail());
        if (existingUser != null) {
            System.out.println(existingUser);
            if (!passwordEncoder.matches(existingUser.getPassword(), user.getPassword())) {
                String token = jwtUtils.generateToken(existingUser.getEmail(), existingUser.getUserRole());
                return new LoginDTO(existingUser.getEmail(), existingUser.getUserId(), token, existingUser.getUserRole(),existingUser.getUsername());
            } else {
                throw new PageNotFoundException("Password mismatch");
            }
        } else {
            throw new PageNotFoundException("Need to register before login");
        }
    }
    

}
