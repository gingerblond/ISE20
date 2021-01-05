package com.example.hotel.service;

import com.example.hotel.entity.Reservation;
import com.example.hotel.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository repository;

    /**
     * POST Save new reservation
     * @param reservation
     * @return
     */
    public Reservation saveReservation(Reservation reservation){
        return repository.save(reservation);
    }

    /**
     * DELETE a reservation by its id
     * @param id
     * @return
     */
    public String deleteReservation(int id){
        repository.deleteById(id);
        return "Reservation with id: " +id + " successfully deleted!";
    }

    /**
     * PUT/ Edit a reservation
     */
}
