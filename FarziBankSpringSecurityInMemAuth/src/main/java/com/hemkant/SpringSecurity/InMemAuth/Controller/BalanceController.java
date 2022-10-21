package com.hemkant.SpringSecurity.InMemAuth.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {
    @GetMapping("/myAccountBalance")
    public String getBalanceDetails(){
        return "Balance";
    }
}
