
//SavingsPlanServiceImpl
/*
 * SavingsPlanServiceImpl class
 * service have all logics
 */
package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.exceptions.InternalServerErrorException;
import com.examly.springapp.model.SavingsPlan;
import com.examly.springapp.repository.SavingsPlanRepo;

@Service
public class SavingsPlanServiceImpl implements SavingsPlanService  {

    @Autowired
    private SavingsPlanRepo savingsPlanRepo;

    /**
     * Retrieves a savings plan by its ID.
     * 
     * @param id the ID of the savings plan
     * @return the retrieved savings plan
     * @throws InternalServerErrorException if the savings plan is not found
     */
    @Override
    public SavingsPlan getSavingsPlanById(Long id) {
        SavingsPlan obj=savingsPlanRepo.findById(id).orElse(null);
        if(obj!=null)
            return obj;
        throw new InternalServerErrorException("Savings plan with the "+id+" not found.");
    }

    /**
     * Retrieves all savings plans.
     * 
     * @return the list of all savings plans
     * @throws InternalServerErrorException if no savings plans are found
     */
    @Override
    public List<SavingsPlan> getAllSavingsPlans() {
        List<SavingsPlan> list = savingsPlanRepo.findAll();
        if(!list.isEmpty()){
            return list;
        }
        throw new InternalServerErrorException("No SavingsPlan found.");
  
    }

    /**
     * Adds a new savings plan.
     * 
     * @param savingsPlan the savings plan to be added
     * @return the added savings plan
     * @throws InternalServerErrorException if the savings plan is null
     */
    @Override
    public SavingsPlan addSavingsPlan(SavingsPlan savingsPlan) {
        if(savingsPlan != null){
            return savingsPlanRepo.save(savingsPlan);
        }
        throw new InternalServerErrorException("Unable to save the SavingsPlan");
    }

    /**
     * Edits an existing savings plan.
     * 
     * @param savingsPlan the savings plan with updated details
     * @param id the ID of the savings plan to be edited
     * @return the updated savings plan
     * @throws InternalServerErrorException if the savings plan is not found
     */
    @Override
    public SavingsPlan editSavingsPlan(SavingsPlan savingsPlan, Long id) {
        SavingsPlan obj=savingsPlanRepo.findById(id).orElse(null);
        if(obj!=null)
        {
            savingsPlan.setSavingsPlanId(id);
            return savingsPlanRepo.save(savingsPlan);
        }
        throw new InternalServerErrorException("Unable to Update the SavingsPlan");
    }

    /**
     * Deletes a savings plan by its ID.
     * 
     * @param id the ID of the savings plan to be deleted
     * @return the deleted savings plan
     * @throws InternalServerErrorException if the savings plan is not found
     */
    @Override
    public SavingsPlan deleteSavingsPlan(Long id) {
        SavingsPlan obj=savingsPlanRepo.findById(id).orElse(null);
        if(obj!=null)
        {
            savingsPlanRepo.deleteById(id);
            return obj;
        }
        throw new InternalServerErrorException("Unable to delete the SavingsPlan.");
    }
    
}
