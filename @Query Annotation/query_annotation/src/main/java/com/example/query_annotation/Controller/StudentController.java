package com.example.query_annotation.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.query_annotation.Model.StudentModel;
import com.example.query_annotation.Service.StudentService;

@RestController
public class StudentController {

    private final StudentService studentService;
    
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/welcome")
    public String welcomeMessage(){
        return "Welcome to the World";
    }

    @GetMapping("/getAllInformation")
    public List<StudentModel> getAllInformation(){
        return studentService.getAllInformation();
    }

    @GetMapping("/fetchByUserInfo/{key}")
    public Optional<StudentModel> fetchByUserInfo(@PathVariable Long key){
        return studentService.fetchByUserInfo(key);
    }

    @GetMapping("/fetchByUserName/{studentName}")
    public StudentModel fetchByUserName(@PathVariable String studentName){
        return studentService.fetchByUserName(studentName);
    }

    @GetMapping("/findByStudentMarks/{studentMarks}")
    public List<StudentModel> findByStudentMarks(@PathVariable float studentMarks){
        return studentService.findByStudentMarks(studentMarks);
    }

    @PostMapping("/addUser")
    public String addingNewUser(@RequestBody StudentModel studentModel){
        studentService.addNewUser(studentModel);
        return "Added Successfully";
    }
}
