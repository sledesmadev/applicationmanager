package com.project.applicationmanager.service;

import java.util.List;

import com.project.applicationmanager.dto.ApplicationRequest;
import com.project.applicationmanager.model.Application;

public interface ApplicationService {
  public List<Application> filterByName(String appName);
  public List<Application> getAll();
  public void newApplication(ApplicationRequest app);
  public Application update(ApplicationRequest app);
  public void delete(Long id);
}
