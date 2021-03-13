package com.university.university.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.university.university.model.Subject;

public interface SubjectsRepository extends  JpaRepository<Subject, Integer> {

}
