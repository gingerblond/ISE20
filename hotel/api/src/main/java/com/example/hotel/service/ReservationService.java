package com.example.hotel.service;

import com.example.hotel.entity.Customer;
import com.example.hotel.entity.Reservation;
import com.example.hotel.entity.Room;
import com.example.hotel.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository repository;
    @Autowired
    private RoomService roomService;
    @Autowired
    private CustomerService customerService;

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


    /**public String reserveRoom(String firstName, String lastName,String idCard, String roomType){

        Room toReserve = roomService.getRoomsByType(roomType).get(0);
        Customer customer = customerService.getCustomerBySocID(idCard);

        toReserve.setAvailable(false);

        if(customer !=null){
            customerService.addRoomToCustomer(customer,toReserve);
            return UUID.randomUUID().toString();//ogranici
        }
        customer = new Customer(firstName,lastName,idCard);
        customerService.addRoomToCustomer(customer,toReserve);
        return UUID.randomUUID().toString();//ogranici

    }**/
}
