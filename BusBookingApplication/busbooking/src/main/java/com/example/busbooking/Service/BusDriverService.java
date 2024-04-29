package com.example.busbooking.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.busbooking.Model.BusDriver;
import com.example.busbooking.Repository.BusDriverRepository;

@Service
public class BusDriverService {
    private final BusDriverRepository busDriverRepository;

    @Autowired
    public BusDriverService(BusDriverRepository busDriverRepository) {
        this.busDriverRepository = busDriverRepository;
    }

    public String busDriverAddUserDetails(BusDriver busDriver){
        if(busDriver == null){
            return "No data";
        }
        busDriverRepository.save(busDriver);
        return "Done";
    }

}
