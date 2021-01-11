package com.example.hotel.repository;

import com.example.hotel.entity.CleanEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CleanEmployeeRepository extends JpaRepository<CleanEmployee,Integer> {
}
