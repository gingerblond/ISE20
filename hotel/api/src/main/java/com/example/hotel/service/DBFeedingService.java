package com.example.hotel.service;

import com.example.hotel.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DBFeedingService {
    @Autowired
    private RoomService service;

    private List<Room> roomsDB = new ArrayList<>();

    Room room1 = new Room(1,true, "SINGLE_ROOM");
    Room room2 = new Room(2,true, "DOUBLE_ROOM");
    Room room3 = new Room(3,true, "APARTMENT");
    Room room4 = new Room(4,true, "SINGLE_ROOM");
    Room room5 = new Room(5,true, "HONEYMOON_SWEET");
    Room room6 = new Room(6,true, "DOUBLE_ROOM");



    public void startFeedingDB(){
        addRoomsToDB();
    }

    public void addRoomsToDB() {
        roomsDB.add(room1);
        roomsDB.add(room2);
        roomsDB.add(room3);
        roomsDB.add(room4);
        roomsDB.add(room5);
        service.addRooms(roomsDB);
    }
}
