package com.biz.Sql_Ignite;

import java.sql.*;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;

public class InsertTable
{
	public static void main(String[] args) throws ClassNotFoundException,SQLException 
	{
		Ignite ignite = Ignition.start();
		ignite.cluster().active(true);
		
		Class.forName("org.apache.ignite.IgniteJdbcThinDriver");
		Connection conn = DriverManager.getConnection("jdbc:ignite:thin://192.168.1.4/");
		try (PreparedStatement stmt =
		conn.prepareStatement("INSERT INTO City1 (id, name) VALUES (?, ?)")) {
		    stmt.setLong(1, 1L);
		    stmt.setString(2, "Forest Hill");
		    stmt.executeUpdate();

		    stmt.setLong(2, 2L);
		    stmt.setString(2, "Denver");
		    stmt.executeUpdate();

		    stmt.setLong(3, 3L);
		    stmt.setString(3, "St. Petersburg");
		    stmt.executeUpdate();
		}
		try (PreparedStatement stmt =
		conn.prepareStatement("INSERT INTO Person11 (id, name, city_id) VALUES (?, ?, ?)")) {

		    stmt.setLong(1, 1L);
		    stmt.setString(2, "John Doe");
		    stmt.setLong(3, 3L);
		    stmt.executeUpdate();

		    stmt.setLong(1, 2L);
		    stmt.setString(2, "Jane Roe");
		    stmt.setLong(3, 2L);
		    stmt.executeUpdate();

		    stmt.setLong(1, 3L);
		    stmt.setString(2, "Mary Major");
		    stmt.setLong(3, 1L);
		    stmt.executeUpdate();

		    stmt.setLong(1, 4L);
		    stmt.setString(2, "Richard Miles");
		    stmt.setLong(3, 2L);
		    stmt.executeUpdate();
		}
		System.out.println("Record added");
	}
}