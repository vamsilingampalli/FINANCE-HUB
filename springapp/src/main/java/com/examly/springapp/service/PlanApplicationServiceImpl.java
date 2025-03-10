
//PlanApplicationServiceImpl
/*
 * PlanApplicationServiceImpl class
 * service have all logics
 */
package com.examly.springapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.exceptions.InternalServerErrorException;
import com.examly.springapp.exceptions.PageNotFoundException;
import com.examly.springapp.model.PlanApplication;
import com.examly.springapp.model.User;
import com.examly.springapp.repository.PlanApplicationRepo;
import com.examly.springapp.repository.UserRepo;

@Service
public class PlanApplicationServiceImpl implements PlanApplicationService {

    @Autowired
    private PlanApplicationRepo planApplicationRepo;

    @Autowired
    private UserRepo userRepo;


    /**
     * Adds a new plan application.
     * 
     * @param planApplication the plan application to be added
     * @return the added plan application
     */
    public PlanApplication addPlanApplication(PlanApplication planApplication) {
        return planApplicationRepo.save(planApplication);
    }

    /**
     * Edits an existing plan application.
     * 
     * @param planApplication the plan application with updated details
     * @param planApplicationId the ID of the plan application to be edited
     * @return the updated plan application
     * @throws InternalServerErrorException if the plan application is not found
     */
    public PlanApplication editPlanApplication(PlanApplication planApplication, Long planApplicationId) {
        PlanApplication obj = planApplicationRepo.findById(planApplicationId).orElse(null);
        if (obj != null) {
            if (planApplication.getApplicationDate() != null) {
                obj.setApplicationDate(planApplication.getApplicationDate());
            }
            if (planApplication.getAppliedAmount() > 0.0) {
                obj.setAppliedAmount(planApplication.getAppliedAmount());
            }
            if (planApplication.getRemarks() != null) {
                obj.setRemarks(planApplication.getRemarks());
            }
            if (planApplication.getStatus() != null) {
                obj.setStatus(planApplication.getStatus());
            }
            if (planApplication.getUser() != null) {
                obj.setUser(planApplication.getUser());
            }
            if(planApplication.getSavingsPlanName()!=null){
                obj.setSavingsPlanName(planApplication.getSavingsPlanName());
            }
            if(planApplication.getProofDocument()!=null)
            {
                obj.setProofDocument(planApplication.getProofDocument());
            }
               
            obj.setStatusUpdated(true);

            return planApplicationRepo.save(obj);
        }
        throw new InternalServerErrorException("Unable to Update the planApplication");
    }


    /**
     * Retrieves plan applications by user ID.
     * 
     * @param userId the ID of the user
     * @return the list of plan applications for the user
     * @throws InternalServerErrorException if the user ID does not exist or no plan applications are found
     */
    public List<PlanApplication> viewPlanApplicationByUserId(int userId) {
        User user = userRepo.findById(userId).orElse(null);
        if (user != null) {
            List<PlanApplication> obj = new ArrayList<>();
            List<PlanApplication> res = planApplicationRepo.findAll();
            for (PlanApplication f : res) {
                if (f.getUser()!=null && f.getUser().getUserId() == userId) {
                    obj.add(f);
                }
            }
            return obj;
        }
        throw new InternalServerErrorException("Unable to get the planApplication using userId");
            }
        


    /**
     * Deletes a plan application by its ID.
     * 
     * @param planApplicationId the ID of the plan application to be deleted
     * @return the deleted plan application
     * @throws InternalServerErrorException if the plan application is not found
     */
    public PlanApplication deletePlanApplication(Long planApplicationId) {
        PlanApplication obj = planApplicationRepo.findById(planApplicationId).orElse(null);
        if (obj != null) {
            planApplicationRepo.deleteById(planApplicationId);
            return obj;
        }
        throw new InternalServerErrorException("Unable to delete the planApplication");

    }

   
    /**
     * Retrieves a plan application by its ID.
     * 
     * @param planApplicationId the ID of the plan application
     * @return the retrieved plan application
     * @throws PageNotFoundException if the plan application is not found
     */
    public PlanApplication viewPlanApplicationById(Long planApplicationId){
        PlanApplication obj = planApplicationRepo.findById(planApplicationId).orElse(null);
        if (obj != null) {
            return obj;
        }
        throw new PageNotFoundException("No PlanApplication found.");
    }

	@Override
	public List<PlanApplication> getAllPlanApplications() {
    return planApplicationRepo.findAll();
    }
}
