package com.spring.student.demo.kafka;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDetails {

	private int empId;
	private String empName;
	private String empLoc;
	
	
}
