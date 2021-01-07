package com.example.hotel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "customer_tbl")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    private String firstName;
    private String lastName;
    private String idCard;

    @OneToMany(targetEntity = Room.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "cr_fk", referencedColumnName = "customerId")
    private List<Room> rooms;

    public Customer(String firstName, String lastName, String idCard){
        //ako je bilo koji null ili prazan baci exception
        this.firstName = firstName;
        this.lastName = lastName;
        this.idCard = idCard;
    }

}
