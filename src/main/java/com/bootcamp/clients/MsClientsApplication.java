package com.bootcamp.clients;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
@EntityScan(basePackages = "com.bootcamp.clients")
@SpringBootApplication(scanBasePackages = "com.bootcamp.clients")
@EnableEurekaClient
public class MsClientsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsClientsApplication.class, args);

    }

}
