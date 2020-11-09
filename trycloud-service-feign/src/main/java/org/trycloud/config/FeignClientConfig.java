package org.trycloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class FeignClientConfig {
	@Bean
	public Logger.Level getFeignLoggerLevel(){
		return feign.Logger.Level.FULL;
	}
	@Bean
	public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
		return new BasicAuthRequestInterceptor("fxy", "123456");
	}
}
