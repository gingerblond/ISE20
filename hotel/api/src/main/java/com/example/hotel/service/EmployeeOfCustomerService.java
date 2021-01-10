package com.example.hotel.service;

import com.example.hotel.entity.EmployeeOfCustService;
import com.example.hotel.repository.EmployeeOfCustomerServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeOfCustomerService {

    @Autowired
    private EmployeeOfCustomerServiceRepository repository;

    public EmployeeOfCustService addEmployee(EmployeeOfCustService employee){
        return repository.save(employee);
    }

    public List<EmployeeOfCustService> getEmployees() {
        return repository.findAll();
    }

    public EmployeeOfCustService getEmployeeById(int id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteEmployee(int id) {
        repository.deleteById(id);
        return "customer removed !! " + id;
    }

    public EmployeeOfCustService updateEmployee(EmployeeOfCustService employee) {
        EmployeeOfCustService existingEmployee = repository.findById(employee.getEmployeeId()).orElse(null);
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        return repository.save(existingEmployee);
    }

}
