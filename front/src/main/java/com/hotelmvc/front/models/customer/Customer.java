package com.hotelmvc.front.models.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Customer {
    private int dni;
    private String username;
    private String pass;

}
