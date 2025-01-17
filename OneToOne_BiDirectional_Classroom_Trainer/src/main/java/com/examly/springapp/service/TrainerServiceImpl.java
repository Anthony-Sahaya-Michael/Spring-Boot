package com.examly.springapp.service;

import static org.mockito.Mockito.times;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.examly.springapp.model.Classroom;
import com.examly.springapp.model.Trainer;
import com.examly.springapp.repository.ClassroomRepo;
import com.examly.springapp.repository.TrainerRepo;

@Service
public class TrainerServiceImpl {
    @Autowired
    private TrainerRepo trainerRepo;

    @Autowired
    private ClassroomRepo classroomRepo;

    public Trainer addNewTrainerWithClassroomId(int classroomId, Trainer trainer){
        Classroom obj = classroomRepo.findById(classroomId).orElse(null);
        if(obj != null){
            trainer.setClassroom(obj);
            trainerRepo.save(trainer);
            obj.setTrainer(trainer);
            classroomRepo.save(obj);
            return trainer;
        } 
        return null;
    }

    public List<Trainer> getTrainerByExpertise(String expertise){
        return trainerRepo.findByExpertise(expertise);
    }

    public Trainer deleteTrainerById(int trainerId){
        Trainer obj = trainerRepo.findById(trainerId).orElse(null);
        if(obj != null){
            obj.setClassroom(null);
            trainerRepo.save(obj);
            trainerRepo.deleteById(trainerId);
            return obj;
        }
        return null;
    }
}
