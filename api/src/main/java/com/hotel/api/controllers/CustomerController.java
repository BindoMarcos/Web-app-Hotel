package com.hotel.api.controllers;

import java.util.Optional;

import com.hotel.api.models.Customer;
import com.hotel.api.services.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService cService;

    @PostMapping("/add")
    public Customer addCustomer(@RequestBody Customer customer) {
        return cService.save(customer);
    }

    @GetMapping("/find/{dni}")
    public Optional<Customer> findPerDni(@PathVariable int dni) {
        return cService.findPerDni(dni);
    }

    @GetMapping("/find")
    public Iterable<Customer> findAll() {
        return cService.findAll();
    }


}
