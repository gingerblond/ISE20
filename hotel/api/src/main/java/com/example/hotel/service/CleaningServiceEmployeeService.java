package com.example.hotel.service;

import com.example.hotel.entity.CleaningServiceEmployee;
import com.example.hotel.repository.CleaningServiceEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CleaningServiceEmployeeService {

    @Autowired
    private CleaningServiceEmployeeRepository repository;

    /**
     * POST add new cleaning service employee
     * @param employee
     * @return
     */
    public CleaningServiceEmployee addCleaningServiceEmployee(CleaningServiceEmployee employee){
        return repository.save(employee);
    }

    /**
     * Get list with all cleaning service employees
     * @return
     */
    public List<CleaningServiceEmployee> getCleaningServiceEmployees() {
        return repository.findAll();
    }

    /**
     * Find cleaning service employee by Id
     * @param id
     * @return
     */
    public CleaningServiceEmployee getCleaningServiceEmployeeById(int id) {
        return repository.findById(id).orElse(null);
    }

    /**
     * Delete CleaningServiceEmployee
     * @param id
     * @return
     */
    public String deleteCleaningServiceEmployee(int id) {
        repository.deleteById(id);
        return "Cleaning Servise employee with ID :" + id + " successfully removed!";
    }
}
