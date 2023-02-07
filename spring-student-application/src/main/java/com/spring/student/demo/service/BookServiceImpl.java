package com.spring.student.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.student.demo.entity.Book;
import com.spring.student.demo.repositories.BookRepository;


@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookRepository bookRepository;
	
	@Override
	public String saveBook(Book book) {
		
		Book bookDB = bookRepository.findByBookIsbn(book.getBookIsbn());
		if(bookDB==null)
		{
			bookRepository.save(book);
			return "book saved successfully";
		}
		return "book already exists";
	}

}
