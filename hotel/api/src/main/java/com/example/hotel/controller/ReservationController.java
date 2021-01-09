package com.example.hotel.controller;

import com.example.hotel.dto.ReservationRequest;
import com.example.hotel.entity.Customer;
import com.example.hotel.entity.Reservation;
import com.example.hotel.repository.CustomerRepository;
import com.example.hotel.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReservationController {
    @Autowired
    CustomerRepository customerRepository;

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

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping ("deleteReservation/{id}")
    public String deleteReservation(@PathVariable int id) {
         return service.deleteReservation(id);
    }


    /**
     * PUT/Edit Reservation
     */



}
