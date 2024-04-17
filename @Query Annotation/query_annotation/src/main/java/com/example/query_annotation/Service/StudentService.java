package com.example.query_annotation.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.query_annotation.Model.StudentModel;
import com.example.query_annotation.Repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public String addNewUser(StudentModel studentModel){
        studentRepository.save(studentModel);
        return "Added Successfully";
    }

    public Optional<StudentModel> fetchByUserInfo(Long student_id){
        return studentRepository.findById(student_id);
    }

    public StudentModel fetchByUserName(String studentName){
        return studentRepository.findByStudentName(studentName);
    }

    public List<StudentModel> getAllInformation(){
        return studentRepository.findAll();
    }

    public List<StudentModel> findByStudentMarks(float studentMarks){
        return studentRepository.findByStudentMarks(studentMarks);
    }
}
