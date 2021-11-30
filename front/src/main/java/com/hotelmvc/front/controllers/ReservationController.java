package com.hotelmvc.front.controllers;

import java.util.ArrayList;

import com.hotelmvc.front.models.Reservation;
import com.hotelmvc.front.models.Room;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
    
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    RestTemplate rt = new RestTemplate();

    @GetMapping("/")
    public String roomPage(Model model){
        ArrayList<Room> list = rt.getForObject("http://localhost:8080/room/find", ArrayList.class);
        model.addAttribute("Rooms", list);
        model.addAttribute("Room", new Room());
        System.out.println("++++++++++++++++++++++++");
        return "Reservation";
    }

    @PostMapping("/add")
    public String addReservation(@ModelAttribute Reservation reservation){
        rt.postForObject("http://localhost:8080/reservation/add", reservation, Reservation.class);
        return "succesful";
    } 



    public int getNroom(){
        ResponseEntity<int> exchange = rt.exchange("", responseType)
    } 
}
