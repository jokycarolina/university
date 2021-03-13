package com.university.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.university.university.model.User;



public interface UserRepository extends JpaRepository<User, Integer> {

}
