package com.hemkant.SpringSecurity.InMemAuth.Controller;

import com.hemkant.SpringSecurity.InMemAuth.Model.Customer;
import com.hemkant.SpringSecurity.InMemAuth.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    CustomerRepository customerRepository;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer){
        Customer saveCustomer=null;
        ResponseEntity response =null;
        try {
            saveCustomer=customerRepository.save(customer);
            if (saveCustomer.getId()>0) {
                response=ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body("Given User is created !!");
            }
        }catch (Exception ex){
                response=ResponseEntity
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Error while saving new customer!!");
        }
        return response;
    }
}
