package com.example.query_annotation.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class StudentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long studentId;
    private String studentName;
    private float studentMarks;

    StudentModel(){

    }


    public StudentModel(String studentName, float studentMarks) {
        this.studentName = studentName;
        this.studentMarks = studentMarks;
    }



    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public float getStudentMarks() {
        return studentMarks;
    }
    public void setStudentMarks(float studentMarks) {
        this.studentMarks = studentMarks;
    }


    
}