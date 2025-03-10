//Enquiry class
/*
 * this is enquiry class
 * to know the Enquiry details:
 * In this class we have the required attributes (enquiryId, message)
 * we map this Enquiry class with user
 * @Author Team 17
 */
package com.examly.springapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Enquiry {
    /**
     * The unique ID of the enquiry.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long enquiryId;
    /**
     * The message content of the enquiry.
     */
    private String message;
    private String status;
    /**
     * The user who made the enquiry.
     */
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
}