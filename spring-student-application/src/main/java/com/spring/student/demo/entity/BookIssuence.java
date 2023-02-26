package com.spring.student.demo.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

//this class helps to just take the usn and isbn and creates the BookIssue object that later used to issue the book to student if not issed already 
public class BookIssuence {

	private String bookIsbn;
	private String usn;
	
	public static BookIssue getBookToIssue(BookIssuence issueBook) {
		BookIssue bookIssue= new BookIssue();
		LocalDate today = LocalDate.now();
		LocalDate returnDate = today.plusDays(15); 
		
		//builder pattern to construct the object of BookIssue
		bookIssue.setUsn(issueBook.getUsn())
				  .setBookIsbn(issueBook.getBookIsbn())
				  .setFine(0)
				  .setFineFlag(false)
				  .setReturnFlag(false)
				  .setIssueDate(today)
				  .setReturnDate(returnDate);
		
		return bookIssue;
	}
}
