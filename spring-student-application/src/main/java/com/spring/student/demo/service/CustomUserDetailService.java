package com.spring.student.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.student.demo.entity.CustomUserDetails;
import com.spring.student.demo.entity.Users;
import com.spring.student.demo.repositories.UsersRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	UsersRepository usersRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("userName=  " + username);
		Optional<Users> users = usersRepository.findByName(username);
		users
		.orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
		
		return
				users.map(CustomUserDetails::new).get();
	}

}
