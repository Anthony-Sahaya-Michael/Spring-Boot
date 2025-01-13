package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.example.demo.exception.DuplicateEmployeeException;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employee")
    public ResponseEntity<?> addNewEmployee(@RequestBody Employee employee){
        try{
            Employee obj = employeeService.addNewEmployee(employee);
            return ResponseEntity.status(201).body(obj);
        }
        catch(DuplicateEmployeeException ex){
            return ResponseEntity.status(500).body("Errororororoorororor");
        }
    }

    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return ResponseEntity.status(200).body(employeeService.getAllEmployees());
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") int empId, @RequestBody Employee employee){
        return ResponseEntity.status(200).body(employeeService.updateEmployee(empId, employee));
    }

    @DeleteMapping("/employee/{empId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int empId){
        Employee emp = employeeService.deleteEmployee(empId);
        if(emp != null){
            return ResponseEntity.status(200).body("Deleted Successfully");
        }
        return ResponseEntity.status(204).body("No data");
    }
}
