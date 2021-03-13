package com.university.university.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;



@Entity
@Table(name = "student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer document_number;
	private String first_name;
	private String last_name;
	
	@Transient //Ignoro este campo de mysql porque no tengo resuelto el tema de USER/PROFILE
	@OneToOne
	@JoinColumn(name = "user", referencedColumnName = "id")
	private User user;
	
	@ManyToMany(mappedBy = "student",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Subject> subjectsOfStudent;
	
	public void addSubject (Subject subject) {
		subjectsOfStudent.add(subject);
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getDocument_number() {
		return document_number;
	}
	public void setDocument_number(Integer document_number) {
		this.document_number = document_number;
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
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public List<Subject> getSubjectsOfStudent() {
		return subjectsOfStudent;
	}
	public void setSubjectsOfStudent(Subject subject,List<Subject> subjectsOfStudent) {
		subjectsOfStudent.add(subject);
		this.subjectsOfStudent = subjectsOfStudent;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", document_number=" + document_number + ", first_name=" + first_name
				+ ", last_name=" + last_name + "]";
	}
	
	
}