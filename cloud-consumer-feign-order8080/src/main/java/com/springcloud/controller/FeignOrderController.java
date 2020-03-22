package com.springcloud.controller;

import com.springcloud.entities.CommonResult;
import com.springcloud.entities.Payment;
import com.springcloud.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignOrderController {


    @Autowired
    private FeignService feignService;
    @GetMapping("/payment/comsumer/get/{id}")
    public CommonResult<Payment> consumerGetById(@PathVariable("id") Long id){

        return   feignService.queryById(id);

    }


}
