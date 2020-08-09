package com.cognizant.pas.application.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping(value = "/account")
public class LoginController {

    @GetMapping(value = "/login")
    public String displayLoginPage() {
        log.info("{}, Information: Displaying login page", this.getClass().getSimpleName());
        return "login";
    }

}
