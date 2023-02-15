package com.spring.student.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.student.demo.entity.Book;
import com.spring.student.demo.error.BookNotFoundException;
import com.spring.student.demo.repositories.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepository bookRepository;

	@Override
	public String saveBook(Book book) {

		Book bookDB = bookRepository.findByBookIsbn(book.getBookIsbn());
		if (bookDB == null) {
			bookRepository.save(book);
			return "book saved successfully";
		}
		throw new BookNotFoundException("Book Already Exists"); 
	}

	@Override
	public List<Book> getBooks() {
		List<Book> books = bookRepository.findAll();
		return books;
	}

	/*
	 * @Override public String editBook(Book book) { Book bookDB =
	 * bookRepository.findByBookIsbn(book.getBookIsbn()); if(bookDB!=null) {
	 * if(book.getQuantity()!=0) { bookDB.setQuantity(book.getQuantity()); }
	 * bookRepository.save(bookDB); return "Quantity Updated successfully"; } return
	 * "No Books found for ISBN  " +book.getBookIsbn() ; }
	 */

	@Override
	public String editBook(String bookIsbn, Integer quantity) {
		Book bookDB = bookRepository.findByBookIsbn(bookIsbn);
		if (bookDB != null) {
			bookDB.setQuantity(quantity);
			bookRepository.save(bookDB);
			return "Quantity Updated successfully";
		}
		return "No Books found for ISBN  " + bookIsbn;
	}

	

}
