package com.spring.student.demo.resource;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.student.demo.entity.Student;

@RequestMapping("/student")
public interface StudentResource {

	@PostMapping("/saveStudent")
	public ResponseEntity<Object> persistStudent(@RequestBody Student student);
	
	@PutMapping("/updateStudent")
	public ResponseEntity<Object> updateStudentInformation(@RequestBody Student student);
	
	@GetMapping("/getStudentByUsn/{studentUsn}")
	public ResponseEntity<Object> getStudents(@PathVariable("studentUsn") String studentUsn);
	
	@GetMapping("/getStudentByDept/{deptName}")
	public ResponseEntity<List<Student>> getStudentsByDept(@PathVariable("deptName") String deptName);
	
	@GetMapping("/getStudentBySem/{sem}")
	public ResponseEntity<List<Student>> getStudentsBySem(@PathVariable("sem") String sem);
	
	@DeleteMapping("/{studentUsn}")
	public ResponseEntity<Object> deleteStudentByUsn(@PathVariable("studentUsn") String studentUsn);
}
