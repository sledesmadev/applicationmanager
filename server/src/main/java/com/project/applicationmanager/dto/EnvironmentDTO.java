package com.project.applicationmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnvironmentDTO {
	private String name;
	private boolean isProd;
	private String url;
}
