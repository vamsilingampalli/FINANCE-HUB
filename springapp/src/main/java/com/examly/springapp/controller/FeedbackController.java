//FeedbackController
/*
 * FeedbackController class
 * Controller acts as intermediatory between the Service Logic and Client
 * All HTTP Request handling is done in controller 
 */
package com.examly.springapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.Feedback;
import com.examly.springapp.model.User;
import com.examly.springapp.service.FeedbackServiceImpl;



@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {
    @Autowired
    private FeedbackServiceImpl feedBackSerivceImpl;

    /**
     * Adds new feedback.
     * 
     * @param feedBack the feedback to be added
     * @return ResponseEntity with the created user and HTTP status 201
     */
    @PostMapping
    public ResponseEntity<User> addFeedBack(@RequestBody Feedback feedBack) {
        return ResponseEntity.status(201).body(feedBackSerivceImpl.addFeedBack(feedBack));
    }

    /**
     * Retrieves feedback by its ID.
     * 
     * @param id the ID of the feedback
     * @return ResponseEntity with the retrieved feedback and HTTP status 200
     */

    @GetMapping("/{id}")
    public ResponseEntity<Feedback> getFeedBackById(@PathVariable Long id) {
        return ResponseEntity.status(200).body(feedBackSerivceImpl.getFeedBackId(id));
    }

    /**
     * Retrieves all feedback.
     * 
     * @return ResponseEntity with the list of all feedback and HTTP status 200
     */
    @GetMapping
    public ResponseEntity<List<Feedback>> getAll() {
        return ResponseEntity.status(200).body(feedBackSerivceImpl.getAll());
    }

    /**
     * Retrieves feedback by user ID.
     * 
     * @param userId the ID of the user
     * @return ResponseEntity with the list of feedback for the user and HTTP status 201
     */

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Feedback>> getFeedBackByUserId(@PathVariable int userId) {
        return ResponseEntity.status(201).body(feedBackSerivceImpl.getFeedBackByUserId(userId));
    }

    /**
     * Deletes feedback by its ID.
     * 
     * @param id the ID of the feedback to be deleted
     * @return ResponseEntity with the deleted feedback and HTTP status 200
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Feedback> deleteFeedBack(@PathVariable Long id) {
        return ResponseEntity.status(200).body(feedBackSerivceImpl.deleteFeedBack(id));
    }

}