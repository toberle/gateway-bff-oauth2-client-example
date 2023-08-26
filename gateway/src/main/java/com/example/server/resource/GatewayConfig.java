package com.example.server.resource;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.GatewayFilterSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("resource-server-protected", predicate -> predicate
                        .path("/protected", "/protected/*")
                        .filters(GatewayFilterSpec::tokenRelay)
                        .uri("http://localhost:8082"))
                .build();

    }
}
