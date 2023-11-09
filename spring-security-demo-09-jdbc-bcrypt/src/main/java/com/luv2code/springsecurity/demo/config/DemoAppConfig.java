package com.luv2code.springsecurity.demo.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.luv2code.springsecurity.demo")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {

	//set up the variable to hold the properties
	@Autowired
	private Environment env;
	
	//set up a logger for diagnostics 
	private Logger logger = Logger.getLogger(getClass().getName());
	
	
	
	//Define a Bean resolver
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	
	// Define a bean for our datasource
	@Bean
	public DataSource securityDataSource() {
		
		//Create a connection pool
		ComboPooledDataSource securityDataSource 
										= new ComboPooledDataSource();
		
		//set the jdbc driver class
		try {
			securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
			throw new RuntimeException();
			
		}
		
		//log the connection pool
		//For sanity sake, log this info
		//just to make sure we are really reading data from property files
		
		logger.info(">>> jdbc.url =" +env.getProperty("jdbc.url"));
		logger.info(">>> jdbc.url =" +env.getProperty("jdbc.user"));

		
		//set the database connection props
		securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		securityDataSource.setUser(env.getProperty("jdbc.user"));
		securityDataSource.setPassword(env.getProperty("jdbc.password"));;
		
		//set the connection pool props
		securityDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		securityDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		securityDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
		securityDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
		
		return securityDataSource;
	}
	
	//Need a helper class to read the property from env and convert it into integer
	private int getIntProperty(String propName) {
		String propVal = env.getProperty(propName);
		
		//now to convert to int 
		int intVal = Integer.parseInt(propVal);
		
		return intVal;
	}
	
	
}
