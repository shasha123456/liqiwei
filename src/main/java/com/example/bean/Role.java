package com.example.bean;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Role entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "role")
public class Role extends AbstractRole implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Role() {
	}

	/** minimal constructor */
	public Role(String role) {
		super(role);
	}

	/** full constructor */
	public Role(String role, String description, Boolean available,
			Set<Resources> resourceses, Set<User> users) {
		super(role, description, available, resourceses, users);
	}

}
