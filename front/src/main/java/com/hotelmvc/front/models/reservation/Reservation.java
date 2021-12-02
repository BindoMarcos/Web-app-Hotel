package com.hotelmvc.front.models.reservation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Reservation {
    private Long id_reservation;
    private int customer;
    private int room;
    private String check_in;
    private String check_out;
}
