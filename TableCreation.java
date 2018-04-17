package com.biz.Sql_Ignite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;



public class TableCreation {
	
	public static void main(String[] args) throws ClassNotFoundException,SQLException 
	{
		Ignite ignite = Ignition.start();
		ignite.cluster().active(true);
	
		
		Class.forName("org.apache.ignite.IgniteJdbcThinDriver");
		Connection conn = DriverManager.getConnection("jdbc:ignite:thin://192.168.1.4/");
		try (Statement stmt = conn.createStatement()) {
			 stmt.executeUpdate("CREATE TABLE Organization (" +
			            " id INTEGER PRIMARY KEY," +
			            " name VARCHAR(50)," +
			            " city VARCHAR(50))");
			 
			 System.out.println("Tables created successfully");
			 
			 stmt.executeUpdate("INSERT INTO Organization VALUES(1,'Sulu','Assam')");
			 stmt.executeUpdate("INSERT INTO Organization VALUES(2,'Sayed','SouthAfrica')");
			 stmt.executeUpdate("INSERT INTO Organization VALUES(3,'Ankit','Banglore')");
			 stmt.executeUpdate("INSERT INTO Organization VALUES(4,'Ruhi','Zimbawe')");
			 stmt.executeUpdate("INSERT INTO Organization VALUES(5,'Nafisha','Arab')");
			 stmt.executeUpdate("INSERT INTO Organization VALUES(6,'Sahibul','Saudi')");
			 
			 System.out.println("Tables Inserted successfully");
			 
			 ResultSet rs = conn.createStatement().executeQuery("select * from Organization");
			 System.out.println(rs);
			 while (rs.next()) {
				 String id = rs.getString(1);
			     String name = rs.getString(2);
			     String city = rs.getString(3);
				 System.out.println("id=" + id);
				 System.out.println("name=" + name);
				 System.out.println("city=" + city);
			 }
			 
			 
		
			 System.out.println("Tables updated successfully");
			 System.out.println("Tables deleted successfully");
		
		}
	System.out.println("Tables created successfully");
	}

}
