package com.devops.sonar.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeDao {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeDao.class);
	
	private DataBaseConfig dataBaseConfig;
	
	
	
	
	public EmployeeDao() {
		super();
	}




	public EmployeeDao( @Autowired DataBaseConfig dataBaseConfig) {
		super();
		this.dataBaseConfig = dataBaseConfig;
	}




	public void getEmployee(long eid, String ename) {
		
		PreparedStatement statment=null;
	
		try(Connection connection = dataBaseConfig.getDataSource().getConnection()) {
			
			
			
		
		 statment = connection.prepareStatement("select ename ,eid from employee where username=? and password=?");
		
			
			statment.setLong(1, eid);
			statment.setString(2, ename);
			
			ResultSet rs =	statment.executeQuery();
		
		     while(rs.next()) {
		    	 System.out.println(rs.getString(2));
		     }
		}
		catch (Exception e) {
			logger.info(e.getMessage());
		}
		finally {
			
			if(statment!=null) {
				try {
					statment.close();
				} catch (SQLException e) {
					logger.info(e.getMessage());
				}
			}
		}
	}

}
