package com.example.busbooking.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.busbooking.Model.BusModel;
import com.example.busbooking.Repository.BusRepository;


@Service
public class BusService {

    private final BusRepository busRepository;
    
    @Autowired
    public BusService(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    public List<BusModel> getByBusName(String busName){
        return busRepository.findByBusName(busName);
    }

    public void getByBusNameQuery(String busName){
        busRepository.getByBusNameQuery(busName);
    }

    public BusModel addUserInformation(BusModel busModel){
        return busRepository.save(busModel);
    }
}
