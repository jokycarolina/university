package com.university.university.service;

import java.util.List;

import com.university.university.model.Profile;



public interface IProfileService {

	List <Profile> findAll();
	
	Profile findById(Integer idProfile);
}
