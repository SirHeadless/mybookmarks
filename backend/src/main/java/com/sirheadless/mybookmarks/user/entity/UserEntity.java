package com.sirheadless.mybookmarks.user.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="users")
public class UserEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userId;
	@Column(name="username")
	private String username;
	@Column(name="forename")
	private String forename;
	@Column(name="surname")
	private String surname; 
	@Column(name="password")
	private String password; 
	

	@Column(name="email")
	private String email; 
	@Column(name="enabled")
	private boolean enabled; 
	
	@Column(name="entry_updated_at")
	private Date entryUpdatedAt;
	@Column(name="entry_created_at")
	private Date entryCreatedAt;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getForename() {
		return forename;
	}
	public void setForename(String forename) {
		this.forename = forename;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public Date getEntryUpdatedAt() {
		return entryUpdatedAt;
	}
	public void setEntryUpdatedAt(Date entryUpdatedAt) {
		this.entryUpdatedAt = entryUpdatedAt;
	}
	public Date getEntryCreatedAt() {
		return entryCreatedAt;
	}
	public void setEntryCreatedAt(Date entryCreatedAt) {
		this.entryCreatedAt = entryCreatedAt;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}



}
