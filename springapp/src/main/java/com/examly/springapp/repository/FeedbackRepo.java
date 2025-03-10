//Feedback Repo
/*
 * Feedback Service is an interface
 * This Interface  contains all the abstract mehtods which are implemented in Feedback ServiceImpl class
 */
package com.examly.springapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.examly.springapp.model.Feedback;

@Repository
public interface FeedbackRepo extends JpaRepository<Feedback, Long>{ 

    
}