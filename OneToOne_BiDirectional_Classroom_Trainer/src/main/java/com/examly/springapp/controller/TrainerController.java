package com.examly.springapp.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.Trainer;
import com.examly.springapp.service.TrainerServiceImpl;

@RestController
public class TrainerController {
    @Autowired
    private TrainerServiceImpl trainerServiceImpl;


    @PostMapping("/api/trainer/classroom/{classroomId}")
    public ResponseEntity<Trainer> addNewTrainerWithClassroomId(@PathVariable int classroomId, @RequestBody Trainer trainer){
        return ResponseEntity.status(201).body(trainerServiceImpl.addNewTrainerWithClassroomId(classroomId, trainer));
    } 

    @GetMapping("/api/trainer/expertise/{expertise}")
    public List<Trainer> getTrainerByExpertise(@PathVariable String expertise){
        return trainerServiceImpl.getTrainerByExpertise(expertise);
    }

    @DeleteMapping("/api/trainer/{trainerId}")
    public ResponseEntity<String> deleteTrainerById(@PathVariable int trainerId){
        Trainer obj = trainerServiceImpl.deleteTrainerById(trainerId);
        if(obj != null){
            return ResponseEntity.status(200).body("Trainer " + trainerId + " deleted successfully");
        }
        return ResponseEntity.status(404).body("Trainer with ID " + trainerId + " not found.");
    }
}
