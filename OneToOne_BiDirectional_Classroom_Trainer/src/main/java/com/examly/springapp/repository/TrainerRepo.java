package com.examly.springapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examly.springapp.model.Trainer;

@Repository
public interface TrainerRepo extends JpaRepository<Trainer, Integer> {
    public List<Trainer> findByExpertise(String expertise);
}
