package com.university.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.university.university.model.Schedule;



public interface SchedulesRepository extends  JpaRepository <Schedule, Integer> {

}
