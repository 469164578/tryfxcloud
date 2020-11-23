package org.fxytry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class HaEurekaApp{
    public static void main( String[] args ){
    	
        SpringApplication.run(HaEurekaApp.class, args);
        
    }
}
