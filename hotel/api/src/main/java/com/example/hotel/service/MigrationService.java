package com.example.hotel.service;

import com.example.hotel.entity.Hotel;
import com.example.hotel.entity.Room;
import com.example.hotel.model.HotelMo;
import com.example.hotel.model.RoomMo;
import com.example.hotel.repositoryMo.HotelMoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MigrationService {
    @Autowired
    private HotelMoRepository hotelMoRepository;

    @Autowired
    private HotelService hotelService;

    public void startMigration() throws Exception{
        addHotelsMongo();
    }
    public void addHotelsMongo(){
        List<Hotel> hotels = hotelService.getHotels();
        List<HotelMo> hotelsMo = new ArrayList<>();
        for (Hotel hotel: hotels) {
            List<Room> rooms = hotel.getRooms();
            List<RoomMo> roomsMo = new ArrayList<>();
            for (Room room: rooms) {
                roomsMo.add(new RoomMo(room.getRoomID(), room.isAvailable(),room.getType()));
            }
            hotelsMo.add(new HotelMo(hotel.getHotelId(),hotel.getAddress(),roomsMo));
        }
        for (HotelMo hotelMo: hotelsMo) {
            hotelMoRepository.save(hotelMo);
        }
    }

}
