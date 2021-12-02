package com.hotelmvc.front.controllers;

import java.util.List;

import com.hotelmvc.front.models.customer.Customer;
import com.hotelmvc.front.models.customer.CustomerHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerHandler cHandler;

    @GetMapping("/")
    public String clientPage(Model model) {
        List<Customer> list = cHandler.getAllCustomers();
        model.addAttribute("Customers", list);
        model.addAttribute("Customer", new Customer());
        return "Customer";
    }

    @PostMapping("/add")
    public String addCustomer(Model model, @ModelAttribute Customer customer) {
        cHandler.addCustomer(customer);
        model.addAttribute("message", "User created successfully");
        return "succesful";
    }

}
