package com.google.calendar;

import java.io.IOException;

import com.google.calendar.services.CalendarService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CalendarApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(CalendarApplication.class, args);

		CalendarService calendarService;
		
		CalendarService.listEvents();

		/* calendarService.setStartDate(2021,12,05);
		calendarService.setStartDate(2021-06-12); */
	}

}
