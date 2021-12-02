package com.hotelmvc.front.models.room;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RoomHandler {
    @Autowired
    RestTemplate rt;

    public List<Room> getAllRooms() {
        Room[] rooms = rt.getForObject("http://localhost:8081/room/find", Room[].class);
        List<Room> list = Arrays.asList(rooms);
        return list;
    }
}
