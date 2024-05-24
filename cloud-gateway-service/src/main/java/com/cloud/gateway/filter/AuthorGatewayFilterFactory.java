package com.cloud.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.StripPrefixGatewayFilterFactory;
import org.springframework.cloud.gateway.support.GatewayToStringStyler;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

/**
 * @author:zyq
 * @create: 2024-05-21 17:23
 * @Description:
 */
@Component
public class AuthorGatewayFilterFactory extends AbstractGatewayFilterFactory<AuthorGatewayFilterFactory.Config> {


    public static final String PARTS_KEY = "username";

    public AuthorGatewayFilterFactory() {
        super(AuthorGatewayFilterFactory.Config.class);
    }

    public List<String> shortcutFieldOrder() {
        return Arrays.asList("username");
    }

    public GatewayFilter apply(final AuthorGatewayFilterFactory.Config config) {
        return new GatewayFilter() {
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                var username = config.getUsername();
                if(username.equals("zyq")){
                    return chain.filter(exchange);
                }else {
                    throw new RuntimeException("权限不足 只有zyq才能访问");
                }
            }

            public String toString() {
                return GatewayToStringStyler.filterToStringCreator(AuthorGatewayFilterFactory.this).append("username", config.getUsername()).toString();
            }
        };
    }

    public static class Config {
        private String username;

        public Config() {
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }


}
