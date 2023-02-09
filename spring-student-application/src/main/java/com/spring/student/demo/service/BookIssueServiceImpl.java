package com.spring.student.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.student.demo.entity.BookIssue;
import com.spring.student.demo.repositories.BookIssueReturnRepository;

@Service
public class BookIssueServiceImpl implements BookIssueService {

	private static Logger logger = LoggerFactory.getLogger(BookIssueServiceImpl.class);
	@Autowired
	BookIssueReturnRepository bookIssueReturnRepository;
	
	@Override
	public String issueBook(BookIssue bookIssue) { 
		logger.info("book issue info :: "+bookIssue);
		List<String> issuedBoks = bookIssueReturnRepository.getListOfIssuedBooks(bookIssue.getUsn());
		logger.info("Books issued :: "+ issuedBoks);
		if(issuedBoks.isEmpty()) {
		bookIssueReturnRepository.save(bookIssue);
		return "Book Issued";
		}
		else {
			StringBuffer response = new StringBuffer();
			logger.info("flag----"+issuedBoks.contains(bookIssue.getBookIsbn().toString())); 
			if(issuedBoks.contains(bookIssue.getBookIsbn().toString())){
				response.append(bookIssue.getBookIsbn().toString()+" already isued");
				logger.info("response== "+response); 
				return response.toString();
			}else {
				bookIssueReturnRepository.save(bookIssue);
				return "Book Issued";
			}
		}
	}

}
