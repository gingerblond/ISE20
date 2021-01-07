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
   /** public Reservation addReservation(@RequestBody Reservation reservation){
        return service.saveReservation(reservation);
    }**/
    public Customer addCustomer(@RequestBody ReservationRequest reservationRequest) {
        return customerRepository.save(reservationRequest.getCustomer());
    }

    /**
     * PUT/Edit Reservation
     */



}
