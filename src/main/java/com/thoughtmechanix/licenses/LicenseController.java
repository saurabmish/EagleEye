package com.thoughtmechanix.licenses;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LicenseController {
    
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public String greeting() {
        return "Hello, World!";
    }
}
