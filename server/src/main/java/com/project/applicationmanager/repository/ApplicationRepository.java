package com.project.applicationmanager.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.applicationmanager.model.Application;
import com.project.applicationmanager.model.User;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long>{
	
    @Query("SELECT a FROM Application a LEFT JOIN FETCH a.environments p where upper(a.name) LIKE UPPER(CONCAT('%', :appName,'%'))")
//    @Query("SELECT a FROM Application a where upper(a.name) LIKE UPPER(CONCAT('%', :appName,'%'))")
    Optional<List<Application>> filterByName(@Param("appName") String appName);
    
    void deleteApplicationById(Long id);
    
}
