
//PlanApplication class
/*
 * this is planapplication class
 * to know the PlanApplication  details:
 * In this class we have the required attributes (planApplicationId, appliedAmount, status, applicationDate, remarks)
 * we map this PlanApplication class with user
 * @Author Team 17
 */

 package com.examly.springapp.model;
import jakarta.persistence.Lob;
 import java.time.LocalDate;
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
 public class PlanApplication {
     /**
      * The unique ID of the plan application.
      */
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private Long planApplicationId;
     /**
      * The amount applied for in the savings plan.
      */
     private double appliedAmount;
     /**
      * The current status of the plan application.
      */
     private String status;
     /**
      * The date when the application was made.
      */
     private LocalDate applicationDate;
     /**
      * Additional remarks or comments about the application.
      */
     private String remarks;
     /**
      * The user who applied for the savings plan.
      */
    @Lob
     private String proofDocument;
     private String savingsPlanName;
     private boolean statusUpdated;
     @ManyToOne
     @JoinColumn(name = "userId")
     private User user;
 }
 