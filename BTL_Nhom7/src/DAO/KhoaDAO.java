package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Database.DBconnect;
import Entites.Khoa;

public class KhoaDAO {
	public Khoa TimKhoa(String maKhoa) {
		Connection con = DBconnect.getInstance().getConnection();
		try {
			PreparedStatement stm = con.prepareStatement("select * from Khoa where maKhoa = ?");
			stm.setString(1, maKhoa);
			ResultSet rs = stm.executeQuery();
			if(rs.next()) {
				String maKhoa1 = rs.getString(1); 
				String tenKhoa = rs.getString(2);
				Khoa khoa = new Khoa(maKhoa1,tenKhoa);
				return khoa;

			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
		return null;
	}
}
