package com.hotel.api.controllers;

import com.hotel.api.models.Reservation;
import com.hotel.api.services.ReservationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired
    ReservationService rService;

    @PostMapping("/add")
    public Reservation addReservation(@RequestBody Reservation reservation) {
        return rService.save(reservation);
    }

    @GetMapping("/find")
    public Iterable<Reservation> findAll() {
        return rService.findAll();
    }

    @DeleteMapping("/delete")
    public void deleteAll() {
        rService.deleteAll();
    }

    @DeleteMapping("/deleteone")
    public void delOne(@RequestParam Long idReservation, @RequestParam int dni) {
        System.out.println("+++++++++++++++++++++");
        System.out.println(idReservation + " " + dni);
        rService.delOne(idReservation, dni);
    }
}
