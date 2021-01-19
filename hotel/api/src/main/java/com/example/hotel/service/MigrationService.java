package com.example.hotel.service;

import com.example.hotel.entity.Customer;
import com.example.hotel.entity.Hotel;
import com.example.hotel.entity.Room;
import com.example.hotel.model.CustomerMo;
import com.example.hotel.model.HotelMo;
import com.example.hotel.model.RoomMo;
import com.example.hotel.repositoryMo.CustomerMoRepository;
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
    private CustomerMoRepository customerMoRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;
    @Autowired
    private HotelService hotelService;
    @Autowired
    private CustomerService customerService;


    /**
     * Start migration script
     * @throws Exception
     */
    public void startMigration() throws Exception{
        addHotelsToMongo();
        addCustomersToMongo();
    }

    /**
     * Migrate hotels in MongoDB
     */
    public void addHotelsToMongo(){
        List<Hotel> hotels = hotelService.getHotels();
        List<HotelMo> hotelsMo = new ArrayList<>();
        for (Hotel hotel: hotels) {
            List<Room> rooms = hotel.getRooms();
            List<RoomMo> roomsMo = new ArrayList<>();
            for (Room room: rooms) {
                roomsMo.add(new RoomMo(room.isAvailable(),room.getType()));
            }
            hotelsMo.add(new HotelMo(sequenceGeneratorService.getSequenceNumber(HotelMo.SEQUENCE_NAME),hotel.getAddress(),roomsMo));
        }
        for (HotelMo hotelMo: hotelsMo) {
            hotelMoRepository.save(hotelMo);
        }
    }

    /**
     * Migrate customers in MongoDB
     */
   public void addCustomersToMongo(){
       List<Customer> customers = customerService.getCustomers();
       List<CustomerMo> customersMo = new ArrayList<>();
        for (Customer customer: customers) {
            customersMo.add(new CustomerMo(sequenceGeneratorService.getSequenceNumber(CustomerMo.SEQUENCE_NAME),customer.getFirstName(),customer.getLastName(),customer.getIdCard()));
        }
       for (CustomerMo customerMo: customersMo) {
           customerMoRepository.save(customerMo);
       }
    }
}
