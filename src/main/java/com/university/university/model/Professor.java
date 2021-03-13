package com.university.university.model;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;



@Entity
@Table(name = "professor")
public class Professor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String first_name;
	private String last_name;
	private Integer document_number;
	private Integer active;
	

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public Integer getDocument_number() {
		return document_number;
	}
	public void setDocument_number(Integer document_number) {
		this.document_number = document_number;
	}
	public Integer getActive() {
		return active;
	}
	public void setActive(Integer active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "Professor [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", document_number="
				+ document_number + ", active=" + active + "]";
	}
	
	
}