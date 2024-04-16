package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.EmployeeModel;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeerepository;
	
	public List<EmployeeModel> showAll() {
		return employeerepository.findAll();
	}
	
	public Optional<EmployeeModel> showById(int id) {
		return employeerepository.findById(id);
	}
	
	public EmployeeModel saveInfo(EmployeeModel employeemodel) {
		return employeerepository.saveAndFlush(employeemodel);
	}
	
	public List<EmployeeModel> saveAllInformation(List<EmployeeModel> employeemodel) {
		return (List<EmployeeModel>)employeerepository.saveAll(employeemodel);
	}
	
	public EmployeeModel updatingInformation(EmployeeModel employeemodel) {
		return employeerepository.saveAndFlush(employeemodel);
	}
	
	public EmployeeModel updateInformationById(int empid, EmployeeModel employeemodel) {
		employeemodel.setEmpno(empid);
		return employeerepository.saveAndFlush(employeemodel);
	}
	
	public String deleteAllInfo(EmployeeModel employeemodel) {
		employeerepository.delete(employeemodel);
		return "Deleted Successfully";
	}
	
	public String deleteById(int id) {
		employeerepository.deleteById(id);
		return "Successfully Deleted by Id";
	}
	public EmployeeModel saveEmployee(EmployeeModel e) {
		return employeerepository.saveAndFlush(e);
	}
}
