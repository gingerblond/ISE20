package com.example.hotel.service;

import com.example.hotel.entity.EmployeeCust;
import com.example.hotel.repository.EmployeeCustRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeCustService {

    @Autowired
    private EmployeeCustRepository repository;

    public EmployeeCust addEmployee(EmployeeCust employeeCust){
        return repository.save(employeeCust);
    }

    public List<EmployeeCust> getEmployees() {
        return repository.findAll();
    }

    public EmployeeCust getEmployeeById(int id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteEmployee(int id) {
        repository.deleteById(id);
        return "Employee from customer service has been removed. With id:" + id;
    }

    public EmployeeCust updateEmployee(EmployeeCust employeeCust) {
        EmployeeCust existingEmployeeCust = repository.findById(employeeCust.getEmployeeId()).orElse(null);
        existingEmployeeCust.setFirstName(employeeCust.getFirstName());
        existingEmployeeCust.setLastName(employeeCust.getLastName());
        return repository.save(existingEmployeeCust);
    }

}
