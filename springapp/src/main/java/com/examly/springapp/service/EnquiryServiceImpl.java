
//EnquiryServiceImpl
/*
 * EnquiryServiceImpl class
 * service have all logics
 */
package com.examly.springapp.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.exceptions.InternalServerErrorException;
import com.examly.springapp.exceptions.PageNotFoundException;
import com.examly.springapp.model.Enquiry;
import com.examly.springapp.model.User;
import com.examly.springapp.repository.EnquiryRepo;
import com.examly.springapp.repository.UserRepo;

@Service
public class EnquiryServiceImpl implements EnquiryService {
    @Autowired
    private EnquiryRepo enquiryRepo;
    @Autowired
    private UserRepo userRepo;

    /**
     * Adds a new enquiry.
     * 
     * @param enquiry the enquiry to be added
     * @return the user associated with the enquiry
     * @throws InternalServerErrorException if the user ID does not exist
     */
    @Override
    public User addEnquiry(Enquiry enquiry) {
        User user=enquiry.getUser();
        int userId=user.getUserId();
        User obj =userRepo.findById(userId).orElse(null);
        if(obj!=null)
        {
            enquiry.setUser(user);
            enquiryRepo.save(enquiry);
            return obj;
        }
        throw new InternalServerErrorException("user id does not exist");
    }

    /**
     * Retrieves an enquiry by its ID.
     * 
     * @param id the ID of the enquiry
     * @return the retrieved enquiry
     * @throws InternalServerErrorException if the enquiry is not found
     */
    @Override
    public Enquiry viewEnquiryById(Long id) {
        Enquiry obj = enquiryRepo.findById(id).orElse(null);
        if (obj != null)
            return obj;
        throw new InternalServerErrorException("Unable to view the enquiry with ID.");
    }
    
    /**
     * Retrieves all enquiries.
     * 
     * @return the list of all enquiries
     * @throws InternalServerErrorException if no enquiries are found
     */
    @Override
    public List<Enquiry> viewAllEnquiry() {
        List<Enquiry> list = enquiryRepo.findAll();
        if (!list.isEmpty())
            return list;
        throw new InternalServerErrorException("Unable to fetch  the enquiry list.");
    }

    /**
     * Retrieves enquiries by user ID.
     * 
     * @param userId the ID of the user
     * @return the list of enquiries for the user
     * @throws InternalServerErrorException if the user ID does not exist or no enquiries are found
     */

    @Override
    public List<Enquiry> viewEnquiryByUserId(int userId) {
        User user=userRepo.findById(userId).orElse(null);
        if(user != null){
        List<Enquiry> obj=new ArrayList<>();
        List<Enquiry> res=enquiryRepo.findAll();
        for(Enquiry f:res)
        {
            if(f.getUser().getUserId() == userId)
            {
                obj.add(f);
            }
        }
        return obj;
    }
        throw new InternalServerErrorException("Unable to get the enquiries using userId");
    }

    /**
     * Deletes an enquiry by its ID.
     * 
     * @param id the ID of the enquiry to be deleted
     * @return the deleted enquiry
     * @throws InternalServerErrorException if the enquiry is not found
     */

    @Override
    public Enquiry deleteEnquiry(Long id) {
        Enquiry obj = enquiryRepo.findById(id).orElse(null);
        if (obj != null) {
            enquiryRepo.deleteById(id);
            return obj;
        }
        throw new InternalServerErrorException("Unable to delete the enquiry.");
    }

    public Enquiry updateEnquiry(Long id, Enquiry enquiry) {
        Enquiry existingEnquiry = enquiryRepo.findById(id).orElse(null);
        if(existingEnquiry==null){
            throw new PageNotFoundException("Enquiry not found with the id "+id);
        }
        
        if(enquiry.getMessage()!=null){
            existingEnquiry.setMessage(enquiry.getMessage());
        }
        if(enquiry.getStatus()!=null){
            existingEnquiry.setStatus(enquiry.getStatus());
        }

        return enquiryRepo.save(existingEnquiry);
    }
}