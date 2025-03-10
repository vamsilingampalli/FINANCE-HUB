
//User class
/*
 * this is user class
 * to know the User details:
 * In this class we have the required attributes (userId, email, password, username, mobileNumber, userRole)
 * @Author Team 17
 */
package com.examly.springapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    /**
     * The unique ID of the user.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    /**
     * The email address of the user.
     */
    private String email;
    /**
     * The password of the user.
     */
    private String password;
    /**
     * The username of the user.
     */
    private String username;
    /**
     * The mobile number of the user.
     */
    private String mobileNumber;
    /**
     * The role of the user in the system.
     */
    private String userRole;
   
}
