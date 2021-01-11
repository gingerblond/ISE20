package com.example.hotel.controller;

import com.example.hotel.entity.CleanEmployee;
import com.example.hotel.service.CleanEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CleanEmployeeController {

    @Autowired
    private CleanEmployeeService service;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("addCleanServiceEmployee")
    public CleanEmployee addCleanEmployee(@RequestBody CleanEmployee cleanEmployee){
        return service.addCleanEmployee(cleanEmployee);
    }

    @GetMapping("allEmployeesOfCleanService")
    public List<CleanEmployee> getCleanEmployees() {
        return service.getCleanEmployees();
    }


    @GetMapping("cleanServiceEmployeeById/{id}")
    public CleanEmployee findCleanEmployeeById(@PathVariable int id) {
        return service.getCleanEmployeeById(id);
    }

    @PutMapping("updateCleanServiceEmployee")
    public CleanEmployee updateCustomer(@RequestBody CleanEmployee employeeCust) {
        return service.updateCleanEmployee(employeeCust);
    }

    @DeleteMapping("deleteCleanServiceEmployeeById/{id}")
    public String deleteCustomer(@PathVariable int id) {
        return service.deleteEmployeeOfCleaningService(id);
    }
}
