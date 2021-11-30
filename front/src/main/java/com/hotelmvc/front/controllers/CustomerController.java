package com.hotelmvc.front.controllers;

import java.util.ArrayList;

import com.hotelmvc.front.models.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;


@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    RestTemplate rt = new RestTemplate();
    
    @GetMapping("/")
    public String clientPage(Model model){
        ArrayList<Customer> list = rt.getForObject("http://localhost:8080/customer/find", ArrayList.class);
        model.addAttribute("Customers", list);
        model.addAttribute("Customer", new Customer());
        return "Customer";
    }

    @PostMapping("/add")
    public String addCustomer(@ModelAttribute Customer customer){
        rt.postForObject("http://localhost:8080/customer/add",customer, Customer.class);
        return "succesful";
    }

   
}

