package com.hotel.api.repositories.Customer;

import java.util.Optional;

import com.hotel.api.models.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepo {

    @Autowired
    ICustomerRepo iCustomerRepo;

    public Customer save(Customer customer) {
        return iCustomerRepo.save(customer);
    }

    public Iterable<Customer> findAll() {
        return iCustomerRepo.findAll();
    }

    public Optional<Customer> findPerDni(int dni) {
        return iCustomerRepo.findById(dni);
    }

    public boolean exist(int dni){
        return iCustomerRepo.existsById(dni);
    }

}
