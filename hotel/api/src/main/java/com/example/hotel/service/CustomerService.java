package com.example.hotel.service;

import com.example.hotel.entity.Customer;
import com.example.hotel.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repository;

    /**
     * POST add new customer
     * @param customer
     * @return
     */
    public Customer addCustomer(Customer customer){
        return repository.save(customer);
    }

}
