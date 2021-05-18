package com.project.applicationmanager.controller;

import static org.springframework.http.HttpStatus.OK;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.applicationmanager.dto.ApplicationRequest;
import com.project.applicationmanager.dto.UserRequest;
import com.project.applicationmanager.model.Application;
import com.project.applicationmanager.service.ApplicationService;

@RestController
@RequestMapping("/api/application")
public class ApplicationController {

	@Autowired
	ApplicationService applicationService;
	
	@PostMapping("/new")
    public ResponseEntity create(@RequestBody ApplicationRequest applicationRequest) {
		applicationService.newApplication(applicationRequest);
        return new ResponseEntity(HttpStatus.CREATED);
    }
	
	@PostMapping("/filter")
    public List<Application> filterByName(@RequestBody String appName) {
		return applicationService.filterByName(appName);
    }
	
	@GetMapping("/getAll")
	 public  ResponseEntity<List<Application>> getAll() {
		List<Application> applications = applicationService.getAll();
		return new ResponseEntity<>(applications, HttpStatus.OK);
    }
	
	@PutMapping("/update")
	public ResponseEntity<Application> updateApplication(@RequestBody ApplicationRequest application){
	    Application updatedApp = applicationService.update(application);
        return new ResponseEntity<>(updatedApp, HttpStatus.OK);
	}
	
	 @DeleteMapping("/delete/{id}")
	 public ResponseEntity<?> deleteApplication(@PathVariable("id") Long id) {
	      applicationService.delete(id);
	      return new ResponseEntity<>(HttpStatus.OK);
	 }
	
	
}
