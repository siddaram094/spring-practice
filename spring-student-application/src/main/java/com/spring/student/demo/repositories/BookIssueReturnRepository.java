package com.spring.student.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.student.demo.entity.BookIssue;

@Repository
public interface BookIssueReturnRepository extends JpaRepository<BookIssue, Long> {
	
	
	  @Query(value="select book_isbn from springsecurity.book_issue where usn=?1  and return_flag=false",nativeQuery = true)
	  public List<String> getListOfIssuedBooks(String usn);
	  
	  @Query(value = "select * from springsecurity.book_issue where usn=?1 and return_flag=false",nativeQuery = true)
	  public List<BookIssue> getAllIssuedBooksForStudent(String usn);
	 

}
