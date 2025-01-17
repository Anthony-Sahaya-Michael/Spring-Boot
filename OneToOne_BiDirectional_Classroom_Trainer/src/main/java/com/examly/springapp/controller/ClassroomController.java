package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.examly.springapp.model.Classroom;
import com.examly.springapp.service.ClassroomServiceImpl;

@RestController
public class ClassroomController {
    @Autowired
    private ClassroomServiceImpl classroomServiceImpl;

    @PostMapping("/api/classroom")
    public ResponseEntity<Classroom> addNewClassroom(@RequestBody Classroom classroom){
        return ResponseEntity.status(201).body(classroomServiceImpl.addNewClassroom(classroom));
    }

    @GetMapping("/api/classroom/{classroomId}")
    public Classroom getClassroomById(@PathVariable int classroomId){
        return classroomServiceImpl.getClassroomById(classroomId);
    }

    @GetMapping("/api/classroom")
    public List<Classroom> getAllClassroom(){
        return classroomServiceImpl.getAllClassrooms();
    }
}
