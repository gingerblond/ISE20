package com.example.hotel.service;

import com.example.hotel.entity.Room;
import com.example.hotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomRepository repository;

    public Room addRoom(Room room) {
        return repository.save(room);
    }

    public List<Room> addRooms(List<Room> rooms){

        return repository.saveAll(rooms);
    }

    public List<Room> getRooms() {
        return  repository.findAll();
    }

}
