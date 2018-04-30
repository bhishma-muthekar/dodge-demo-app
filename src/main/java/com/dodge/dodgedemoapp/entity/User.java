package com.dodge.dodgedemoapp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1413034265679163222L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recordSequence")
	@SequenceGenerator(name = "recordSequence", sequenceName = "record_id_seq")
	@Column(name="user_id")
	private Long userId;
	
	@Column(name="user_name")
	private String userName;

	@Column(name="password")
	private String password;

	@Column(name="user_role")
	private String userRole;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
}
