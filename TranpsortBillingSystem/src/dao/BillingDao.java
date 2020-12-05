package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.BillingBean;

@SuppressWarnings("unused")
public class BillingDao {

	public static boolean authenticate(String email, String password) {
		boolean status = false;
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("select * from billinguser where email=? and password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				status = true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
}
