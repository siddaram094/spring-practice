package com.spring.student.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.student.demo.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

	Book findByBookIsbn(String bookIsbn); 

}
