//PlanApplicationController
/*
 * PlanApplicationController class
 * Controller acts as intermediatory between the Service Logic and Client
 * All HTTP Request handling is done in controller 
 */
package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.PlanApplication;
import com.examly.springapp.service.PlanApplicationServiceImpl;

@RestController
@RequestMapping("/api/planapplications")
public class PlanApplicationController {

    @Autowired
    private PlanApplicationServiceImpl planApplicationServiceImpl;

    /**
     * Adds a new plan application.
     * 
     * @param planApplication the plan application to be added
     * @return ResponseEntity with the created plan application and HTTP status 201
     */
    @PostMapping
    public ResponseEntity<PlanApplication> addPlanApplication(@RequestBody PlanApplication planApplication) {
        return ResponseEntity.status(201).body(planApplicationServiceImpl.addPlanApplication(planApplication));
    }

    /**
     * Edits an existing plan application.
     * 
     * @param planApplication the plan application with updated details
     * @param id the ID of the plan application to be edited
     * @return ResponseEntity with the updated plan application and HTTP status 200
     */
    @PutMapping("/{id}")
    public ResponseEntity<PlanApplication> editPlanApplication(@RequestBody PlanApplication planApplication,@PathVariable Long id){
        return ResponseEntity.status(200).body(planApplicationServiceImpl.editPlanApplication(planApplication, id));
    }

    /**
     * Retrieves plan applications by user ID.
     * 
     * @param userId the ID of the user
     * @return ResponseEntity with the list of plan applications for the user and HTTP status 200
     */
    // @PreAuthorize("hasAuthority('MANAGER')")
    @GetMapping
    public ResponseEntity<List<PlanApplication>> getAllPlanApplications(){
        return ResponseEntity.status(200).body(planApplicationServiceImpl.getAllPlanApplications());
    }
    // @PreAuthorize("hasAnyAuthority('MANAGER','CLIENT')")
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<PlanApplication>> viewPlanApplicationByUserId(@PathVariable int userId){
        return ResponseEntity.status(200).body(planApplicationServiceImpl.viewPlanApplicationByUserId(userId));
    }

    /**
     * Retrieves a plan application by its ID.
     * 
     * @param id the ID of the plan application
     * @return ResponseEntity with the retrieved plan application and HTTP status 200
     */
    @GetMapping("/{id}")
    public ResponseEntity<PlanApplication> viewPlanApplicationById(@PathVariable Long id){
        return ResponseEntity.status(200).body(planApplicationServiceImpl.viewPlanApplicationById(id));
    }
    

    /**
     * Deletes a plan application by its ID.
     * 
     * @param id the ID of the plan application to be deleted
     * @return ResponseEntity with the deleted plan application and HTTP status 200
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<PlanApplication> deletePlanApplication(@PathVariable Long id){
        return ResponseEntity.status(200).body(planApplicationServiceImpl.deletePlanApplication(id));
    }

}