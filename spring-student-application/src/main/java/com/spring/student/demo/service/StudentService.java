package com.spring.student.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.student.demo.entity.Student;

@Service
public interface StudentService {

	public String persistStudent(Student student);

	public String updateStudentInfo(Student student);

	public Student getStudentByUsn(String studentUsn);

	public List<Student> getStudentsByDept(String deptName);

	public List<Student> getStudentsBySem(String sem);
 
	public String deleteStudent(String studentUsn);    
}
