package com.spring.student.demo.service;

import org.springframework.stereotype.Service;

import com.spring.student.demo.entity.BookIssue;
import com.spring.student.demo.entity.BookReturn;

@Service
public interface BookIssueService {

	public String issueBook(BookIssue bookIssue);
	
	public String returnBook(BookReturn bookReturn); 
}
