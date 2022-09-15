package com.example.icbcmacaudemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/count")
@RestController
public class CountPriceController {
    @GetMapping("/getPrice")
    public String count() {
        return "hello world";
    }
}
