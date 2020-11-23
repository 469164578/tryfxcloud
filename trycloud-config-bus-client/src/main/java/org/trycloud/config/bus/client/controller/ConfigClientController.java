package org.trycloud.config.bus.client.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.trycloud.config.bus.client.config.InfoConfig;

@RestController
public class ConfigClientController {
	@Value("${spring.application.name}")
    private String applicationName;
    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaServers;

    @Resource
    private InfoConfig infoConfig;

    @RequestMapping("/config")
    public String getConfig() {
        return "ApplicationName = " + this.applicationName + "、EurekaServers = "
                + this.eurekaServers+"、infos = " +infoConfig.toString();
    }
}
