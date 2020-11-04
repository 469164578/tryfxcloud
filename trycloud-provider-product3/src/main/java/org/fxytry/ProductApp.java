package org.fxytry;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("org.fxytry.mapper")
@EnableEurekaClient
public class ProductApp {
	public static void main(String[] args) {
        SpringApplication.run(ProductApp.class,args);
    }
}
