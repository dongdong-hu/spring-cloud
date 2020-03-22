package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class providerMain8003 {

    public static void main(String[] args) {
        SpringApplication.run(providerMain8003.class ,args);
    }


}
