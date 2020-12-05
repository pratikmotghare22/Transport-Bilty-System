package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.CityBean;

public class CityDao {
	public static int save(CityBean bean) {
		int status = 0;
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("insert into cities values(?,?,?)");
			ps.setString(1, bean.getCity());
			ps.setString(2, bean.getCity_Code());
			ps.setString(3, bean.getState());
			status = ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	public static List<CityBean> view() {
		List<CityBean> list = new ArrayList<CityBean>();
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("select * from cities order by cityname asc ");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CityBean bean = new CityBean();
				bean.setId(rs.getInt("id"));
				bean.setCity(rs.getString("cityname"));
				bean.setCity_Code(rs.getString("citycode"));
				bean.setState(rs.getString("state"));
				list.add(bean);
			}
			con.close();
		} catch (Exception e) {
			System.out.print(e);
		}
		return list;
	}

	public static int update(CityBean bean) {
		int status = 0;
		try {

			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("update cities set cityname=?, citycode=?, state=? where id=?");
			System.out.print(5);

			ps.setString(1, bean.getCity());
			ps.setString(2, bean.getCity_Code());
			ps.setString(3, bean.getState());
			ps.setInt(4, bean.getId());
			System.out.print(6);

			status = ps.executeUpdate();
			System.out.print(7);

			con.close();
		} catch (Exception e) {
			System.out.print(e);
		}
		return status;
	}

	public static CityBean getRecordById(int id) {
		CityBean bean = new CityBean();
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("select * from cities where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				bean.setId(rs.getInt("id"));
				bean.setCity(rs.getString("cityname"));
				bean.setCity_Code(rs.getString("citycode"));
				bean.setState(rs.getString("state"));
			}
			con.close();
		} catch (Exception e) {
			System.out.print(e);
		}
		return bean;
	}

	public static int delete(String cityname) {
		int status = 0;
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("delete from cities where cityname=?");
			ps.setString(1, cityname);
			status = ps.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		return status;
	}
}