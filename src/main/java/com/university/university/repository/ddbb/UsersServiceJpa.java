package com.university.university.repository.ddbb;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.university.university.model.User;
import com.university.university.repository.UserRepository;
import com.university.university.service.IUserService;


@Service
@Primary
public class UsersServiceJpa implements IUserService {

	@Autowired
	private UserRepository repoUser;
	
	@Override
	public User findById(Integer idUser) {
		Optional <User> user = repoUser.findById(idUser);
		
		if(user.isPresent()) {
			return user.get();
		}
		return null;
	}

	@Override
	public List<User> findAll() {
		return repoUser.findAll();
	}

}
