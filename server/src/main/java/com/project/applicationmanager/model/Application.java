package com.project.applicationmanager.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Applications")
public class Application {
	@Id
	@Column(name = "app_id")
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
	private String name;
	private String description;
	@Email
	private String contact;
	private Instant validFrom;
	 
//	 @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@ManyToMany(fetch = FetchType.EAGER)
	    @JoinTable(
	            name = "admins",
	            joinColumns = @JoinColumn(name = "app_id"),
	            inverseJoinColumns = @JoinColumn(name = "applicationID")
	            )
	 private List<User> admins = new ArrayList<>();

//	 @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@ManyToMany(fetch = FetchType.LAZY)
     private List<Environment> environments = new ArrayList<>();
    
}
