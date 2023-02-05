package com.spring.student.demo.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.student.demo.entity.Users;
import com.spring.student.demo.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
public class UserResourceImpl implements UsersResource {

	@Autowired
	UserService userService;
	
	@ApiOperation(value = "persist the student",code = 200,tags = "User Management")
	@Override
	public ResponseEntity<Object> addUsers(Users users) {
		String response = userService.saveUer(users);
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}

}
