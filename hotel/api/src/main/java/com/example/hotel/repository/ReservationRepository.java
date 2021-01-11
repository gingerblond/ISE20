package com.example.hotel.repository;

import com.example.hotel.dto.ReservationReport;
import com.example.hotel.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    @Query("SELECT new com.example.hotel.dto.ReservationReport(t.firstName as NAME, t.lastName, t.idCard, c.reservationID, c.date, c.duration , p.roomID, p.type) FROM Reservation c JOIN c.room p " +
            "JOIN c.customer t")
    public List<ReservationReport> getReportReservation();
}
