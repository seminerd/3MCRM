package com.sapo.team03.MCRM.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("application.properties")
public class AppConfig {
	@Bean
	public static PropertySourcesPlaceholderConfigurer getCongig() {
		return new PropertySourcesPlaceholderConfigurer();
	}

}