package com.cloud.order;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;

@MapperScan(basePackages = {"com.cloud.order.dao.mapper"})
@EnableFeignClients(basePackages = {"com.cloud"})
@EnableDiscoveryClient
@SpringBootApplication
@EnableAsync
public class CloudOrderAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudOrderAppApplication.class, args);
    }

}
