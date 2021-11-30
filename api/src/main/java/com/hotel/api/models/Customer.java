package com.hotel.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @Column(name = "dni", nullable = false, length = 20, updatable = false)
    private int dni;

    @Column(name = "username", nullable = false, length = 30)
    private String username;

    @Column(name = "pass", nullable = false, length = 20)
    private String pass;

    /* @OneToMany(mappedBy = "customers", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> reservations;
  */
    protected Customer() {
    }
}