package com.project.applicationmanager.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.applicationmanager.dto.ApplicationRequest;
import com.project.applicationmanager.exception.ApplicationManagerException;
import com.project.applicationmanager.model.Application;
import com.project.applicationmanager.model.User;
import com.project.applicationmanager.repository.ApplicationRepository;
import com.project.applicationmanager.service.ApplicationService;

@Service
@Transactional
public class ApplicationServiceImpl implements ApplicationService {

	@Autowired
	ApplicationRepository applicationRepository;
	
	@Override
	public List<Application> filterByName(String appName) {
		List<Application> applications = applicationRepository.filterByName(appName).orElseThrow(() -> new ApplicationManagerException(
                "No data found" )); 
		return applications;
	}

	@Override
	public void newApplication(ApplicationRequest app) {
		Application newApp = new Application();
		newApp.setName(app.getName());
		newApp.setContact(app.getContact());
		newApp.setDescription(app.getDescription());
		newApp.setValidFrom(app.getValidFrom());
//		newApp.setAdmins(app.getAdmins());
		for(User user: app.getAdmins()) {
			newApp.getAdmins().add(user);
		}
		applicationRepository.save(newApp);
	}

	@Override
	public List<Application> getAll() {
		return applicationRepository.findAll();
	}

	@Override
	public Application update(ApplicationRequest app) {
		Application newApp = new Application();
		newApp.setName(app.getName());
		newApp.setContact(app.getContact());
		newApp.setDescription(app.getDescription());
		newApp.setValidFrom(app.getValidFrom());
		for(User user: app.getAdmins()) {
			newApp.getAdmins().add(user);
		}
		return applicationRepository.save(newApp);
	}

	@Override
	public void delete(Long id) {
		applicationRepository.deleteById(id);
	}

}
