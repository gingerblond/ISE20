package com.example.hotel.service;

import com.example.hotel.entity.Customer;
import com.example.hotel.entity.Hotel;
import com.example.hotel.entity.Reservation;
import com.example.hotel.entity.Room;
import com.example.hotel.model.CustomerMo;
import com.example.hotel.model.HotelMo;
import com.example.hotel.model.ReservationMo;
import com.example.hotel.model.RoomMo;
import com.example.hotel.repositoryMo.CustomerMoRepository;
import com.example.hotel.repositoryMo.HotelMoRepository;
import com.example.hotel.repositoryMo.ReservationMoRepository;
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
    private ReservationMoRepository reservationMoRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;
    @Autowired
    private HotelService hotelService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ReservationService reservationService;


    /**
     * Start migration script
     * @throws Exception
     */
    public void startMigration() throws Exception{
        addHotelsToMongo();
        addCustomersToMongo();
        addReservationsToMongo();
    }

    /**
     * Migrate hotels in MongoDB
     */
    private void addHotelsToMongo(){
        List<Hotel> hotels = hotelService.getHotels();
        List<HotelMo> hotelsMo = new ArrayList<>();
        for (Hotel hotel: hotels) {
            List<Room> rooms = hotel.getRooms();
            List<RoomMo> roomsMo = new ArrayList<>();
            for (Room room: rooms) {
                roomsMo.add(new RoomMo(room.getRoomID(),room.isAvailable(),room.getType()));
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
    private void addCustomersToMongo(){
       List<Customer> customers = customerService.getCustomers();
       List<CustomerMo> customersMo = new ArrayList<>();
        for (Customer customer: customers) {
            customersMo.add(new CustomerMo(sequenceGeneratorService.getSequenceNumber(CustomerMo.SEQUENCE_NAME),customer.getFirstName(),customer.getLastName(),customer.getIdCard()));
        }
       for (CustomerMo customerMo: customersMo) {
           customerMoRepository.save(customerMo);
       }
    }

    private  void addReservationsToMongo(){
        List<Reservation> reservations = reservationService.getReservations();
        List<ReservationMo> reservationsMo = new ArrayList<>();
        for (Reservation reservation: reservations) {
            RoomMo roomMo= getRoomMoById(reservation.getRoom().getRoomID());
            reservationsMo.add(new ReservationMo(sequenceGeneratorService.getSequenceNumber(ReservationMo.SEQUENCE_NAME),reservation.getPrice(),
                    reservation.getDate(),reservation.getDuration(),customerMoRepository.findAll().get(0),roomMo));
        }
        for (ReservationMo reservationMo: reservationsMo) {
            reservationMoRepository.save(reservationMo);
        }
    }

    private RoomMo getRoomMoById(int id){
        List<RoomMo> roomsMo = hotelMoRepository.findAll().get(0).getRoomsMo();
        return roomsMo.get(id);
    }
}
