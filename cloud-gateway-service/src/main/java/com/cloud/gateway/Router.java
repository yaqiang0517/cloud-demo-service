package com.cloud.gateway;

import com.cloud.gateway.filter.AuthorGatewayFilterFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author:zyq
 * @create: 2024-05-21 17:02
 * @Description:
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class Router implements RouteDefinitionRepository {

    private final DiscoveryClient discoveryClient;

    @Override
    public Flux<RouteDefinition> getRouteDefinitions() {
        return Flux.fromStream(discoveryClient.getServices().stream().map(service -> {
            log.info("service:" + service);
            PredicateDefinition predicateDefinition = new PredicateDefinition();
            predicateDefinition.setName("Path");
            predicateDefinition.setArgs(Map.of("pattern", "/order/**"));

            FilterDefinition filterDefinition2 = new FilterDefinition();
            filterDefinition2.setName("Author");
            filterDefinition2.setArgs(Map.of("username", "zyq"));


            RouteDefinition routeDefinition = new RouteDefinition();
            routeDefinition.setId(service);
            routeDefinition.setMetadata(Collections.emptyMap());
            routeDefinition.setFilters(List.of(filterDefinition2));
            routeDefinition.setPredicates(List.of(predicateDefinition));
            routeDefinition.setUri(URI.create("lb://" + service));
            return routeDefinition;
        }));
    }

    @Override
    public Mono<Void> save(Mono<RouteDefinition> route) {
        return null;
    }

    @Override
    public Mono<Void> delete(Mono<String> routeId) {
        return null;
    }
}
