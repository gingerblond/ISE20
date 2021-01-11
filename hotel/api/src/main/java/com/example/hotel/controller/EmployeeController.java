package com.example.hotel.controller;


import com.example.hotel.entity.Employee;
import com.example.hotel.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    /**
     * Save new customer
     */
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("addEmployee")
    public Employee addCustomer(@RequestBody Employee employee){
        return service.addEmployee(employee);
    }

    /**
     * List all customers
     */
    @GetMapping("allEmployees")
    public List<Employee> findAllCustomers() {
        return service.getEmployees();
    }

    /**
     * Search for customer by id
     */
    @GetMapping("employeeById/{id}")
    public Employee findCustomerById(@PathVariable int id) {
        return service.getEmployeeById(id);
    }

    /**
     * Update customer details
     */
    @PutMapping("updateEmployee")
    public Employee updateCustomer(@RequestBody Employee employee) {
        return service.updateEmployee(employee);
    }

    /**
     * Delete customer by id
     */
    @DeleteMapping("deleteEmployeeById/{id}")
    public String deleteCustomer(@PathVariable int id) {
        return service.deleteEmployee(id);
    }
}
