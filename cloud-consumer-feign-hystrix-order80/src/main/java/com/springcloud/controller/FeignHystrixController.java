package com.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springcloud.FeignHystrixMain80;
import com.springcloud.service.FeignHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@DefaultProperties(defaultFallback = "miss")  //默认fellback 页面
public class FeignHystrixController {

    @Autowired
    private FeignHystrixService feignHystrixService;

    @GetMapping("/consumer/paymentOK/{id}")
    public String paymentOK(@PathVariable("id") Integer id){
        return feignHystrixService.paymentOK(id);

    }

    @GetMapping("/consumer/paymentTimeOut/{id}")
    public String paymentTimeOut(@PathVariable("id") Integer id){
        return feignHystrixService.paymentTimeOut(id);

    }

    @GetMapping("/consumer/paymentMiss/{id}")
    @HystrixCommand //熔断
    public String paymentMiss(@PathVariable("id") Integer id){
        int i = 10 /0;
        return feignHystrixService.paymentTimeOut(id);

    }

    public  String miss(){

        return "服务降级 80";
    }
}
