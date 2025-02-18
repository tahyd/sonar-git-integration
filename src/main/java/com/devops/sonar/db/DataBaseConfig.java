package com.devops.sonar.db;

import java.util.Arrays;
import java.util.Base64;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

@Component
public class DataBaseConfig {
	
     @Value("${spring.datasource.url}")
	 private String dbUrl;
     @Value("${spring.datasource.driver-class-name}")
	 private String dbDriver;
     @Value("${spring.datasource.username}")
	 private String dbUsername;
     @Value("${spring.datasource.password}")
	 private String dbPassword;
	

     
	public String getDbUrl() {
		return dbUrl;
	}



	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}



	public String getDbDriver() {
		return dbDriver;
	}



	public void setDbDriver(String dbDriver) {
		this.dbDriver = dbDriver;
	}



	public String getDbUsername() {
		return dbUsername;
	}



	public void setDbUsername(String dbUsername) {
		this.dbUsername = dbUsername;
	}



	public String getDbPassword() {
		return dbPassword;
	}



	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}



	public DataSource getDataSource() {
		
		return new DriverManagerDataSource(dbUrl, "root", Arrays.toString(Base64.getDecoder().decode(getDbPassword())));
		
		
		
	}
	 
	 
}
