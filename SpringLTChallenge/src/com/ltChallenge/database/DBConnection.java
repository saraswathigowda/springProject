package com.ltChallenge.database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class DBConnection {

	static Connection con = null;
	public static Connection getConnection() {
		ResourceBundle props = ResourceBundle.getBundle("database");
		try {
			Class.forName(props.getString("DB_DRIVER_CLASS"));
			con = DriverManager.getConnection(props.getString("DB_URL"),
					props.getString("DB_USERNAME"),
					props.getString("DB_PASSWORD"));
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
		
		Statement stmt=null;
		PreparedStatement pstmt = null;
	 public Statement crtStCon(){
	try {
			stmt = con.createStatement();
		} catch (SQLException e) {
				e.printStackTrace();
			}
			return stmt; 
		 }
		 
		 public Statement clStCon(){
			 try{
				 stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return stmt;
		 }
		 
		 public void closePreCon(){
			 try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 }
		 
		 public void closeCon(){
			 try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 }
		}
