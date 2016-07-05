package com.example.bean;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

/**
 * AbstractResources entity provides the base persistence definition of the
 * Resources entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractResources implements java.io.Serializable {

	// Fields

	private Integer id;
	private Resources resources;
	private String resource;
	private String description;
	private Boolean available;
	private String icon;
	private Set<Role> roles = new HashSet<Role>(0);
	private Set<Resources> resourceses = new HashSet<Resources>(0);

	// Constructors

	/** default constructor */
	public AbstractResources() {
	}

	/** minimal constructor */
	public AbstractResources(Resources resources, String resource) {
		this.resources = resources;
		this.resource = resource;
	}

	/** full constructor */
	public AbstractResources(Resources resources, String resource,
			String description, Boolean available, String icon,
			Set<Role> roles, Set<Resources> resourceses) {
		this.resources = resources;
		this.resource = resource;
		this.description = description;
		this.available = available;
		this.icon = icon;
		this.roles = roles;
		this.resourceses = resourceses;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pid", nullable = false)
	public Resources getResources() {
		return this.resources;
	}

	public void setResources(Resources resources) {
		this.resources = resources;
	}

	@Column(name = "resource", nullable = false, length = 50)
	public String getResource() {
		return this.resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	@Column(name = "description", length = 100)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "available")
	public Boolean getAvailable() {
		return this.available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	@Column(name = "icon", length = 20)
	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "resourceses")
	public Set<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "resources")
	public Set<Resources> getResourceses() {
		return this.resourceses;
	}

	public void setResourceses(Set<Resources> resourceses) {
		this.resourceses = resourceses;
	}

}