package com.sapo.team03.MCRM.Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

@Configuration
@EnableResourceServer
public class ResourceServerConfig implements ResourceServerConfigurer {

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {

	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.anonymous().disable()
		.requestMatchers().antMatchers("/customers/**")
		.and().authorizeRequests()
		.antMatchers("/staffs/**").access("hasRole('ADMIN') or hasRole('USER')")
		.and().exceptionHandling()
		.accessDeniedHandler(new OAuth2AccessDeniedHandler());
	}

}
