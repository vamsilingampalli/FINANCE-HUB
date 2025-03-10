package com.examly.springapp.config;

import java.util.Collections;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import com.examly.springapp.exceptions.PageNotFoundException;
import com.examly.springapp.model.User;
import com.examly.springapp.repository.UserRepo;

@Component
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepo userRepository;

    public MyUserDetailsService(UserRepo userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws PageNotFoundException {
        // Fetch user by email from the repository
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new PageNotFoundException("User not found with Email: " + email);
        }
        // Create a SimpleGrantedAuthority based on the user's role
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + user.getUserRole());
        // Return UserDetails with user's email, password, and authorities
        return new UserPrinciple(user.getEmail(), user.getPassword(),
                Collections.singletonList(authority));
    }

}