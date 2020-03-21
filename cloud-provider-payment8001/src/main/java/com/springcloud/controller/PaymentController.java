package com.springcloud.controller;

import com.springcloud.entities.CommonResult;
import com.springcloud.entities.Payment;
import com.springcloud.service.PaymentService;
import com.springcloud.service.imp.PaymentServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    //@PostMapping(value = "/payment/create")
   // @PostMapping(value = "/payment/create")
    @PostMapping("/payment/create")
    public  CommonResult  create (@RequestBody  Payment payment){
        // Payment payment = new Payment() ;
         //payment.setSerial(str);
          int result = paymentService.create(payment);
           log.info("插入结果"+result);
          if(result > 0){
              return new CommonResult(200,"插入成功",result);
          }else {
              return new CommonResult(400,"插入成功ahahahaha",null);
          }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment>  queryById(@PathVariable("id") Long id){
        Payment payment = paymentService.queryById(id);
        log.info("查询结果12321"+payment);
        if (payment != null){

            return new CommonResult(200,"查询成功hahahahyyyyyyy",payment);
        }else {
            return new CommonResult(400,"没有对应记录，查询id:" + id,null);
        }
    }
}
