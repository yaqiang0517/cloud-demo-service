package com.cloud.product.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author:zyq
 * @create: 2024-05-21 16:17
 * @Description:
 */
@Configuration
public class BeanConfig {

    @Bean
    public Logger.Level getLogLevel() {
        return Logger.Level.FULL;
    }

    @Bean
//    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
