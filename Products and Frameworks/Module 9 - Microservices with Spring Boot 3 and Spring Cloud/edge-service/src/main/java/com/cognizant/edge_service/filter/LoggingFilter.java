package com.cognizant.edge_service.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class LoggingFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange,
                             GatewayFilterChain chain) {

        System.out.println("--------------------------------");

        System.out.println("Incoming Request");

        System.out.println("Method : " +
                exchange.getRequest().getMethod());

        System.out.println("URI : " +
                exchange.getRequest().getURI());

        System.out.println("--------------------------------");

        return chain.filter(exchange);

    }

    @Override
    public int getOrder() {
        return -1;
    }

}