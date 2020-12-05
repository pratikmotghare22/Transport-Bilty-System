package dao;

import java.sql.*;

public class DBConnection {
	public static Connection getCon(){
		Connection con=null;
		try{
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/TransportManagementSystem",
		            "postgres", "pratik@123");
			
		}catch(Exception e){System.out.println(e);}
		return con;
	}
}
