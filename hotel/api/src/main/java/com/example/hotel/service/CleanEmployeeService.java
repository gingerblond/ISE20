package com.example.hotel.service;

import com.example.hotel.entity.CleanEmployee;
import com.example.hotel.repository.CleanEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CleanEmployeeService {

    @Autowired
    private CleanEmployeeRepository repository;


    public CleanEmployee addCleanEmployee(CleanEmployee cleanEmployee){
        return repository.save(cleanEmployee);
    }

    public List<CleanEmployee> getCleanEmployees() {
        return repository.findAll();
    }

    public CleanEmployee getCleanEmployeeById(int id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteEmployeeOfCleaningService(int id) {
        repository.deleteById(id);
        return "Employee from cleaning service has been removed. With id: " + id;
    }

    public CleanEmployee updateCleanEmployee(CleanEmployee cleanEmployee) {
        CleanEmployee exitingCleanEmployee = repository.findById(cleanEmployee.getId()).orElse(null);
        exitingCleanEmployee.setFirstName(cleanEmployee.getFirstName());
        exitingCleanEmployee.setLastName(cleanEmployee.getLastName());
        return repository.save(exitingCleanEmployee);
    }


}
