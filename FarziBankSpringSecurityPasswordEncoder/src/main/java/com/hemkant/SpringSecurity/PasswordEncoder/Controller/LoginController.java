package com.hemkant.SpringSecurity.PasswordEncoder.Controller;

import com.hemkant.SpringSecurity.PasswordEncoder.Model.Customer;
import com.hemkant.SpringSecurity.PasswordEncoder.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer){
        Customer saveCustomer=null;
        ResponseEntity response =null;
        try {
            String hashPassword=passwordEncoder.encode(customer.getPwd());
            customer.setPwd(hashPassword);
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
