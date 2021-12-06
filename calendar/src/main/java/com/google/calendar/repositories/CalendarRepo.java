package com.google.calendar.repositories;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventDateTime;
import com.google.api.services.calendar.model.Events;
import com.google.configurations.CalendarConfig;

import org.springframework.stereotype.Repository;

@Repository
public class CalendarRepo {
    private static Calendar service;
    private Event event = new Event();
    static {
        service = CalendarConfig.getCalendar();
    }

    public static void listEvents() throws IOException {
        DateTime now = new DateTime(System.currentTimeMillis());

        Events events = service.events().list("bindomarcos13@gmail.com")
                .setMaxResults(10)
                .setTimeMin(now)
                .setOrderBy("startTime")
                .setSingleEvents(true)
                .execute();
        List<Event> items = events.getItems();
        if (items.isEmpty()) {
            System.out.println("No upcoming events found.");
        } else {
            System.out.println("Upcoming events");
            for (Event event : items) {
                DateTime start = event.getStart().getDateTime();
                if (start == null) {
                    start = event.getStart().getDate();
                }
                System.out.printf("%s (%s)\n", event.getSummary(), start);
            }
        }
    }

    public Event setStartDate(Date check_in) {
        DateTime startDateTime = new DateTime(check_in);
        EventDateTime start = new EventDateTime().setDate(startDateTime);
        return event.setStart(start);
    }

    public Event setEndDate(Date check_out) {
        DateTime endDateTime = new DateTime(check_out);
        EventDateTime end = new EventDateTime().setDate(endDateTime);
        return event.setEnd(end);
    }

}
