package com.spring.student.demo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.spring.student.demo.entity.Student;
import com.spring.student.demo.service.StudentService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/student")
public class StudentResourceImpl implements StudentResource {
	
	@Autowired
	StudentService studentService;

	
	@ApiOperation(value = "persist the student",code = 200,tags = "Student Management")
	@Override
	public ResponseEntity<Object> persistStudent(Student student) { 
		String response = studentService.persistStudent(student); 
		return new ResponseEntity<Object>(response, HttpStatus.OK); 
	}


	@ApiOperation(value = "Edit student information",tags = "Student Management")
	@Override
	public ResponseEntity<Object> updateStudentInformation(Student student) {
		String updateResponse  = studentService.updateStudentInfo(student);
		return new ResponseEntity<Object>(updateResponse, HttpStatus.OK); 
	}

	@ApiOperation(value = "Get Student Based on USN",tags="Student Management")
	@Override
	public ResponseEntity<Object> getStudents(String studentUsn) {
		Student student = studentService.getStudentByUsn(studentUsn);
		if(student!=null) {
			return new ResponseEntity<Object>(student, HttpStatus.OK);
		}
		return new ResponseEntity<Object>(studentUsn+" not found", HttpStatus.NOT_FOUND);
	}


	@ApiOperation(value = "Get Student by Dept" , tags = "Student Management")
	@Override
	public ResponseEntity<List<Student>> getStudentsByDept(String deptName) {
		List<Student> students = studentService.getStudentsByDept(deptName);
		if(!students.isEmpty()) {
			return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
		}
		return new ResponseEntity<List<Student>>(students, HttpStatus.NOT_FOUND);
	}


	@ApiOperation(value = "Get Studenst By Sem",tags = "Student Management")
	@Override
	public ResponseEntity<List<Student>> getStudentsBySem(String sem) {
		List<Student> students  = studentService.getStudentsBySem(sem);
		if(!students.isEmpty()) {
			return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
		}
		return new ResponseEntity<List<Student>>(students, HttpStatus.NOT_FOUND);
	}


	@ApiOperation(value = "Delete Student based on USN" , tags="Student Management")
	@Override
	public ResponseEntity<Object> deleteStudentByUsn(String studentUsn) {
		String response = studentService.deleteStudent(studentUsn);
		return new ResponseEntity<Object>(response, HttpStatus.OK); 
	}

}
