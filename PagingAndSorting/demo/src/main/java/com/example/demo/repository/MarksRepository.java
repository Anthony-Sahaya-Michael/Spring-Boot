package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

//import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.entity.Stud;

public interface MarksRepository extends PagingAndSortingRepository<Stud, Long>, JpaRepository<Stud, Long> {
    Stud findByUSerName(String name);
    //List<Stud> findAllByPrice(double marks, Pageable pageable);
}

