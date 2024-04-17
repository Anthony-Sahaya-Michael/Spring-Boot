package com.example.query_annotation.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.query_annotation.Model.StudentModel;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel, Long> {
    public StudentModel findByStudentName(String studentName);

    @Query("SELECT s FROM StudentModel s where s.studentMarks > :studentMarks")
    public List<StudentModel> findByStudentMarks(float studentMarks);
}
