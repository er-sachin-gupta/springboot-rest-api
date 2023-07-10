package net.javaguides.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/radhe-krishna")
    public String radheKrishna() {
        return "Jai Shri Radhe - Krishna!";
    }

/*    @PostMapping
    public */

}
