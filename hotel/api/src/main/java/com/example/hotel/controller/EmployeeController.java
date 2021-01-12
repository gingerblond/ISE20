package com.example.hotel.controller;


import com.example.hotel.entity.CleaningServiceEmployee;
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

    /*******************************************************************************
     *************** APIS for Customer Service Employees below:*********************
     ******************************************************************************/

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

    /**
     * Get customer Service Employees
     * @return
     */
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("getCustomerEmployees")
    public List<CustomerServiceEmployee> findAllCustomerServiceEmployees() {
        return customerServiceEmployeeService.getCustomerServiceEmployees();
    }

    /**
     * Get customer servise employee by ID
     * @param id
     * @return
     */
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("getCustomerEmployees/{id}")
    public Employee findgetCustomerEmployeesById(@PathVariable int id) {
        return customerServiceEmployeeService.getCustomerServiceEmployeeById(id);
    }

    /**
     * Delete customer servise employee by ID
     * @param id
     * @return
     */
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("deleteCustomerEmployee/{id}")
    public String deleteCustomerEmployee(@PathVariable int id) {
        return customerServiceEmployeeService.deleteCustomerServiceEmployee(id);
    }

    /*******************************************************************************
     *************** APIS for Cleaning Service Employees below:*********************
     *******************************************************************************/

    /**
     * Add Cleaning Service Employee
     * @param employee
     * @return
     */
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("addCleaningEmployee")
    public CleaningServiceEmployee addCustomerEmployee(@RequestBody CleaningServiceEmployee employee){
        return cleaningEmployeeService.addCleaningServiceEmployee(employee);
    }

    /**
     * Get cleaning Service Employees
     * @return
     */
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("getCleaningEmployees")
    public List<CleaningServiceEmployee> findAllCleaningServiceEmployees() {
        return cleaningEmployeeService.getCleaningServiceEmployees();
    }

    /**
     * Delete cleaning servise employee by ID
     * @param id
     * @return
     */
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("deleteCleaningEmployee/{id}")
    public String deleteCleaningEmployee(@PathVariable int id) {
        return cleaningEmployeeService.deleteCleaningServiceEmployee(id);
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
