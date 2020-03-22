package com.springcloud.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient("provider-hystrix8001")
public interface FeignHystrixService {

    @GetMapping("/provider/paymentOK/{id}")
    public  String paymentOK(@PathVariable("id") Integer id);

    @GetMapping("/provider/paymentTimeOut/{id}")
    public  String paymentTimeOut(@PathVariable("id") Integer id);
}
