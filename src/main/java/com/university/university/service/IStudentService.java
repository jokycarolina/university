package com.university.university.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.university.university.model.Student;
import com.university.university.model.Subject;

@Service
public interface IStudentService {

	List <Student> findAll();
	
	Student findById(Integer id);
	
	void saveSubject (int idStudent,int idSubject);
	
	void deleteSubject (int idSubject);
	
	
}
