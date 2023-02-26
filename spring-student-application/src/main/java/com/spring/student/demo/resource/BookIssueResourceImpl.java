package com.spring.student.demo.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.student.demo.entity.BookIssue;
import com.spring.student.demo.entity.BookIssuence;
import com.spring.student.demo.entity.BookReturn;
import com.spring.student.demo.service.BookIssueService;

import io.swagger.annotations.ApiOperation;

@RequestMapping("/bookIssueReturn")
@RestController
public class BookIssueResourceImpl implements BookIssueResource {
	
	private static Logger logger  = LoggerFactory.getLogger(BookIssueResourceImpl.class);

	@Autowired
	BookIssueService bookIssueService;
	@ApiOperation(tags = "Book Issue",value="provides an option to issue book to student")
	@Override
	public ResponseEntity<Object> issueBook(BookIssuence issueBook) {
		BookIssue bookIssue= BookIssuence.getBookToIssue(issueBook);
		logger.info("bookIssue data :: "+bookIssue); 
		String response = bookIssueService.issueBook(bookIssue);
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
	
	@ApiOperation(tags="Book Issue",value="provides an option to retunr books issed to students")
	@Override
	public ResponseEntity<Object> returnBooks(BookReturn bookReturn) {
		logger.info("Books retunr request for " + bookReturn); 
		String response = bookIssueService.returnBook(bookReturn);
		logger.info("book return response : "+response); 
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}

}
