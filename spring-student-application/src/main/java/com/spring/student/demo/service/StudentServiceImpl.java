package com.spring.student.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.student.demo.entity.Student;
import com.spring.student.demo.repositories.StudentRepositories;

@Service
public class StudentServiceImpl implements StudentService {
	Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

	@Autowired
	StudentRepositories studentRepository;
	@Override
	public String persistStudent(Student student) {
		Student studentDb = studentRepository.findByUsn(student.getUsn());
		if(studentDb==null) {
			studentRepository.save(student);
			return "Student saved successfully";
		}
		return "Student already exists";
	}
	@Override
	public String updateStudentInfo(Student student) {
		logger.info("student from request"+student); 
		Student studentDb = studentRepository.findByUsn(student.getUsn());
		logger.info("student from db"+studentDb); 
		if(studentDb!=null) {
			if(student.getDept()!=null && !student.getDept().equals("")) {
				studentDb.setDept(student.getDept());
			}
			if(student.getEmailId()!=null && !student.getEmailId().equals("")) {
				studentDb.setEmailId(student.getEmailId());
			}
			if(student.getFirstName()!=null && !student.getFirstName().equals("")) {
				studentDb.setFirstName(student.getFirstName());
			}
			if(student.getLastName()!=null && !student.getLastName().equals("")) {
				studentDb.setLastName(student.getLastName());
			}
			if(student.getMiddleName()!=null && !student.getMiddleName().equals("")) {
				studentDb.setMiddleName(student.getMiddleName());
			}
			if(student.getPhNum()!=null && !student.getPhNum().equals("")) {
				studentDb.setPhNum(student.getPhNum());
			}
			if(student.getSem()!=null && !student.getSem().equals("")) {
				studentDb.setSem(student.getSem());
			}
			studentRepository.save(studentDb);
			return student.getUsn() +" updated successfully";
		}
		return student.getUsn() + " doesn't exists";
	}
	
	
	@Override
	public Student getStudentByUsn(String studentUsn) {
		Student studentDb = studentRepository.findByUsn(studentUsn);
		return studentDb;
		
	}
	@Override
	public List<Student> getStudentsByDept(String deptName) {
		List<Student> students = studentRepository.findByDept(deptName);
		return students;
	}
	@Override
	public List<Student> getStudentsBySem(String sem) {
		List<Student> students = studentRepository.findBySem(sem);
		return students;
	}
	@Override
	public String deleteStudent(String studentUsn) {
		Student student = studentRepository.findByUsn(studentUsn);
		if(student!=null) {
			Long studentId = student.getStudentId();
			studentRepository.deleteById(studentId);
			return studentUsn+" deleted";
		}
		return studentUsn+" not found";
	}
	

}
