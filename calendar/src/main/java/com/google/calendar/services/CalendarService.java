package com.google.calendar.services;

import java.io.IOException;
import java.sql.Date;

import com.google.api.services.calendar.model.Event;
import com.google.calendar.repositories.CalendarRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalendarService {
    @Autowired
    CalendarRepo cRepo;

    public Event setStartDate(Date check_in) {
        return cRepo.setStartDate(check_in);
    }

    public Event setEndDate(Date check_out) {
        return cRepo.setEndDate(check_out);
    }

    public static void listEvents() throws IOException {
        CalendarRepo.listEvents();
    }

}
