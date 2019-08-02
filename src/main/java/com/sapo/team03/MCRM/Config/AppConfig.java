package com.sapo.team03.MCRM.Config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@Import(MailConfig.class)
@PropertySource({"classpath:application.properties", "classpath:mailServer.properties"})
public class AppConfig {
	@Autowired
	   Environment env;
	@Bean
	
	public static PropertySourcesPlaceholderConfigurer getCongig() {
		return new PropertySourcesPlaceholderConfigurer();

	}

	@Bean(name = "dataSource")
	@ConfigurationProperties(prefix = "spring.datasource")
	@Primary
	public DataSource dataSource() {

	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
	    dataSource.setUrl(env.getProperty("spring.datasource.url"));
	    dataSource.setUsername(env.getProperty("spring.datasource.username"));
	    dataSource.setPassword(env.getProperty("spring.datasource.password"));

	    return dataSource;

	}
	

}