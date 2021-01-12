package com.example.hotel.controller;

import com.example.hotel.entity.Reservation;
import com.example.hotel.service.DBFeedingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DBFeedingController {
    @Autowired
    DBFeedingService service;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("dbFeeding")
    public void dbFeeding(){
       //  service.startFeedingDB();
    }
}
