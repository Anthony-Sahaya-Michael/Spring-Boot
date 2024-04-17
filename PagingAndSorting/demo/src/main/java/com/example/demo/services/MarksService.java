package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Stud;
import com.example.demo.repository.MarksRepository;

@Service
public class MarksService {

    @Autowired
    private MarksRepository marksRepository;

    public Page<Stud> getAllMarks(int page, int size, String sortBy) {
        PageRequest pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return marksRepository.findAll(pageable);
    }

}
