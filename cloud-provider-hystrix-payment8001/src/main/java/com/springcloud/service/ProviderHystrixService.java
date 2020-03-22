package com.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class ProviderHystrixService {


    public  String paymentOK(Integer id){

        return "线程池：" + Thread.currentThread().getName() + "paymentOK,id=" +id +"我很开心";
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")
    })
    public String paymentTimeOut(Integer id){
        int time = 4000;
        //int a = 10/0;
        try {
            TimeUnit.SECONDS.wait(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "paymentOK,id=" +id +"我很难过~~~~";
    }

    public String paymentInfo_TimeOutHandler(Integer id) {
        return "线程池： " + Thread.currentThread().getName() + " 8001系统繁忙系统报错,请稍后再试id: " + id + "\t" + "( Ĭ ^ Ĭ )";
    }
}
