package org.fxytry.config;

import org.springframework.context.annotation.Bean;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

public class RibbonConfig {
	@Bean
	public IRule ribbonRule() {
		return new RandomRule();
	}

}
