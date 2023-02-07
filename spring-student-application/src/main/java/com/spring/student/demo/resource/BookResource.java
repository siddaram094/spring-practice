package com.spring.student.demo.resource;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.student.demo.entity.Book;

@RequestMapping("/book")
public interface BookResource {
	
	@PostMapping("/saveBook")
	public ResponseEntity<Object> saveBook(@RequestBody Book book);
	
	
	@GetMapping("/getBooks")
	public ResponseEntity<Object> getBooks();
	
	@PutMapping("/editBook/{bookIsbn}/{quantity}")
	public ResponseEntity<Object> editBook(@PathVariable("bookIsbn") String bookIsbn,@PathVariable("quantity") Integer quantity);

}
