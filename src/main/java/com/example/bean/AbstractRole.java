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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;

/**
 * AbstractRole entity provides the base persistence definition of the Role
 * entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractRole implements java.io.Serializable {

	// Fields

	private Integer id;
	private String role;
	private String description;
	private Boolean available;
	private Set<Resources> resourceses = new HashSet<Resources>(0);
	private Set<User> users = new HashSet<User>(0);

	// Constructors

	/** default constructor */
	public AbstractRole() {
	}

	/** minimal constructor */
	public AbstractRole(String role) {
		this.role = role;
	}

	/** full constructor */
	public AbstractRole(String role, String description, Boolean available,
			Set<Resources> resourceses, Set<User> users) {
		this.role = role;
		this.description = description;
		this.available = available;
		this.resourceses = resourceses;
		this.users = users;
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

	@Column(name = "role", nullable = false, length = 50)
	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
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

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "role_resources", joinColumns = { @JoinColumn(name = "roleId", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "resource", nullable = false, updatable = false) })
	public Set<Resources> getResourceses() {
		return this.resourceses;
	}

	public void setResourceses(Set<Resources> resourceses) {
		this.resourceses = resourceses;
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "roles")
	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}