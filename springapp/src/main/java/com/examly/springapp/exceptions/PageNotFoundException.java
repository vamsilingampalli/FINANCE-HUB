//PageNotFoundException 
/*
 * This PageNotFoundException which extends the RuntimeException and handled that exception in GlobalException Handler 
 */

 package com.examly.springapp.exceptions;
 public class PageNotFoundException extends RuntimeException {
 
     /**
      * Constructs a new PageNotFoundException with the specified detail message.
      * 
      * @param message the detail message
      */
     public PageNotFoundException(String message){
         super(message);
     }
 }
 