package com.spring.student.demo.service;

import java.util.List;

import com.spring.student.demo.entity.Book;

public interface BookService {

	public String saveBook(Book book);

	public List<Book> getBooks();

	/* public String editBook(Book book); */
 
	public String editBook(String bookIsbn, Integer quantity);  
}
