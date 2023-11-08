package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.cj.MysqlConnection;


public class TestJdbc {

	public static void main(String[] args) {
		
	String jdbcURL = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false&serverTimezone=UTC";
	String user="hbstudent";
	String pass="hbstudent";
	try {
		System.out.println("Connecting to database" +jdbcURL);
		Connection myCon = DriverManager.getConnection(jdbcURL, user, pass);
		System.out.println("Connection Successful");
		
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	}

}
