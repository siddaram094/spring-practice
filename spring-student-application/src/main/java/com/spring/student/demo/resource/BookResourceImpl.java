package com.spring.student.demo.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.student.demo.entity.Book;
import com.spring.student.demo.service.BookService;

import io.swagger.annotations.ApiOperation;

@RequestMapping("/book")
@RestController
public class BookResourceImpl implements BookResource {

	@Autowired
	BookService bookService;
	

	@ApiOperation(value = "To add new book to database",tags = "Book Management")
	@Override
	public ResponseEntity<Object> saveBook(Book book) {
		String bookSaveResponse = bookService.saveBook(book);
		return new ResponseEntity<Object>(bookSaveResponse, HttpStatus.OK);
	}

}
