package com.spring.student.demo.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.student.demo.entity.Book;

@RequestMapping("/book")
public interface BookResource {
	
	@PostMapping("/saveBook")
	public ResponseEntity<Object> saveBook(@RequestBody Book book);

}
