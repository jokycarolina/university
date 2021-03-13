package com.university.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.university.university.model.Professor;



public interface ProfessorsRepository extends JpaRepository<Professor, Integer> {

}
