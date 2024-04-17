package com.example.busbooking.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BusModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int busId;
    private String busName;
    private String busDestination;
    public int getBusId() {
        return busId;
    }
    public void setBusId(int busId) {
        this.busId = busId;
    }
    public String getBusName() {
        return busName;
    }
    public void setBusName(String busName) {
        this.busName = busName;
    }
    public String getBusDestination() {
        return busDestination;
    }
    public void setBusDestination(String busDestination) {
        this.busDestination = busDestination;
    }

    




}
