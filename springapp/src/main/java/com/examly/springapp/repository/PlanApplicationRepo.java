
//PlanApplicationRepo
/*
 * PlanApplication Service is an interface
 * This interface contains all the abstract methods which are implemented in PlanApplication ServiceImpl class 
 */
package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.examly.springapp.model.PlanApplication;

@Repository
public interface PlanApplicationRepo extends JpaRepository<PlanApplication,Long> {
    
}
