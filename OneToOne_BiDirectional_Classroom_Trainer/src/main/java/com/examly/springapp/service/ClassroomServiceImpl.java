package com.examly.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.examly.springapp.exception.DuplicateClassroomException;
import com.examly.springapp.model.Classroom;
import com.examly.springapp.repository.ClassroomRepo;

@Service
public class ClassroomServiceImpl {
    @Autowired
    private ClassroomRepo classroomRepo;

    public Classroom addNewClassroom(Classroom classroom) throws DuplicateClassroomException{
        String className = classroom.getClassName();
        Classroom obj = classroomRepo.findByClassName(className);

        if(obj != null){
            throw new DuplicateClassroomException("Classroom with name " + className + " already exists!");
        }
        return classroomRepo.save(classroom);
    }

    public Classroom getClassroomById(int classroomId){
        return classroomRepo.findById(classroomId).orElse(null);
    }

    public List<Classroom> getAllClassrooms(){
        return classroomRepo.findAll();
    }
}
