package com.example.duckgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder
            .routes()
                .route("chat-client", r -> r.path("/chat/**").uri("lb://chat-client"))
                .route("duck-client", r -> r.path("/duck/**").uri("lb://duck-client"))
            .build();
    }

}
