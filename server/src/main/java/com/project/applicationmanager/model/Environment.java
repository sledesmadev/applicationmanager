package com.project.applicationmanager.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Environments")
public class Environment {
	@Id
	@Column(name = "environment_id")
    @GeneratedValue(strategy = IDENTITY)
	private Integer id;
	@Column(name="name")
	private String envname;
	private boolean isProd;
	private String url;
	
}
