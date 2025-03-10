
//FeedbackServiceImpl
/*
 * FeedbackServiceImpl class
 * service have all logics
 */
package com.examly.springapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.exceptions.InternalServerErrorException;
import com.examly.springapp.model.Feedback;
import com.examly.springapp.model.User;
import com.examly.springapp.repository.FeedbackRepo;
import com.examly.springapp.repository.UserRepo;

@Service
public class FeedbackServiceImpl implements FeedbackService{
    
    @Autowired
    private FeedbackRepo feedBackRepo;

    @Autowired
    private UserRepo userRepo;

    /**
     * Adds new feedback.
     * 
     * @param feedBack the feedback to be added
     * @return the user associated with the feedback
     * @throws InternalServerErrorException if the user ID does not exist
     */
    public User addFeedBack(Feedback feedBack){
        User user=feedBack.getUser();
        int userId=user.getUserId();
        User obj =userRepo.findById(userId).orElse(null);
        if(obj!=null)
        {
            feedBack.setUser(user);
            feedBackRepo.save(feedBack);
            return obj;
        }
        throw new InternalServerErrorException("user id does not exist");
    }

    /**
     * Retrieves feedback by its ID.
     * 
     * @param feedbackId the ID of the feedback
     * @return the retrieved feedback
     * @throws InternalServerErrorException if the feedback is not found
     */
    public Feedback getFeedBackId(Long feedbackId){
        Feedback obj = feedBackRepo.findById(feedbackId).orElse(null);
        if(obj != null)
            return obj;
        throw new InternalServerErrorException("Unable to fetch the feedback by Id");
    }
    


    /**
     * Retrieves all feedback.
     * 
     * @return the list of all feedback
     * @throws InternalServerErrorException if no feedback is found
     */
    public List<Feedback> getAll(){
        return feedBackRepo.findAll();
        // List<Feedback> obj = feedBackRepo.findAll();
        // if(!obj.isEmpty())
        //     return obj;
        // throw new InternalServerErrorException("No data found in the list");
    }


    /**
     * Retrieves feedback by user ID.
     * 
     * @param userId the ID of the user
     * @return the list of feedback for the user
     * @throws InternalServerErrorException if the user ID does not exist or no feedback is found
     */
    public List<Feedback> getFeedBackByUserId(int userId){
        User user=userRepo.findById(userId).orElse(null);
        if(user != null){
        List<Feedback> obj=new ArrayList<>();
        List<Feedback> res=feedBackRepo.findAll();
        for(Feedback f:res)
        {
            if(f.getUser().getUserId() == userId)
            {
                obj.add(f);
            }
        }
        return obj;
    }
        throw new InternalServerErrorException("Unable to get the feedbacks using userId");
    }


    /**
     * Deletes feedback by its ID.
     * 
     * @param feedbackId the ID of the feedback to be deleted
     * @return the deleted feedback
     * @throws InternalServerErrorException if the feedback is not found
     */

    public Feedback deleteFeedBack(Long feedbackId){
        Feedback obj=feedBackRepo.findById(feedbackId).orElse(null);
        if(obj != null){
            feedBackRepo.deleteById(feedbackId);
            return obj;
        }
    throw new InternalServerErrorException("Unable to delete the feedback.");
    }
        
              
}
