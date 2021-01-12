package com.example.hotel.repository;

import com.example.hotel.entity.CleaningServiceEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CleaningServiceEmployeeRepository extends JpaRepository<CleaningServiceEmployee, Integer> {
}
