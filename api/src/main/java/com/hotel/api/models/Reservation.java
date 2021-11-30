package com.hotel.api.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reservation", nullable = false, length = 30)
    private Long id_reservation;

    @ManyToOne()
    @JoinColumn(name = "customers", referencedColumnName = "dni", nullable = false)
    private Customer customer;

    @ManyToOne()
    @JoinColumn(name = "rooms", referencedColumnName = "n_room", nullable = false)
    //@OneToMany(mappedBy = "reservations",cascade = CascadeType.ALL, orphanRemoval = false)
    private Room room;

    @Column(name = "check_in", nullable = false)
    private Date check_in;

    @Column(name = "check_out", nullable = false)
    private Date check_out;

    protected Reservation() {
    }

    public void setCheck_in(String check_in){
        System.out.println(check_in);
        Date date = Date.valueOf(check_in);
        this.check_in = date;
    }

    public void setCheck_out(String check_out){
        Date date = Date.valueOf(check_out);
        this.check_out = date;
    }
}
