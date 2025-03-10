//SavingsPlan class
/*
 * this is savingsplan class
 * to know the SavingsPlan  details:
 * In this class we have the required attributes (savingsPlanId, name, goalAmount, timeFrame, riskLevel, description, status)
 * @Author Team 17
 */
package com.examly.springapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SavingsPlan {
    /**
     * The unique ID of the savings plan.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long savingsPlanId;
    /**
     * The name of the savings plan.
     */
    private String name;
    /**
     * The goal amount to be saved.
     */
    private double goalAmount;
    /**
     * The time frame to achieve the savings goal, in months.
     */
    private int timeFrame;
    /**
     * The risk level associated with the savings plan.
     */
    private String riskLevel;
    /**
     * A description of the savings plan.
     */
    private String description;
    /**
     * The current status of the savings plan.
     */
    private String status;
}