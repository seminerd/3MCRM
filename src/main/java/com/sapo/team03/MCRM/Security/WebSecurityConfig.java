package com.sapo.team03.MCRM.Security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.sapo.team03.MCRM.Exception.PasswordNotMatch;
import com.sapo.team03.MCRM.Filters.JWTAuthenticationFilter;
import com.sapo.team03.MCRM.Filters.JWTLoginFilter;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/").permitAll() 
				.antMatchers(HttpMethod.POST, "/login").permitAll() 
				.anyRequest().authenticated() 
				.and()
				.addFilterBefore(new JWTLoginFilter("/login", authenticationManager()),
						UsernamePasswordAuthenticationFilter.class)
				.addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception,PasswordNotMatch {
//		auth.inMemoryAuthentication().withUser("admin").password("{noop}password").roles("ADMIN");
		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("select email,password,true as enabled from nhanvien where email=?")
				.authoritiesByUsernameQuery("select email, roleUA from nhanvien where email=?")
				.passwordEncoder(new BCryptPasswordEncoder());

	}

}
