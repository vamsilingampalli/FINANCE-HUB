
//SavingsPlan Repo
/*
 * SavingsPlan Service is an interface 
 * This Interface contains all the abstract methods which are implemented in SavingsPlan ServiceImpl class
 */
package com.examly.springapp.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.examly.springapp.model.SavingsPlan;
public interface SavingsPlanRepo extends JpaRepository<SavingsPlan,Long>{
    
}
