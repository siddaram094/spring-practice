package com.spring.student.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="role")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Roles {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int roleId;
	private String role;
}
