package org.fxytry;

import org.fxytry.config.RibbonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients("org.trycloud.service")
@RibbonClient(name = "TRYCLOUD-PROVIDER-PRODUCT", configuration = RibbonConfig.class)
public class ConsumerApp {
	public static void main(String[] args) {
        SpringApplication.run(ConsumerApp.class,args);
    }
}
