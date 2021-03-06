package com.example.hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages={"com.example"})
@RestController
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping("/helloworld")
    public String hello(){
        return "Hello World, from your Rest-Api. Please implement me! PLS PLS";
    }



}

