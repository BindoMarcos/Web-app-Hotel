package com.hotel.api.controllers;

import java.util.Optional;

import com.hotel.api.models.Room;
import com.hotel.api.services.RoomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/room")
public class RoomController {
    @Autowired
    RoomService rService;

    @GetMapping("/find")
    public Iterable<Room> findAll() {
        return rService.findAll();
    }

    @GetMapping("/find/{nRoom}")
    public Optional<Room> findPerNumber(@PathVariable int nRoom) {
        return rService.findPerNumber(nRoom);
    }

    @GetMapping("/findAll/{busy}")
    public Iterable<Room> findPerBusy(@PathVariable boolean busy) {
        return rService.findPerBusy(busy);
    }

    @GetMapping("/isBusy/{nRoom}")
    public boolean busy(int nRoom){
        return rService.busy(nRoom);
    }

}
