package org.eduami.spring.restapi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IsAlive {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/**")
    public String isAlive() {
        return "ON in port: " + serverPort;
    }

}
