//LoginDTO class
/*
 * this is LoginDTO class
 * to know the LoginDTO details:
 * In this class we have the required attributes (email, password)
 * @Author Team 17
 */

 package com.examly.springapp.model;

 import lombok.AllArgsConstructor;
 import lombok.Getter;
 import lombok.NoArgsConstructor;
 import lombok.Setter;
 
 @Getter
 @Setter
 @AllArgsConstructor
 @NoArgsConstructor
 public class LoginDTO {
 
     /**
      * The email address of the user.
      */
     private String email;
     
    /*
     * the userId is taken user object.
     */
     private int userId;
 
 
     /*
      * the generated token will be set here.
      */
     private String token;
 
     /*
      * User role trying to login
      */
     private String userRole;

     private String username;
 
 
 }