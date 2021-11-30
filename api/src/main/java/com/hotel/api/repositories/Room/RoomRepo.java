package com.hotel.api.repositories.Room;

import java.util.Optional;

import com.hotel.api.models.Room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoomRepo {

    @Autowired
    IRoomRepo iRoomRepo;

    public Optional<Room> findPerNumber(int nRoom) {
        return iRoomRepo.findById(nRoom);
    }

    public Iterable<Room> findPerBusy(boolean busy) {
        return iRoomRepo.findByBusy(busy);
    }

    public Iterable<Room> findAll() {
        return iRoomRepo.findAll();
    }

    public boolean exist(int nRoom){
        return iRoomRepo.existsById(nRoom);
    }

    public boolean isBusy(int nRoom){
        return iRoomRepo.isBusy(nRoom);
    }

}
