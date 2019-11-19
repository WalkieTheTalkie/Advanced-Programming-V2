package application;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class DatabaseUpload {
	public static void main(String[] args) {
		String URL = "jdbc:mysql://localhost:3306";
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter MySQL User: ");
		String USERNAME = input.next();
		System.out.println("Enter MySQL Password: ");
		String PASSWD = input.next();
		
		
		
		
		try {
			Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWD);
			System.out.println("Database Connected!");
			
			DatabaseMetaData database = conn.getMetaData();
			ResultSet res = database.getCatalogs();
			Statement stmt = conn.createStatement();
			boolean dBThere = false;
			
			System.out.println("\n\n========================================\n\nMake a database:");
			String newBase = input.next();
			PreparedStatement makinData = conn.prepareStatement("CREATE DATABASE IF NOT EXISTS " + newBase + ";");
			makinData.execute();
			res = database.getCatalogs();
			System.out.println("list of databases: ");
			while(res.next()) System.out.println(res.getString(1));
			System.out.println("\n\nDATABASE IS SET TO: " + newBase);
			
			stmt.addBatch("USE " + newBase);
			stmt.executeBatch();
			res.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	

	}

}
