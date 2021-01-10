package com.example.hotel.controller;


import com.example.hotel.entity.EmployeeOfCustService;
import com.example.hotel.service.EmployeeOfCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeOfCustomerServiceController {

    @Autowired
    private EmployeeOfCustomerService service;

    /**
     * Save new customer
     */
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("addEmployee")
    public EmployeeOfCustService addCustomer(@RequestBody EmployeeOfCustService employee){
        return service.addEmployee(employee);
    }

    /**
     * List all customers
     */
    @GetMapping("employees")
    public List<EmployeeOfCustService> findAllCustomers() {
        return service.getEmployees();
    }

    /**
     * Search for customer by id
     */
    @GetMapping("employeeOfCustomerServiceById/{id}")
    public EmployeeOfCustService findCustomerById(@PathVariable int id) {
        return service.getEmployeeById(id);
    }

    /**
     * Update customer details
     */
    @PutMapping("updateEmployeeOfCustomerService")
    public EmployeeOfCustService updateCustomer(@RequestBody EmployeeOfCustService employee) {
        return service.updateEmployee(employee);
    }

    /**
     * Delete customer by id
     */
    @DeleteMapping("deleteEmployeeOfCustomerService/{id}")
    public String deleteCustomer(@PathVariable int id) {
        return service.deleteEmployee(id);
    }
}
