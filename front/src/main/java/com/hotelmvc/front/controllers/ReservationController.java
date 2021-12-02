package com.hotelmvc.front.controllers;

import java.util.List;

import com.hotelmvc.front.models.reservation.Reservation;
import com.hotelmvc.front.models.reservation.ReservationHandler;
import com.hotelmvc.front.models.room.Room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    ReservationHandler rHandler;

    @GetMapping("/")
    public String roomPage(Model model) {
        List<Reservation> ReservList = rHandler.getAllReservations();
        model.addAttribute("Reservations", ReservList);
        model.addAttribute("Reservation", new Reservation());

        List<Room> RoomList = rHandler.getRooms();
        model.addAttribute("Rooms", RoomList);
        model.addAttribute("Room", new Room());
        return "Reservation";
    }

    @PostMapping("/add")
    public String addReservation(Model model, @ModelAttribute Reservation reservation) {
        rHandler.addReservation(reservation);
        model.addAttribute("message", "Reservation created successfully");
        return "succesful";
    }

}
