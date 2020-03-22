package com.springcloud.controller;

import com.springcloud.entities.CommonResult;
import com.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {
    public final  static String URL = "http://cloud-payment-service";
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/payment/comsumer/get/{id}")
     public CommonResult consumerGetById(@PathVariable("id") Long id){

        return  restTemplate.getForObject(URL+"/payment/get/"+id, CommonResult.class);

     }
     @GetMapping("/consumer/payment/create")
    public CommonResult<Payment>  consumerCreate(Payment payment){
        return restTemplate.postForObject(URL+"/payment/create",payment,CommonResult.class);

     }
}
