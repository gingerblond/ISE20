package com.example.hotel.service;

import com.example.hotel.entity.Employee;
import com.example.hotel.entity.Hotel;
import com.example.hotel.entity.Room;
import com.example.hotel.entity.User;
import com.example.hotel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DBFeedingService {
    @Autowired
    private RoomService roomService;
    @Autowired
    private HotelService hotelService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private UserRepository userRepository;

    private List<Room> roomsDB = new ArrayList<>();

    Room room1 = new Room(1,true, "SINGLE_ROOM");
    Room room2 = new Room(2,true, "DOUBLE_ROOM");
    Room room3 = new Room(3,true, "APARTMENT");
    Room room4 = new Room(4,true, "SINGLE_ROOM");
    Room room5 = new Room(5,true, "HONEYMOON_SWEET");
    Room room6 = new Room(6,true, "DOUBLE_ROOM");

    private List<Employee> employeeDB = new ArrayList<>();

    Employee employee1 = new Employee(1, "Sladjana", "Bujadnjak", "12B34", "CUSTOMER_SERVICE", "hi5qgmail.com", "", "full_time", "");
    Employee employee2 = new Employee(2, "ELI", "ELI", "12B34", "CUSTOMER_SERVICE", "hi5qgmail.com", "", "full_time", "");
    Employee employee3 = new Employee(3, "Nesha", "Pesha", "12B34", "CLEAN_SERVICE", "", "011/222", "part_time", "bathrooms");

    Hotel hotel = new Hotel(1,"Wien,Opernring 1",roomsDB, employeeDB);

    /**
     * Login admin user
     */
    User user = new User("admin", "pass");

    public void startFeedingDB(){
        addRooms();
        addHotelToDB(hotel);
        addEmployeeToDB();
        addUser(user);
    }

    public void addRooms() {
        roomsDB.add(room1);
        roomsDB.add(room2);
        roomsDB.add(room3);
        roomsDB.add(room4);
        roomsDB.add(room5);
        roomsDB.add(room6);
    }

    public void addHotelToDB(Hotel hotel){
        hotelService.addHotel(hotel);
    }

    public void addEmployeeToDB () {
        employeeDB.add(employee1);
        employeeDB.add(employee2);
        employeeDB.add(employee3);
    }

    public void addUser(User user){
        userRepository.save(user);
    }
}
