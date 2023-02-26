package com.spring.student.demo.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class BookIssue {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String bookIsbn;
	private String usn;
	private LocalDate issueDate;
	private LocalDate returnDate;
	private LocalDate actualReturnDate;
	private boolean fineFlag=false;
	private float fine=0;
	private boolean returnFlag=false;
	
	
	public String getBookIsbn() {
		return bookIsbn;
	}
	
	//using builder pattern to return current object post setting a value to a field 
	public BookIssue setBookIsbn(String bookIsbn) {
		this.bookIsbn = bookIsbn;
		return this;
	}
	public String getUsn() {
		return usn;
	}
	public BookIssue setUsn(String usn) {
		this.usn = usn;
		return this;
	}
	public LocalDate getIssueDate() {
		return issueDate;
	}
	public BookIssue setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
		return this;
	}
	public LocalDate getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}
	public LocalDate getActualReturnDate() {
		return actualReturnDate;
	}
	public BookIssue setActualReturnDate(LocalDate actualReturnDate) {
		this.actualReturnDate = actualReturnDate;
		return this;
	}
	public boolean isFineFlag() {
		return fineFlag;
	}
	public BookIssue setFineFlag(boolean fineFlag) {
		this.fineFlag = fineFlag;
		return this;
	}
	public float getFine() {
		return fine;
	}
	public BookIssue setFine(float fine) {
		this.fine = fine;
		return this;
	}

	public boolean isReturnFlag() {
		return returnFlag;
	}

	public BookIssue setReturnFlag(boolean returnFlag) {
		this.returnFlag = returnFlag;
		return this;
	}
	
	
}
