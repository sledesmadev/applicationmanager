package com.project.applicationmanager.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.project.applicationmanager.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationRequest {
	private String name;
	private String description;
	private String contact;
	private Instant validFrom;
    private List<User> admins = new ArrayList<>();
    private List<EnvironmentDTO> environments = new ArrayList<>();
}
