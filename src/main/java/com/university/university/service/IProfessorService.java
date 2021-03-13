package com.university.university.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.university.university.model.Professor;



@Service
public interface IProfessorService {

	List<Professor> findAll();
	
	Professor findById(Integer idProfessor);
	
	void saveProfessor(Professor prof);
	
	void deleteProfessor(Integer idProf);
}
