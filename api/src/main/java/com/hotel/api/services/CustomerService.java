package com.hotel.api.services;

import java.util.Optional;

import com.hotel.api.models.Customer;
import com.hotel.api.repositories.Customer.CustomerRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    CustomerRepo cRepo;

    public Customer save(Customer customer) {
        return cRepo.save(customer);
    }

    public Iterable<Customer> findAll() {
        return cRepo.findAll();
    }

    public Optional<Customer> findPerDni(int dni) {
        return cRepo.findPerDni(dni);
    }

    public boolean exist(int dni) {
        return cRepo.exist(dni);
    }
}
