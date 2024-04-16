package com.example.demo.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "employeemodel")
public class EmployeeModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int empno;
	private String empname;
	private long empphoneno;
	private int empexperience;
	private double empsalary;
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="fk_id")
	private EmployeeCredentials employeeCredentials;
	

	
	public EmployeeCredentials getEmployeeCredentials() {
		return employeeCredentials;
	}


	public void setEmployeeCredentials(EmployeeCredentials employeeCredentials) {
		this.employeeCredentials = employeeCredentials;
	}


	public EmployeeModel(int empno, String empname, long empphoneno, int empexperience, double empsalary,
			EmployeeCredentials employeeCredentials) {
		super();
		this.empno = empno;
		this.empname = empname;
		this.empphoneno = empphoneno;
		this.empexperience = empexperience;
		this.empsalary = empsalary;
		this.employeeCredentials = employeeCredentials;
	}


	public EmployeeModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public EmployeeModel(int empno, String empname, long empphoneno, int empexperience, double empsalary) {
		super();
		this.empno = empno;
		this.empname = empname;
		this.empphoneno = empphoneno;
		this.empexperience = empexperience;
		this.empsalary = empsalary;
	}
	
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public long getEmpphoneno() {
		return empphoneno;
	}
	public void setEmpphoneno(long empphoneno) {
		this.empphoneno = empphoneno;
	}
	public int getEmpexperience() {
		return empexperience;
	}
	public void setEmpexperience(int empexperience) {
		this.empexperience = empexperience;
	}
	public double getEmpsalary() {
		return empsalary;
	}
	public void setEmpsalary(double empsalary) {
		this.empsalary = empsalary;
	}
}
