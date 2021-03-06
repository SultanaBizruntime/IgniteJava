package com.biz.Sql_Ignite;

import java.sql.*;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;

public class EmployeeInstered {
	
	public static void main(String[] args) throws ClassNotFoundException,SQLException
		{
			Ignite ignite = Ignition.start();
			ignite.cluster().active(true);
		
		
			Class.forName("org.apache.ignite.IgniteJdbcThinDriver");
			Connection conn = DriverManager.getConnection("jdbc:ignite:thin://192.168.1.4/");
			try (PreparedStatement stmt =
			conn.prepareStatement("INSERT INTO EmployeeCreated (id, name) VALUES (?, ?)")) {
			    stmt.setLong(1, 1L);
			    stmt.setString(2, "Bangalore");
			    stmt.executeUpdate();
			    stmt.setLong(1, 2L);
			    stmt.setString(2, "Hyderabad");
			    stmt.executeUpdate();
			    stmt.setLong(1, 3L);
			    stmt.setString(2, "Chennai");
			    stmt.executeUpdate();
			}
			try (PreparedStatement stmt =
			conn.prepareStatement("INSERT INTO PersonCreated (id, name, city_id) VALUES (?, ?, ?)")) {

			    stmt.setLong(1, 1L);
			    stmt.setString(2, "Sulu");
			    stmt.setLong(3, 3L);
			    stmt.executeUpdate();

			    stmt.setLong(1, 2L);
			    stmt.setString(2, "Sayed");
			    stmt.setLong(3, 2L);
			    stmt.executeUpdate();

			    stmt.setLong(1, 3L);
			    stmt.setString(2, "Raju");
			    stmt.setLong(3, 1L);
			    stmt.executeUpdate();

			    stmt.setLong(1, 4L);
			    stmt.setString(2, "Riz");
			    stmt.setLong(3, 2L);
			    stmt.executeUpdate();
			}
			System.out.println("Inserted Data in to City and Person");
		}
}


