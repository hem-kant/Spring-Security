package com.hemkant.SpringSecurity.InMemAuth.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @GetMapping("/myaccount")
    public String getAccountDetails(){
    return "My Account Details";
    }
}
