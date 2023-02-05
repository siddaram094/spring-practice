package com.spring.student.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.student.demo.entity.Users;
import com.spring.student.demo.repositories.UsersRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UsersRepository userRepository;
	
	@Override
	public String saveUer(Users user) {
		boolean userData = userRepository.findByName(user.getName()).isPresent();
		if(!userData) {
			userRepository.save(user);
			return user.getName()+ " saved successfully";
		}
		return user.getName()+" already exists";
	}

}
