package com.hotel.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "n_room")
    private int n_room;

    @Column(name = "q_beds", nullable = false)
    private int q_beds;

    @Column(name = "busy", nullable = false)
    private boolean busy = true;

    /* @ManyToOne()
    @JoinColumn(name = "id_reservation")
    private Reservation reservation;
 */
    protected Room() {
    }
}
