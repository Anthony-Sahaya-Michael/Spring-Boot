package com.example.busbooking.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.busbooking.Model.BusModel;

import jakarta.transaction.Transactional;

@Repository
public interface BusRepository extends JpaRepository<BusModel, Integer> {
    List<BusModel> findByBusName(String busName);

    @Transactional
    @Modifying
    @Query("delete from BusModel s where s.busName = :busName")
    void getByBusNameQuery(String busName);
}
