//SavingsPlanController
/*
 * SavingsPlanController class
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

import com.examly.springapp.model.SavingsPlan;
import com.examly.springapp.service.SavingsPlanServiceImpl;

@RestController
@RequestMapping("/api/savingsplans")
public class SavingsPlanController {
    
    @Autowired 
    private SavingsPlanServiceImpl savingsPlanService;

    /**
     * Retrieves a savings plan by its ID.
     * 
     * @param id the ID of the savings plan
     * @return ResponseEntity with the retrieved savings plan and HTTP status 200
     */
    @GetMapping("/{id}")
    public ResponseEntity<SavingsPlan> getSavingsPlanById(@PathVariable Long id)
    {
        return ResponseEntity.status(200).body(savingsPlanService.getSavingsPlanById(id));
    }

    /**
     * Retrieves all savings plans.
     * 
     * @return ResponseEntity with the list of all savings plans and HTTP status 200
     */
    @GetMapping
    public ResponseEntity<List<SavingsPlan>> getAllSavingsPlans()
    {
        return ResponseEntity.status(200).body(savingsPlanService.getAllSavingsPlans());
    }

    /**
     * Adds a new savings plan.
     * 
     * @param savingsPlan the savings plan to be added
     * @return ResponseEntity with the created savings plan and HTTP status 201
     */
    @PostMapping
    public ResponseEntity<SavingsPlan> addSavingsPlan(@RequestBody SavingsPlan savingsPlan)
    {
        return ResponseEntity.status(201).body(savingsPlanService.addSavingsPlan(savingsPlan));
    }
    /**
     * Edits an existing savings plan.
     * 
     * @param savingsPlan the savings plan with updated details
     * @param id the ID of the savings plan to be edited
     * @return ResponseEntity with the updated savings plan and HTTP status 200
     */
    @PutMapping("/{id}")
    public ResponseEntity<SavingsPlan> editSavingsPlan(@RequestBody SavingsPlan savingsPlan,@PathVariable Long id)
    {
        return ResponseEntity.status(200).body(savingsPlanService.editSavingsPlan(savingsPlan,id));
    }

    /**
     * Deletes a savings plan by its ID.
     * 
     * @param id the ID of the savings plan to be deleted
     * @return ResponseEntity with the deleted savings plan and HTTP status 200
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<SavingsPlan> deleteSavingsPlan(@PathVariable Long id)
    {
        return ResponseEntity.status(200).body(savingsPlanService.deleteSavingsPlan(id));
    }
    

}