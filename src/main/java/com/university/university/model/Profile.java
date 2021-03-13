package com.university.university.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "profile")
public class Profile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_profile;

	private String name;

	public Integer getId_profile() {
		return id_profile;
	}

	public void setId(Integer id_profile) {
		this.id_profile = id_profile;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	



	@Override
	public String toString() {
		return "Profile [id=" + id_profile + ", profile=" + name + "]";
	}

}
