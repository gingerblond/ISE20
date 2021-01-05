package com.example.hotel.controller;

import com.example.hotel.entity.Room;
import com.example.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@RestController
public class RoomController {

    @Autowired
    private RoomService service;

    /**
     * Add new room
     * @param room
     * @return
     */
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("addRoom")
    public Room addRoom(@RequestBody Room room){
        return service.addRoom(room);
    }

    /**
     * Add list of new rooms
     * @param rooms
     * @return
     */
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("addRooms")
    public List<Room> addRooms(@RequestBody List<Room> rooms){
        return service.addRooms(rooms);
    }

    /**
     * Get rooms List
     * @return
     */
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("getRooms")
    public int getRooms() {
        List<Room> rooms = service.getRooms();
        int occurancies = 0;
        for (Room room:rooms){
            if(room.getType().equals("SINGLE_ROOM")){
                occurancies++;
            }
        }
        /**List<Room> respondList = new ArrayList<Room>();
        respondList.**/
        return occurancies;
    }
}
