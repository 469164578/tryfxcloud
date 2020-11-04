package org.fxytry;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("org.fxytry.mapper")
@EnableEurekaClient
@EnableDiscoveryClient
@EnableCircuitBreaker//启动hystrix
public class ProductHystrixApp {
	public static void main(String[] args) {
        SpringApplication.run(ProductHystrixApp.class,args);
    }
}
