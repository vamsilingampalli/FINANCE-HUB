//EnquiryController
/*
 * EnquiryController class
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.Enquiry;
import com.examly.springapp.model.User;
import com.examly.springapp.service.EnquiryServiceImpl;

@RestController
@RequestMapping("/api/enquiries")
public class EnquiryController {
    @Autowired
    private EnquiryServiceImpl enquiryService;

    /**
     * Adds a new enquiry.
     * 
     * @param enquiry the enquiry to be added
     * @return ResponseEntity with the created user and HTTP status 201
     */
    @PostMapping
    public ResponseEntity<User> addEnquiry(@RequestBody Enquiry enquiry) {
        return ResponseEntity.status(201).body(enquiryService.addEnquiry(enquiry));
    }

    /**
     * Retrieves an enquiry by its ID.
     * 
     * @param id the ID of the enquiry
     * @return ResponseEntity with the retrieved enquiry and HTTP status 200
     */
    @GetMapping("/{id}")
    public ResponseEntity<Enquiry> viewEnquiryById(@PathVariable Long id) {
        return ResponseEntity.status(200).body(enquiryService.viewEnquiryById(id));
    }

    /**
     * Retrieves all enquiries.
     * 
     * @return ResponseEntity with the list of all enquiries and HTTP status 200
     */

    @GetMapping
    public ResponseEntity<List<Enquiry>> viewAllEnquiry() {
        return ResponseEntity.status(200).body(enquiryService.viewAllEnquiry());
    }

    /**
     * Retrieves enquiries by user ID.
     * 
     * @param userId the ID of the user
     * @return ResponseEntity with the list of enquiries for the user and HTTP
     *         status 201
     */

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Enquiry>> viewEnquiryByUserId(@PathVariable int userId) {
        return ResponseEntity.status(201).body(enquiryService.viewEnquiryByUserId(userId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Enquiry> updateEnquiry(@PathVariable Long id, @RequestBody Enquiry enquiry) {
        // Logic to update the enquiry
        return ResponseEntity.status(200).body(enquiryService.updateEnquiry(id, enquiry));
    }

    /**
     * Deletes an enquiry by its ID.
     * 
     * @param id the ID of the enquiry to be deleted
     * @return ResponseEntity with the deleted enquiry and HTTP status 200
     */

    @DeleteMapping("/{id}")
    public ResponseEntity<Enquiry> deleteEnquiry(@PathVariable Long id) {
        return ResponseEntity.status(200).body(enquiryService.deleteEnquiry(id));
    }

}
