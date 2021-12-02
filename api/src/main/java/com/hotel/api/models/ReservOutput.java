package com.hotel.api.models;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ReservOutput {
    private Long id_reservation;
    private int customer;
    private int room;
    private Date check_in;
    private Date check_out;
}
