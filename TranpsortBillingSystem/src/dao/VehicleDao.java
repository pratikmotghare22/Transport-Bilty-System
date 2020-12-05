package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.VehicleBean;

public class VehicleDao {
	public static int save(VehicleBean bean) {
		int status = 0;
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("insert into vehicle values(?,?,?,?,?)");
			ps.setString(1, bean.getVehicleType());
			ps.setString(2, bean.getVehicleName());
			ps.setString(3, bean.getVehicleNumber());
			ps.setString(4, bean.getOwnerName());
			ps.setString(5, bean.getInsurance());
			status = ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	public static List<VehicleBean> view() {
		List<VehicleBean> list = new ArrayList<VehicleBean>();
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("select * from vehicle order by vehiclename asc ");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				VehicleBean bean = new VehicleBean();
				bean.setVehicleType(rs.getString("vehicletype"));
				bean.setVehicleName(rs.getString("vehiclename"));
				bean.setVehicleNumber(rs.getString("vehiclenumber"));
				bean.setOwnerName(rs.getString("ownername"));
				bean.setInsurance(rs.getString("insurance"));
				bean.setVehicleId(rs.getInt("vehicleid"));

				list.add(bean);
			}
			con.close();
		} catch (Exception e) {

		}
		return list;
	}

	public static int delete(String vehicleno) {
		int status = 0;
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("delete from vehicle where vehiclenumber=?");
			ps.setString(1, vehicleno);
			status = ps.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		return status;
	}

	public static VehicleBean getRecordByVehicleId(int vehicleid) {
		VehicleBean bean = new VehicleBean();
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("select * from vehicle where vehicleid=?");
			ps.setInt(1, vehicleid);
			ResultSet rs = ps.executeQuery();
			System.out.println(5);
			while (rs.next()) {
				bean.setVehicleId(rs.getInt("vehicleid"));
				bean.setVehicleType(rs.getString("vehicletype"));
				bean.setVehicleName(rs.getString("vehiclename"));
				bean.setVehicleNumber(rs.getString("vehiclenumber"));
				bean.setOwnerName(rs.getString("ownername"));
				bean.setInsurance(rs.getString("insurance"));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return bean;
	}

	public static int update(VehicleBean bean) {
		int status = 0;
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement(
					"update vehicle set vehicletype=?, vehiclename=?, vehiclenumber=?, ownername=?, insurance=? where vehicleid=?");
				
			ps.setString(1, bean.getVehicleType());
			ps.setString(2, bean.getVehicleName());
			ps.setString(3, bean.getVehicleNumber());
			ps.setString(4, bean.getOwnerName());
			ps.setString(5, bean.getInsurance());
			ps.setInt(6, bean.getVehicleId());
			status = ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;

	}
}
