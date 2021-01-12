package com.example.hotel.controller;


import com.example.hotel.entity.CustomerServiceEmployee;
import com.example.hotel.entity.Employee;
import com.example.hotel.service.CleaningServiceEmployeeService;
import com.example.hotel.service.CustomerServiceEmployeeService;
import com.example.hotel.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private CleaningServiceEmployeeService cleaningEmployeeService;

    @Autowired
    private CustomerServiceEmployeeService customerServiceEmployeeService;

    /**
     * Add Customer Service Employee
     * @param employee
     * @return
     */
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("addCustomerEmployee")
    public CustomerServiceEmployee addCustomerEmployee(@RequestBody CustomerServiceEmployee employee){
        return customerServiceEmployeeService.addCustomerServiceEmployee(employee);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("getCustomerEmployees")
    public List<CustomerServiceEmployee> findAllCustomers() {
        return customerServiceEmployeeService.getCustomerServiceEmployees();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("getCustomerEmployees/{id}")
    public Employee findgetCustomerEmployeesById(@PathVariable int id) {
        return customerServiceEmployeeService.getCustomerServiceEmployeeById(id);
    }

    /**
    @PutMapping("updateEmployee")
    public Employee updateCustomer(@RequestBody Employee employee) {
        return service.updateEmployee(employee);
    }


    @DeleteMapping("deleteEmployeeById/{id}")
    public String deleteCustomer(@PathVariable int id) {
        return service.deleteEmployee(id);
    }**/
}
