package com.biz.Sql_Ignite;

import java.sql.*;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;

public class EmployeeReadData {
	
	public static void main(String[] args)throws ClassNotFoundException,SQLException
	{
		Ignite ignite = Ignition.start();
		ignite.cluster().active(true);
	
		
		
		Class.forName("org.apache.ignite.IgniteJdbcThinDriver");
		Connection conn = DriverManager.getConnection("jdbc:ignite:thin://192.168.1.4/");
		try (Statement stmt = conn.createStatement()) {
		    try (ResultSet rs =
		    stmt.executeQuery("SELECT p.name, c.name " +
		    " FROM PersonCreated p, EmployeeCreated c " +
		    " WHERE p.city_id = c.id")) {
		      while (rs.next())
		         System.out.println(rs.getString(1) + ", " + rs.getString(2));
		    }
		}
	}

}
