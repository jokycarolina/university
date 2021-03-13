package com.university.university.service;

import java.util.List;

import com.university.university.model.Subject;





public interface ISubjectService {

	Subject findById(Integer idSubject);
	List <Subject> findAll();
	void save(Subject subject);
	void delete(Integer idsubject);
}
