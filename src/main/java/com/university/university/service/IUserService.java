package com.university.university.service;

import java.util.List;

import com.university.university.model.User;



public interface IUserService {
	
	User findById(Integer idUser);
	
	List <User> findAll();

}
