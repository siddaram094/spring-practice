package com.spring.student.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.student.demo.entity.Student;

@Repository
public interface StudentRepositories extends JpaRepository<Student, Long> {

	Student findByUsn(String usn);

	List<Student> findByDept(String deptName);

	List<Student> findBySem(String sem);   

}
