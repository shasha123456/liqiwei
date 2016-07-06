package com.example.bean;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user")
public class User extends AbstractUser implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String loginName, String password) {
		super(loginName, password);
	}

	/** full constructor */
	public User(String loginName, String password, String trueName,
			String email, String telephone, String address, Boolean available,
			Set<Role> roles) {
		super(loginName, password, trueName, email, telephone, address,
				available, roles);
	}

}
