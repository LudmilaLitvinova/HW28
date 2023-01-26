package com.example.hw28.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ludmila Litvinova on 25.01
 */
@RestController
public class PingController {

    @GetMapping("ping")
    public String handler() {
        return "Ok";
    }
}
