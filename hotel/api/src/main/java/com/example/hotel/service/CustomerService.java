package com.example.hotel.service;

import com.example.hotel.entity.Customer;
import com.example.hotel.entity.Room;
import com.example.hotel.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Customer> getCustomers() {
        return repository.findAll();
    }

    public Customer getCustomerById(int id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteCustomer(int id) {
        repository.deleteById(id);
        return "customer removed !! " + id;
    }

    public Customer updateCustomer(Customer customer) {
        Customer existingCustomer = repository.findById(customer.getCustomerId()).orElse(null);
        existingCustomer.setFirstName(customer.getFirstName());
        existingCustomer.setLastName(customer.getLastName());
        return repository.save(existingCustomer);
    }

    public void addRoomToCustomer(Customer customer, Room room){

        customer.getRooms().add(room);
    }

    public Customer getCustomerBySocID(String idCard){

        List<Customer>allCustomers = getCustomers();

        for(Customer c: allCustomers){
            if(c.getIdCard().equals(idCard))
                return c;
        }

        return null;
    }

}
