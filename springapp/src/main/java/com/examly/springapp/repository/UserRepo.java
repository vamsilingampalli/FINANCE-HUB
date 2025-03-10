
//User Repo
/*
 * User Service is an interface
 * This Interface contains all the abstract methods which are implemented in User ServiceImpl class
 */
package com.examly.springapp.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.examly.springapp.model.User;

public interface UserRepo extends JpaRepository<User,Integer>{
    User findByEmail(String email);
    
}

   
