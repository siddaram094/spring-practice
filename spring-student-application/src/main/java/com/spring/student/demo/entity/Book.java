package com.spring.student.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bookId;
	private String bookName;
	private String bookIsbn;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="BOOK_AUTHOR",joinColumns = @JoinColumn(name="bookId"),inverseJoinColumns = @JoinColumn(name="authorId"))
	private List<Author> auhthors;
	private String publications;
	private int quantity;

}
