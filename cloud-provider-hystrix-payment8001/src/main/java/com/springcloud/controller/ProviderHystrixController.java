package com.springcloud.controller;

import com.springcloud.service.ProviderHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderHystrixController {

    @Autowired
    private ProviderHystrixService providerHystrixService;

    @GetMapping("/provider/paymentOK/{id}")
    public  String paymentOK(@PathVariable("id") Integer id){
       return providerHystrixService.paymentOK(id);
    }


    @GetMapping("/provider/paymentTimeOut/{id}")
    public  String paymentTimeOut(@PathVariable("id") Integer id){
        return providerHystrixService.paymentTimeOut(id);
    }
}
