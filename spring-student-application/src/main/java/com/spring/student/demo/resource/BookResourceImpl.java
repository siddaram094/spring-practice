package com.spring.student.demo.resource;

import java.util.List;

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


	@ApiOperation(value = "To Get All the Books",tags = "Book Management")
	@Override
	public ResponseEntity<Object> getBooks() { 
		List<Book> books = bookService.getBooks();
		if(books.isEmpty()) {
			return new ResponseEntity<Object>("No Books present in Database", HttpStatus.OK);
		}
		return new ResponseEntity<Object>(books, HttpStatus.OK);
	}

	/*
	 * @Override public ResponseEntity<Object> editBook(Book book) { String response
	 * = bookService.editBook(book); return new ResponseEntity<Object>(response,
	 * HttpStatus.OK); }
	 */

	@ApiOperation(value = "To Update Book Quantity",tags = "Book Management")
	@Override
	public ResponseEntity<Object> editBook(String bookIsbn, Integer quantity) {
		String response = bookService.editBook(bookIsbn,quantity);
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
	
	

}
