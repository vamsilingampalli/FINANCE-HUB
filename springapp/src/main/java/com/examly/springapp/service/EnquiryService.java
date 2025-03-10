//EnquiryService
/*
 * EnquiryService is an interface
 * this interface contains all the abstract methods which are implemented in EnquiryServiceImpl class
 */
package com.examly.springapp.service;

import java.util.List;

import com.examly.springapp.model.Enquiry;
import com.examly.springapp.model.User;

public interface EnquiryService {

    /**
     * Adds a new enquiry.
     * 
     * @param enquiry the enquiry to be added
     * @return the user associated with the enquiry
     */
    public User addEnquiry(Enquiry enquiry);

    /**
     * Retrieves an enquiry by its ID.
     * 
     * @param id the ID of the enquiry
     * @return the retrieved enquiry
     */
    public Enquiry viewEnquiryById(Long id);

    /**
     * Retrieves all enquiries.
     * 
     * @return the list of all enquiries
     */
    public List<Enquiry> viewAllEnquiry();

    /**
     * Retrieves enquiries by user ID.
     * 
     * @param userId the ID of the user
     * @return the list of enquiries for the user
     */
    public List<Enquiry> viewEnquiryByUserId(int userId);

    /**
     * Deletes an enquiry by its ID.
     * 
     * @param id the ID of the enquiry to be deleted
     * @return the deleted enquiry
     */
    public Enquiry deleteEnquiry(Long id);
}