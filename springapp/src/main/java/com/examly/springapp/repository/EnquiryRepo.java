//EnquiryRepo
/*
 * Enquiry Service is an Interface 
 * This Interface contains all the Abstract methods which are implemented in EnquiryServiceImpl class
 */
package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examly.springapp.model.Enquiry;

@Repository
public interface EnquiryRepo extends JpaRepository<Enquiry,Long> {
    
}