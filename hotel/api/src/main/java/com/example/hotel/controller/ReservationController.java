package com.example.hotel.controller;

import com.example.hotel.entity.Reservation;
import com.example.hotel.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReservationController {

    @Autowired
    private ReservationService service;

    /**
     * POST Save a new reservation
     */
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("addReservation")
    public Reservation addReservation(@RequestBody Reservation reservation){
        return service.saveReservation(reservation);
    }

    /**
     * PUT/Edit Reservation
     */



}
