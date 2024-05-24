package com.cloud.order.config;

import feign.Logger;
import feign.codec.Decoder;
import feign.optionals.OptionalDecoder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
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
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }


//    @Bean
//    @ConditionalOnClass(Decoder.class)
//    public Decoder feignDecoder() {
//        return new OptionalDecoder(new FeignDecoder());
//    }

}
