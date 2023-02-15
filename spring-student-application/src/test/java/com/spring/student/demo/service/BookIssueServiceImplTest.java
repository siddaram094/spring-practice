package com.spring.student.demo.service;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.spring.student.demo.entity.BookIssue;
import com.spring.student.demo.repositories.BookIssueReturnRepository;


@RunWith(MockitoJUnitRunner.class)
@EnableJpaRepositories(value="com.spring.student.demo.repositories",
					   repositoryBaseClass = BookIssueReturnRepository.class)
public class BookIssueServiceImplTest {
	
	@Autowired
	BookIssueServiceImpl bookIssueServiceImpl;

	@Mock
	BookIssueReturnRepository bookIssueReturnRepository;

	@Before
	public void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void testIssueBook() {
		BookIssue bookIssue = new BookIssue();
		BookIssue.builder().usn("1rl08cs094")
				 .id(1)	
				 .bookIsbn("JAVA0011")
				 .fineFlag(false)
				 .fine(0)
				 .issueDate(LocalDate.now())
				 .actualReturnDate(LocalDate.now())
				 .actualReturnDate(LocalDate.now().plusDays(7))
				 .build();
		/*
		 * List<String> issuedBooks = new ArrayList<String>();
		 * issuedBooks.add("JAVA0011");
		 */
		when(bookIssueReturnRepository.getListOfIssuedBooks(anyString())).thenReturn(Arrays.asList("JAVA0011")); 
		//Mockito.when(bookIssueReturnRepository.getListOfIssuedBooks("1rl08cs094")).thenReturn(issuedBooks);
		
		assertEquals(bookIssue.getBookIsbn().toString()+" already isued", bookIssueServiceImpl.issueBook(bookIssue));
	}
}
