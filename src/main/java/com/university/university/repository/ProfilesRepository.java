package com.university.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.university.university.model.Profile;



public interface ProfilesRepository extends JpaRepository <Profile, Integer>  {

}
