package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Database.DBconnect;
import Entites.HoiDong;
import Entites.Khoa;

public class HoiDongDAO {
	public void addHoiDong(HoiDong hd) {
		Connection con = DBconnect.getInstance().getConnection();
		try {
			String sql = "insert into HoiDong(tenHoiDong,maVong,khoa) OUTPUT inserted.maHoiDong values(?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1,hd.getTenHD());
			pst.setString(2, hd.getMaVong());
			pst.setString(3, hd.getKhoa().getMaKhoa());
			int i = pst.executeUpdate();
			pst.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<HoiDong> getAllHoiDong(){
		Connection con = DBconnect.getInstance().getConnection();
		ArrayList<HoiDong> hd = new ArrayList<HoiDong>();
		try {
			String sql = "Select * from HoiDong";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				int maHD = rs.getInt(1);
				String tenHD = rs.getString(2);
				String maVong = rs.getString(3);
				String maKhoa = rs.getString(4);
				Khoa k = new Khoa();
				KhoaDAO kDAO = new KhoaDAO();
				k = kDAO.TimKhoa(maKhoa);
				HoiDong hd1 = new HoiDong(maHD,tenHD,maVong,k);
				hd.add(hd1);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return hd;
		
	}
	
}
