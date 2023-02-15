package com.spring.student.demo.error;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Error {

	private String details;
	private String errorMessage;
	private LocalDate date;
	
}
