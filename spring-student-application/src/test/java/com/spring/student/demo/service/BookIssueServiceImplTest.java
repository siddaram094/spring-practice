package com.spring.student.demo.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Any;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.fasterxml.jackson.databind.Module.SetupContext;
import com.spring.student.demo.entity.BookIssue;
import com.spring.student.demo.repositories.BookIssueReturnRepository;

@RunWith(MockitoJUnitRunner.class)
/*
 * @EnableJpaRepositories(value = "com.spring.student.demo.repositories",
 * repositoryBaseClass = BookIssueReturnRepository.class)
 */
public class BookIssueServiceImplTest {

	BookIssueReturnRepository bookIssueReturnRepository;
	BookIssueServiceImpl bookIssueServiceImpl;
	
	@BeforeEach
	public void setup() {
		bookIssueReturnRepository = Mockito.mock(BookIssueReturnRepository.class);
		bookIssueServiceImpl = new BookIssueServiceImpl(bookIssueReturnRepository);
	}

	@Test
	public void testIssueBook() {
		BookIssue bookIssue = new BookIssue();
		bookIssue.setUsn("1rl08cs094");
		bookIssue.setBookIsbn("JAVA0011");
		bookIssue.setActualReturnDate(LocalDate.now().plusDays(7));
		bookIssue.setFine(0);
		bookIssue.setFineFlag(false);
		bookIssue.setIssueDate(LocalDate.now());
		bookIssue.setReturnDate(LocalDate.now());
		/*
		 * BookIssue.builder().usn("1rl08cs094") .id(1) .bookIsbn("JAVA0011")
		 * .fineFlag(false) .fine(0) .issueDate(LocalDate.now())
		 * .returnDate(LocalDate.now())
		 * .actualReturnDate(LocalDate.now().plusDays(7)).build();
		 */
		System.out.println(bookIssue);

		List<String> issuedBooks = new ArrayList<String>();
		issuedBooks.add("JAVA0011");
		issuedBooks.add("JAVA0022");
		
		System.out.println(issuedBooks);
		when(bookIssueReturnRepository.getListOfIssuedBooks(bookIssue.getUsn())).thenReturn(issuedBooks);
		assertEquals(bookIssue.getBookIsbn().toString() + " already isued", bookIssueServiceImpl.issueBook(bookIssue));
	}
}
