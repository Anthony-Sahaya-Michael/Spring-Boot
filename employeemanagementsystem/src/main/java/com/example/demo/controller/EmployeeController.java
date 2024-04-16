package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.EmployeeModel;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("Employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeservice;
	
	@Value("${message}")
	private String message;
	
	@GetMapping("welcomemessage")
	public String newcommer() {
		return message;
	}
	
	@GetMapping("employeedetails")
	public List<EmployeeModel> displayUsers(){
		return employeeservice.showAll();
	}
	
	@GetMapping("employeebyid/{id}")
	public Optional<EmployeeModel> displayUserById(@PathVariable int id) {
		return employeeservice.showById(id);
	}
	
	@PostMapping("storeemployee")
	public EmployeeModel saveDetails(@RequestBody EmployeeModel employeemodel) {
		return employeeservice.saveInfo(employeemodel);
	}
	
	@PostMapping("storenoofemployee")
	public List<EmployeeModel> saveAllDetails(@RequestBody List<EmployeeModel> employeemodel){
		return (List<EmployeeModel>)employeeservice.saveAllInformation(employeemodel);
	}
	
	@PutMapping("updateinfo")
	public EmployeeModel updateInfo(@RequestBody EmployeeModel employeemodel){
		return employeeservice.updatingInformation(employeemodel);
	}
	
	@PutMapping("updateinfobyid/{empid}")
	public EmployeeModel updateInfoById(@PathVariable int empid, @RequestBody EmployeeModel employeemodel) {
		employeemodel.setEmpno(empid);
		return employeeservice.updateInformationById(empid, employeemodel);
	}
	
	@DeleteMapping("deleteall")
	public String deletingAll(@RequestBody EmployeeModel employeemodel) {
		return employeeservice.deleteAllInfo(employeemodel);
	}
	
	@DeleteMapping("deletebyid/{id}")
	public String deleteById(@PathVariable int id) {
		return employeeservice.deleteById(id);
	}
	@PostMapping("/postEmp")
	public EmployeeModel postEmployee(@RequestBody EmployeeModel e) {
		return employeeservice.saveEmployee(e);
	}
}
