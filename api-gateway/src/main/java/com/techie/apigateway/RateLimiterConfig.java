package com.techie.apigateway;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.ServerHttpRequest;
import reactor.core.publisher.Mono;

@Configuration
public class RateLimiterConfig {

    @Bean
    public KeyResolver userKeyResolver() {
        return exchange -> {

            ServerHttpRequest request = exchange.getRequest();

            // 🔥 Get real client IP from Nginx
            String forwardedFor = request.getHeaders().getFirst("X-Forwarded-For");

            if (forwardedFor != null && !forwardedFor.isEmpty()) {
                return Mono.just(forwardedFor.split(",")[0]);
            }

            // fallback to remote address
            if (request.getRemoteAddress() != null) {
                return Mono.just(
                        request.getRemoteAddress()
                                .getAddress()
                                .getHostAddress()
                );
            }

            return Mono.just("unknown");
        };
    }
}