package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Database.DBconnect;

public class ChiTietHoiDongDAO {
	
	public void addChiTietHoiDong(String maGV, int maHD) {
		Connection con = DBconnect.getInstance().getConnection();
		try {
			String sql = "Insert into ChiTietHoiDong(maGiangVien,maHoiDong) values (?,?)";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setString(1, maGV);
			pre.setInt(2, maHD);
			int i = pre.executeUpdate();
			pre.close();
			con.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
