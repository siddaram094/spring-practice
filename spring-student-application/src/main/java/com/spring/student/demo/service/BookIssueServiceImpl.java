package com.spring.student.demo.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.spring.student.demo.entity.Book;
import com.spring.student.demo.entity.BookIssue;
import com.spring.student.demo.entity.BookReturn;
import com.spring.student.demo.repositories.BookIssueReturnRepository;
import com.spring.student.demo.repositories.BookRepository;

@Service
public class BookIssueServiceImpl implements BookIssueService {

	private static Logger logger = LoggerFactory.getLogger(BookIssueServiceImpl.class);

	BookIssueReturnRepository bookIssueReturnRepository;

	BookService bookService;
	
	BookRepository bookRepository;

	public BookIssueServiceImpl(BookIssueReturnRepository bookIssueReturnRepository, BookService bookService,BookRepository bookRepository) {
		this.bookIssueReturnRepository = bookIssueReturnRepository;
		this.bookService = bookService;
		this.bookRepository=bookRepository;
	}
	//getBookByISBN

	@Override
	public String issueBook(BookIssue bookIssue) {
		logger.info("book issue info :: " + bookIssue);
		List<String> issuedBoks = bookIssueReturnRepository.getListOfIssuedBooks(bookIssue.getUsn());
		logger.info("Books issued :: " + issuedBoks);
		if (issuedBoks.isEmpty()) {
			bookIssueReturnRepository.save(bookIssue);
			logger.info("ISBN to update quantity :"+bookIssue.getBookIsbn());
			Book book = bookRepository.findByBookIsbn(bookIssue.getBookIsbn().toString());
			logger.info("Book info : "+book);
			logger.info("quantity of books :" + book.getQuantity());
			book.setQuantity(book.getQuantity()-1);
			bookRepository.save(book); 
			return "Book Issued";
		} else {
			StringBuffer response = new StringBuffer();
			logger.info("flag----" + issuedBoks.contains(bookIssue.getBookIsbn().toString()));
			if (issuedBoks.contains(bookIssue.getBookIsbn().toString())) {
				response.append(bookIssue.getBookIsbn().toString() + " already isued");
				logger.info("response== " + response);
				return response.toString();
			} else {
				bookIssueReturnRepository.save(bookIssue);
				return "Book Issued";
			}
		}
	}

	@Override
	public String returnBook(BookReturn bookReturn) {
		List<BookIssue> issuedBooks = bookIssueReturnRepository.getAllIssuedBooksForStudent(bookReturn.getUsn());
		float fine = 0;
		LocalDate today = LocalDate.now();
		if (!issuedBooks.isEmpty()) {
			for (BookIssue issued : issuedBooks) {
				LocalDate returnDate = issued.getReturnDate();
				Period period = Period.between(today, returnDate);
				int diff = period.getDays();
				float finePerBook = 0;
				if (diff > 1) {
					finePerBook = (diff * 2);
					fine += finePerBook;
				}
				issued.setFine(finePerBook);
				issued.setReturnFlag(true);
				issued.setActualReturnDate(today);
				bookIssueReturnRepository.save(issued);
				Book book = bookRepository.findByBookIsbn(issued.getBookIsbn().toString());
				book.setQuantity(book.getQuantity()+1);
				bookRepository.save(book);
			}
			return "books are returned with fine : " + fine;
		} else {
			return "No Books issued to " + bookReturn.getUsn();
		}
	}

}
