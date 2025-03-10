//PlanApplicationService
/*
 * PlanApplicationService is an interface
 * this interface contains all the abstract methods which are implemented in PlanApplicationServiceImpl class
 */
package com.examly.springapp.service;

import java.util.List;

import com.examly.springapp.model.PlanApplication;

public interface PlanApplicationService {

    /**
     * Adds a new plan application.
     * 
     * @param planApplication the plan application to be added
     * @return the added plan application
     */
    public PlanApplication addPlanApplication(PlanApplication planApplication);

    public List<PlanApplication> getAllPlanApplications();

    /**
     * Edits an existing plan application.
     * 
     * @param planApplication the plan application with updated details
     * @param planApplicationId the ID of the plan application to be edited
     * @return the updated plan application
     */
    public PlanApplication editPlanApplication(PlanApplication planApplication, Long planApplicationId);

    /**
     * Retrieves plan applications by user ID.
     * 
     * @param userId the ID of the user
     * @return the list of plan applications for the user
     */
    public List<PlanApplication> viewPlanApplicationByUserId(int userId);

    /**
     * Deletes a plan application by its ID.
     * 
     * @param planApplicationId the ID of the plan application to be deleted
     * @return the deleted plan application
     */
    public PlanApplication deletePlanApplication(Long planApplicationId);
}