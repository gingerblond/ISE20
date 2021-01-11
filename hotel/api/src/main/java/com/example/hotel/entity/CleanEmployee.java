package com.example.hotel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Entity
    @Table(name= "clean_service_employee")

public class CleanEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String socialId;
    final private String department = "Clean_service";

}
