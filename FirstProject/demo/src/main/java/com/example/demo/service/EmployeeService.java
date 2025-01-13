package com.example.demo.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.demo.exception.DuplicateEmployeeException;
import com.example.demo.model.Employee;

@Service
public class EmployeeService {
    List<Employee> allEmployees = new ArrayList<>();

    public Employee addNewEmployee(Employee employee){
        for(Employee emp : allEmployees){
            if(emp.getEmpId() == employee.getEmpId()){
                throw new DuplicateEmployeeException("Already Exist");
            }
        }
        allEmployees.add(employee);
        return employee;
    }

    public List<Employee> getAllEmployees(){
        return allEmployees;
    }

    public Employee updateEmployee(int empId, Employee newEmployee){
        
        for(Employee employee : allEmployees){
            if(employee.getEmpId() == empId){
                if(newEmployee.getEmpName() != null){
                    String name = newEmployee.getEmpName();
                    employee.setEmpName(name);
                }
                if(newEmployee.getEmpSalary() > 0){
                    double salary = newEmployee.getEmpSalary();
                    employee.setEmpSalary(salary);
                }
                if(newEmployee.getEmpExperience() >= 0){
                    int experience = newEmployee.getEmpExperience();
                    employee.setEmpExperience(experience);
                }
                return employee;
            }
        }
        allEmployees.add(newEmployee);
        return newEmployee;
    }

    public Employee deleteEmployee(int empId){
        for(Employee employee : allEmployees){
            if(employee.getEmpId() == empId){
                allEmployees.remove(employee);
                return employee;
            }
        }
        return null;
    }

}
