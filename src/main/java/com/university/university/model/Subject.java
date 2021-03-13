package com.university.university.model;

import java.util.ArrayList;
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

@Entity
@Table(name="subject")
public class Subject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer place_max;
	private String name_subject;
	
	@OneToOne
	@JoinColumn(name = "schedule_subject")
	private Schedule schedule_subject;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "subject_professor", joinColumns = @JoinColumn(name = "id_subject"), inverseJoinColumns = @JoinColumn(name = "id_professor"))
	private List<Professor> professors;
	
	@ManyToMany(fetch= FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Student> student = new ArrayList<>();
	
	
	public void addStudent (Student student) {
		this.student.add(student);
	}
	
	public void addProfessor(Professor prof) {
		professors = new ArrayList<>();
		professors.add(prof);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPlace_max() {
		return place_max;
	}

	public void setPlace_max(Integer place_max) {
		this.place_max = place_max;
	}

	public String getName_subject() {
		return name_subject;
	}

	public void setName_subject(String name_subject) {
		this.name_subject = name_subject;
	}

	public Schedule getSchedule_subject() {

		
		return schedule_subject;
	}

	public void setSchedule_subject(Schedule schedule_subject) {
		
		this.schedule_subject = schedule_subject;
	}
	
	public List<Professor> getProfessors() {
		return professors;
	}

	public void setProfessors(List<Professor> professors) {
		this.professors = professors;
	}
	
	
	public List<Student> getStudents() {
		return student;
	}

	public void setStudents(List<Student> students) {
		this.student = students;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", place_max=" + place_max + ", name_subject=" + name_subject
				+ ", schedule_subject=" + schedule_subject + "]";
	} 
	
	
	
}