package com.example.demo.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.LinkedHashMap;

import org.springframework.web.bind.annotation.GetMapping;

import io.jsonwebtoken.Jwts;

public class MyConnection {

	private Connection conn;
	Statement stmt;
	public MyConnection() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("Inside the MyConnection Constructor.");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Initialization...");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/temp_test", "root", "Blaze@12345");
			System.out.println("Connection Established...");
			stmt = conn.createStatement();
			System.out.println("Statement Created...");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Some Error occured:-" + e);
		}
	}
	public Dictionary AllStudents() {
		Dictionary res = new Hashtable();
		try {
			ResultSet re = stmt.executeQuery("select * from product");
			int column_count = re.getMetaData().getColumnCount();
			System.out.println("Number of columns in the Result Set:- " + column_count);
			int count = 0;
			while(re.next()) {
				
				String temp[] = new String[column_count];
				for(int i = 1 ; i <= column_count ; i++) {
					temp[i-1] = re.getString(i);
				}
				res.put(count, temp);
				count++;
			}
			return res;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			res.put("Error", e);
			return res;
		}
	}
	
	public Boolean RegisterStudent( Object obj ) {
		System.out.println(obj);
		try {
			stmt.executeUpdate("insert into product (ProductId , ProductName, ProductPrice) values('105' , 'Coat' , '8000')");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public Boolean authUser() {
//		Jwts.builder();
		return true;
	}
	
}
