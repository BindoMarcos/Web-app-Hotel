package com.hotelmvc.front.models;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    private Long id_reservation;
    private Customer customer;
    private Room room;
    private Date check_in;
    private Date check_out;
}

