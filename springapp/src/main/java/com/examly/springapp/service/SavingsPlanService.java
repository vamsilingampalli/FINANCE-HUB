
//SavingsPlanService
/*
 * SavingsPlanService is an interface
 * this interface contains all the abstract methods which are implemented in SavingsPlanServiceImpl class
 */
package com.examly.springapp.service;

import java.util.List;

import com.examly.springapp.model.SavingsPlan;

public interface SavingsPlanService {

    /**
     * Retrieves a savings plan by its ID.
     * 
     * @param id the ID of the savings plan
     * @return the retrieved savings plan
     */
    public SavingsPlan getSavingsPlanById(Long id);
    
    /**
     * Retrieves all savings plans.
     * 
     * @return the list of all savings plans
     */
    public List<SavingsPlan> getAllSavingsPlans();
    
    /**
     * Adds a new savings plan.
     * 
     * @param savingsPlan the savings plan to be added
     * @return the added savings plan
     */
    public SavingsPlan addSavingsPlan(SavingsPlan savingsPlan);
    
    /**
     * Edits an existing savings plan.
     * 
     * @param savingsPlan the savings plan with updated details
     * @param id the ID of the savings plan to be edited
     * @return the updated savings plan
     */
    public SavingsPlan editSavingsPlan(SavingsPlan savingsPlan,Long id);
    
    /**
     * Deletes a savings plan by its ID.
     * 
     * @param id the ID of the savings plan to be deleted
     * @return the deleted savings plan
     */
    public SavingsPlan deleteSavingsPlan(Long id);
}