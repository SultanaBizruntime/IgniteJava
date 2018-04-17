package com.biz.Sql_Ignite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;

public class DropTable {
	public static void main(String[] args)throws Exception 
	{
		Ignite ignite = Ignition.start();
		ignite.cluster().active(true);
	
		
		Connection conn = DriverManager.getConnection("jdbc:ignite:thin://192.168.1.4/");
		try (Statement stmt = conn.createStatement()) 
		{
		    stmt.execute("drop table EmployeeCreated");
		    
		}
		System.out.println("Truncated");
	}

}
