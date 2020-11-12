package org.fxytry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication()
@EnableEurekaClient
@EnableFeignClients("org.trycloud.service")
public class ConsumerHystrixApp {
	public static void main(String[] args) {
        SpringApplication.run(ConsumerHystrixApp.class,args);
    }
}
