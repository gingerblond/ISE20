package com.example.hotel.controller;

import com.example.hotel.entity.Customer;
import com.example.hotel.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService service;

    /**
     * Save new customer
     */
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/addCustomer")
    public Customer addCustomer(@RequestBody Customer customer){
        return service.addCustomer(customer);
    }

    /**
     * List all customers
     */
    @GetMapping("/customers")
    public List<Customer> findAllCustomers() {
        return service.getCustomers();
    }

    /**
     * Search for customer by id
     */
    @GetMapping("/CustomerById/{id}")
    public Customer findCustomerById(@PathVariable int id) {
        return service.getCustomerById(id);
    }

    /**
    * Update customer details
     */
    @PutMapping("/updateCustomer")
    public Customer updateCustomer(@RequestBody Customer customer) {
        return service.updateCustomer(customer);
    }

    /**
     * Delete customer by id
     */
    @DeleteMapping("/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable int id) {
        return service.deleteCustomer(id);
    }
}
