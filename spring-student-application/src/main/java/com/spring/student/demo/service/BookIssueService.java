package com.spring.student.demo.service;

import org.springframework.stereotype.Service;

import com.spring.student.demo.entity.BookIssue;

@Service
public interface BookIssueService {

	public String issueBook(BookIssue bookIssue);
}
