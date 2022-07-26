package com.ayush.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "emp_table")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "emp_id")
	private Long empId; 
	
	@Column(name="first_name")
	private String empFirstName;
	
	@Column(name="last_name")
	private String empLastName;
	
	@Column(name="designation")
	private String empDesignation;
	
	@Column(name="salary")
	private Long empSalary;
	
}
