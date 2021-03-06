//package com.sapo.team03.MCRM.Security;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import com.sapo.team03.MCRM.Exception.PasswordNotMatch;
//import com.sapo.team03.MCRM.Security.Filters.JWTAuthenticationFilter;
//import com.sapo.team03.MCRM.Security.Filters.JWTLoginFilter;
//
//
//@Configuration
//@EnableWebSecurity
//
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//	@Autowired
//	private DataSource dataSource;
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable().authorizeRequests().antMatchers("/").permitAll() 
//				.antMatchers(HttpMethod.POST, "/login").permitAll() 
//				.anyRequest().authenticated() 
//				.and()
//				.addFilterBefore(new JWTLoginFilter("/login", authenticationManager()),
//						UsernamePasswordAuthenticationFilter.class)
//				.addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
//	}
//
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception,PasswordNotMatch {
//		auth.jdbcAuthentication().dataSource(dataSource)
//				.usersByUsernameQuery("select email,password,true as enabled from staff where email=?")
//				.authoritiesByUsernameQuery("select email, role from staff where email=?")
//				.passwordEncoder(new BCryptPasswordEncoder());
//
//	}
//
//}
