package com.hotel.api.repositories.Customer;

import com.hotel.api.models.Customer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepo extends CrudRepository<Customer, Integer> {

}
