package com.hotel.api.services;

import java.util.Optional;

import com.hotel.api.models.Room;
import com.hotel.api.repositories.Room.RoomRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {
    @Autowired
    RoomRepo rRepo;

    public Iterable<Room> findAll() {
        return rRepo.findAll();
    }

    public Optional<Room> findPerNumber(int nRoom) {
        return rRepo.findPerNumber(nRoom);
    }

    public Iterable<Room> findPerBusy(boolean busy) {
        return rRepo.findPerBusy(busy);
    }

    public boolean exist(int nRoom){
        return rRepo.exist(nRoom);
    }

    public boolean busy(int nRoom){
        return rRepo.isBusy(nRoom);
    }
    

}
