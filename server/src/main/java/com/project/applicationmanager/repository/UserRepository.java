package com.project.applicationmanager.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.applicationmanager.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findByUsername (String username);
	
    @Query("SELECT id FROM User where upper(username) like upper(:username) and password like :password") 
    Optional<Long> findByUserPassword(@Param("username") String username, @Param("password") String password);
    
    
    @Query("SELECT count(e)>0 from User e where upper(username)= :username") 
    boolean checkUserExists(@Param("username") String username);
    
}
