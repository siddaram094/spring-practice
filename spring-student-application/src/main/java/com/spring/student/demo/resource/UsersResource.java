package com.spring.student.demo.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.student.demo.entity.Users;

@RequestMapping("/user")
public interface UsersResource {

	@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping("/saveUser")
	public ResponseEntity<Object> addUsers(@RequestBody Users users);
}
