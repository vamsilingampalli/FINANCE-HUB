
//InternalServerErrorException
/*
 * This InternalServerErrorException which extends the RuntimeException and handled in the GlobalException Handler
 */
package com.examly.springapp.exceptions;

public class InternalServerErrorException extends RuntimeException {

  /**
   * Constructs a new InternalServerErrorException with the specified detail message.
   * 
   * @param message the detail message
   */
  public InternalServerErrorException(String message){
         super(message);
  }  
}
