package com.nPants.nPants.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("Login")
public class LoginController {


    @GetMapping 
    public String getMethodName() {
        return "Login";
    }
    
}
