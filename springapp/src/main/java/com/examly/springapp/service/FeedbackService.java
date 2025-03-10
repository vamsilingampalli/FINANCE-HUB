//FeedbackService
/*
 * FeedbackService is an interface
 * this interface contains all the abstract methods which are implemented in FeedbackServiceImpl class
 */

 package com.examly.springapp.service;
 import java.util.List;
 
 import com.examly.springapp.model.Feedback;
 import com.examly.springapp.model.User;
 
 public interface FeedbackService {
 
 
     /**
      * Adds new feedback.
      * 
      * @param feedBack the feedback to be added
      * @return the user associated with the feedback
      */
     public User addFeedBack(Feedback feedBack);
 
 
     /**
      * Retrieves feedback by its ID.
      * 
      * @param feedbackId the ID of the feedback
      * @return the retrieved feedback
      */
     public Feedback getFeedBackId(Long feedbackId);
 
     /**
      * Retrieves all feedback.
      * 
      * @return the list of all feedback
      */
     public List<Feedback> getAll();
 
     /**
      * Retrieves feedback by user ID.
      * 
      * @param userId the ID of the user
      * @return the list of feedback for the user
      */
     public List<Feedback> getFeedBackByUserId(int userId);
 
 
     /**
      * Deletes feedback by its ID.
      * 
      * @param feedbackId the ID of the feedback to be deleted
      * @return the deleted feedback
      */
     public Feedback deleteFeedBack(Long feedbackId);
 }