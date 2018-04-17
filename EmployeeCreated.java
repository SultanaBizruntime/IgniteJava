package com.biz.Sql_Ignite;

import java.sql.*;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;

public class EmployeeCreated {
	
		public static void main(String[] args) throws ClassNotFoundException,SQLException 
		{
		
			Ignite ignite = Ignition.start();
			ignite.cluster().active(true);
			
			
			Class.forName("org.apache.ignite.IgniteJdbcThinDriver");
			Connection conn = DriverManager.getConnection("jdbc:ignite:thin://192.168.1.4/");
			try (Statement stmt = conn.createStatement()) {
			    stmt.executeUpdate("CREATE TABLE EmployeeCreated (" + 
			    " id LONG PRIMARY KEY, name VARCHAR) " +
			    " WITH \"template=replicated\"");
			    
			    stmt.executeUpdate("CREATE TABLE PersonCreated (" +
			    " id LONG, name VARCHAR, city_id LONG, " +
			    " PRIMARY KEY (id, city_id)) " +
			    " WITH \"backups=1, affinityKey=city_id\"");
			    stmt.executeUpdate("CREATE INDEX idx_city_name ON EmployeeCreated (name)");
			    stmt.executeUpdate("CREATE INDEX idx_person_name ON PersonCreated (name)");
			}
			System.out.println("Tables created");
		}
}


