package com.hotel.api.repositories.Reservation;

import java.sql.Date;

import com.hotel.api.models.Reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationRepo {

    @Autowired
    IReservationRepo iReservationRepo;

    public Reservation save(Reservation reservation) {
        return iReservationRepo.save(reservation);
    }

    public Iterable<Reservation> findAll() {
        return iReservationRepo.findAll();
    }

    public void deleteAll() {
        iReservationRepo.deleteAll();
    }

    public Boolean rangeDate(Date checkOut, Date checkIn, int nRoom) {
        return iReservationRepo.rangeDate(checkOut, checkIn, nRoom);
    }

    public void deleteOne(Long idReservation) {
        iReservationRepo.deleteById(idReservation);
    }

    public boolean exist(Long idRes) {
        return iReservationRepo.existsById(idRes);
    }

}
