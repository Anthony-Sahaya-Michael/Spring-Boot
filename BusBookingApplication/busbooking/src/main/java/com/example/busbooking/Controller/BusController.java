package com.example.busbooking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.busbooking.Model.BusModel;
import com.example.busbooking.Service.BusService;


@RestController
public class BusController {
    private final BusService busService;
    
    @Autowired
    public BusController(BusService busService) {
        this.busService = busService;
    }

    @GetMapping("/welcome")
    public String welcomeMessage(){
        return "Welcome dudes";
    }

    @GetMapping("/getByBusName/{busName}")
    public List<BusModel> getByBusName(@PathVariable String busName){
        return busService.getByBusName(busName);
    }

    @DeleteMapping("/getByBusNameQuery/{busName}")
    public void getByBusNameQuery(@PathVariable String busName){
        busService.getByBusNameQuery(busName);
    }
    
    @PostMapping("/addUser")
    public BusModel addUserInformation(@RequestBody BusModel busModel){
        return busService.addUserInformation(busModel);
    }
}
