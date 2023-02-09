package com.spring.student.demo.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.student.demo.entity.BookIssue;
import com.spring.student.demo.entity.BookIssuence;

@RequestMapping("/bookIssueReturn")
public interface BookIssueResource {
	
	@PreAuthorize("hasAnyRole('USER','ADMIN')")
	@PostMapping("/isueBook")
	public ResponseEntity<Object> issueBook(@RequestBody BookIssuence issueBook);


}
