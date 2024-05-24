package com.cloud.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = {"com.cloud"})
@EnableDiscoveryClient
@SpringBootApplication
public class CloudProductAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudProductAppApplication.class, args);
    }

}
