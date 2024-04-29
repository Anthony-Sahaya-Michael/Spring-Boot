package com.example.busbooking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.busbooking.Model.BusDriver;

public interface BusDriverRepository extends JpaRepository<BusDriver, Integer>{
    
}
