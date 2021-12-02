package com.hotel.api.services;

import com.hotel.api.models.ReservOutput;
import com.hotel.api.models.Reservation;
import com.hotel.api.repositories.Reservation.ReservationRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    @Autowired
    ReservationRepo rRepo;

    @Autowired
    RoomService roomService;

    @Autowired
    CustomerService customerService;

    public ReservOutput save(Reservation reservation) {
        int dni = reservation.getCustomer().getDni();
        int nRoom = reservation.getRoom().getN_room();
        if (customerService.exist(dni)) {
            System.out.println(dni);
            if (roomService.exist(nRoom)) {
                System.out.println(nRoom);
                if (rRepo.rangeDate(reservation.getCheck_out(), reservation.getCheck_in(), nRoom)) {
                    Reservation r = rRepo.save(reservation);
                    return new ReservOutput(r.getId_reservation(), r.getCustomer().getDni(), r.getRoom().getN_room(), r.getCheck_in(), r.getCheck_out());
                } else {
                    System.out.println("no entro la reserva");
                }
            } else {
                System.out.println("no entro al cuarto");
            }

        } else {
            System.out.println("no entro al usuario");
        }
        return null;
    }

    public Iterable<Reservation> findAll() {
        return rRepo.findAll();
    }

    public void deleteAll() {
        rRepo.deleteAll();
    }

    public void delOne(Long idReservation, int dni) {
        if (rRepo.exist(idReservation)) {
            if (customerService.exist(dni)) {
                rRepo.deleteOne(idReservation);
                System.out.println("Reserva borrada correctamente");
            } else {
                System.out.println("El dni ingresado no existe");
            }
        } else {
            System.out.println("El numero de reserva no existe");
        }
    }

}
