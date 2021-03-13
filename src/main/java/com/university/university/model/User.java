package com.university.university.model;



import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id ;
	
	@OneToOne
	@JoinColumn(name = "profile")
	private Profile id_profile;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Profile getProfile() {
		return id_profile;
	}
	public void setProfile(Profile profile) {
		this.id_profile = profile;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", profile=" + id_profile + "]";
	} 
	
	

}
