package org.trycloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.trycloud.filter.AuthorizedRequstFilter;

@Configuration
public class ZuulConfig {
	@Bean
	public AuthorizedRequstFilter getAuthorizedRequestFilter() {
		return new AuthorizedRequstFilter() ;
	}
}
