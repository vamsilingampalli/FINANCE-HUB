//Global Exception
/*
 * Global Exception Handler class
 * this is used to handle exceptions which are thrown in service
 */
package com.examly.springapp.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles PageNotFoundException and returns a 404 Not Found response.
     * 
     * @param e the PageNotFoundException
     * @return ResponseEntity with 404 status and exception message
     */

    @ExceptionHandler(PageNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFoundException(PageNotFoundException e){
        return ResponseEntity.status(404).body(e.getMessage());
    }

    /**
     * Handles InternalServerErrorException and returns a 500 Internal Server Error response.
     * 
     * @param e the InternalServerErrorException
     * @return ResponseEntity with 500 status and exception message
     */
    
    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<String> handleInternalServerErrorException(InternalServerErrorException e){
        return ResponseEntity.status(500).body(e.getMessage());
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<String> handleEmailAlreadyExistsException(EmailAlreadyExistsException e){
        return ResponseEntity.status(409).body(e.getMessage());
    }
}