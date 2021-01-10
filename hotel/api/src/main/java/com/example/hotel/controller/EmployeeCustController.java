package com.example.hotel.controller;


import com.example.hotel.entity.EmployeeCust;
import com.example.hotel.service.EmployeeCustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeCustController {

    @Autowired
    private EmployeeCustService service;

    /**
     * Save new customer
     */
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("addEmployeeOfCustomerService")
    public EmployeeCust addCustomer(@RequestBody EmployeeCust employeeCust){
        return service.addEmployee(employeeCust);
    }

    /**
     * List all customers
     */
    @GetMapping("employeesOfCustomerService")
    public List<EmployeeCust> findAllCustomers() {
        return service.getEmployees();
    }

    /**
     * Search for customer by id
     */
    @GetMapping("employeeOfCustomerServiceById/{id}")
    public EmployeeCust findCustomerById(@PathVariable int id) {
        return service.getEmployeeById(id);
    }

    /**
     * Update customer details
     */
    @PutMapping("updateEmployeeOfCustomerService")
    public EmployeeCust updateCustomer(@RequestBody EmployeeCust employeeCust) {
        return service.updateEmployee(employeeCust);
    }

    /**
     * Delete customer by id
     */
    @DeleteMapping("deleteEmployeeOfCustomerService/{id}")
    public String deleteCustomer(@PathVariable int id) {
        return service.deleteEmployee(id);
    }
}
