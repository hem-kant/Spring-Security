package com.hemkant.SpringSecurity.InMemAuth.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoansController {

    @GetMapping("/myLoansDetails")
    public String getLoansDetails(){
    return "My Loans";
    }
}
