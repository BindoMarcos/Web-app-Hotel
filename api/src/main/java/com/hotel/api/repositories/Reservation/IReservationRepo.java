package com.hotel.api.repositories.Reservation;

import java.sql.Date;

import com.hotel.api.models.Reservation;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IReservationRepo extends CrudRepository<Reservation, Long> {

    @Query(value = "SELECT CASE WHEN COUNT(rooms) > 0 THEN 'false' ELSE 'true' END FROM reservations r WHERE (check_in <= :check_out AND check_out >= :check_in) AND rooms = :nRoom", nativeQuery = true)
    Boolean rangeDate(
            @Param("check_out") Date checkOut,
            @Param("check_in") Date checkIn,
            @Param("nRoom") int nRoom);
}
