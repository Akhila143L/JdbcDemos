package com.exam.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AgentInsert {
	public static void main(String[] args) {
		String name,city,gender,maritalstatus;
		double premium;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Name   ");
		name = sc.next();
		System.out.println("Enter City   ");
		city = sc.next();
		System.out.println("Enter Gender  ");
		gender = sc.next();
		System.out.println("Enter marital Status  ");
		maritalstatus = sc.next();
		System.out.println("Enter premium   ");
		premium = sc.nextDouble();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","root","india@123");
	        String cmd = "insert into Agent(name,city,gender,maritalstatus,premium)" + "values (?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(cmd);
	pst.setString(1,name);
	pst.setString(2,city);
	pst.setString(3,gender);
	pst.setString(4,maritalstatus);
	pst.setDouble(5,premium);
	pst.executeUpdate();
	System.out.println("Agent Record Inserted...");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	     }

}
