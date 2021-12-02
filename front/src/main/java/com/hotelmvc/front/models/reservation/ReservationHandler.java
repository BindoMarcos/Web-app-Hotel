package com.hotelmvc.front.models.reservation;

import java.util.Arrays;
import java.util.List;

import com.hotelmvc.front.models.room.Room;
import com.hotelmvc.front.models.room.RoomHandler;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@SuppressWarnings("unchecked")
@Component
public class ReservationHandler {
    @Autowired
    RestTemplate rt;

    @Autowired
    RoomHandler roomHandler;

    public List<Room> getRooms() {
        return roomHandler.getAllRooms();
    }

    public List<Reservation> getAllReservations() {
        Reservation[] reservations = rt.getForObject(
                "http://localhost:8081/customer/find",
                Reservation[].class);
        List<Reservation> list = Arrays.asList(reservations);
        return list;
    }

    public Reservation addReservation(Reservation reservation) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // headers.setBasicAuth(encodedCredentials);

        JSONObject requestbody = new JSONObject();

        JSONObject customer = new JSONObject();
        customer.put("dni", reservation.getCustomer());

        JSONObject room = new JSONObject();
        room.put("n_room", reservation.getRoom());

        requestbody.put("idReservation", reservation.getId_reservation());
        requestbody.put("customer", customer);
        requestbody.put("room", room);
        requestbody.put("check_in", reservation.getCheck_in());
        requestbody.put("check_out", reservation.getCheck_out());

        HttpEntity<String> request = new HttpEntity<String>(requestbody.toJSONString(), headers);
        System.out.println(request);

        return rt.exchange("http://localhost:8081/reservation/add", HttpMethod.POST, request, Reservation.class)
                .getBody();
    }
}
