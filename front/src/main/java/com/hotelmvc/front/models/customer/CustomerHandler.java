package com.hotelmvc.front.models.customer;

import java.util.Arrays;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@SuppressWarnings("unchecked")
@Component
public class CustomerHandler {

    @Autowired
    RestTemplate rt;

    public List<Customer> getAllCustomers() {
        Customer[] customers = rt.getForObject("http://localhost:8081/customer/find",
                Customer[].class);
        List<Customer> list = Arrays.asList(customers);
        return list;
    }

    public ResponseEntity<Customer> addCustomer(Customer customer) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // headers.setBasicAuth(encodedCredentials);

        JSONObject requestbody = new JSONObject();
        requestbody.put("dni", customer.getDni());
        requestbody.put("username", customer.getUsername());
        requestbody.put("pass", customer.getPass());

        HttpEntity<String> request = new HttpEntity<String>(requestbody.toJSONString(), headers);
        return rt.exchange("http://localhost:8081/customer/add", HttpMethod.POST, request, Customer.class);
    }

}
