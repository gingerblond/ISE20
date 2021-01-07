package com.example.hotel.service;

import com.example.hotel.entity.Hotel;
import com.example.hotel.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelService {

    @Autowired
    private HotelRepository repository;


    public Hotel addHotel(Hotel hotel){
      // return repository.save(hotelRoom.getHotel());
        return repository.save(hotel);
    }
}
