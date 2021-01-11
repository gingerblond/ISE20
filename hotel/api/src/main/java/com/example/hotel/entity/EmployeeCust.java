package com.example.hotel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Entity
    @Table(name= "employee_tbl")
    public class EmployeeCust {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int employeeId;
        private String firstName;
        private String lastName;
        private String socialId;
        private String department;


}
