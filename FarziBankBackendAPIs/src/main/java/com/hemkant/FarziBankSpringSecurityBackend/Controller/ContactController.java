package com.hemkant.FarziBankSpringSecurityBackend.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ContactController {

    @GetMapping("/contact")
    public  String getContact(){
        return "contact";
    }
}
