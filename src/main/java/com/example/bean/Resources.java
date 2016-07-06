package com.example.bean;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Resources entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "resources")
public class Resources extends AbstractResources implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public Resources() {
	}

	/** minimal constructor */
	public Resources(Resources resources, String resource) {
		super(resources, resource);
	}

	/** full constructor */
	public Resources(Resources resources, String resource, String description,
			Boolean available, String icon, Set<Role> roles,
			Set<Resources> resourceses) {
		super(resources, resource, description, available, icon, roles,
				resourceses);
	}

}
