package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import FrmGUI.GiaoDienTTSV;
import Database.DBconnect;
import Entites.GiangVien;
import Entites.Khoa;
import Entites.LuanVan;
import Entites.SinhVien;

public class LuanVanDAO {
	private ArrayList<LuanVan> lv = new ArrayList<LuanVan>();
	public ArrayList<LuanVan> LuanVanSinhVien(String tenTK) {
		lv = new ArrayList<LuanVan>();
		Connection con = DBconnect.getInstance().getConnection();
		SinhVienDAO svDAO = new SinhVienDAO();
		GiangVienDAO gvDAO = new GiangVienDAO();
		String magv = svDAO.KiemTraSVLV(tenTK);
		try{
			PreparedStatement stm = con.prepareStatement("select * from LuanVan");
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String mssv1 = rs.getString(1);
				String magv1 = rs.getString(2);
				String tenLV1 = rs.getString(3);
				String linhVuc1 = rs.getString(4);
				String tomTatLV = rs.getString(5);
				String noiDung1 = rs.getString(6);
				SinhVien sv = new SinhVien();
				sv = svDAO.TimTheoMaSinhVien(mssv1);
				GiangVien gv =new GiangVien();
				gv = gvDAO.TimTheoMaGiangVien(magv1);
				LuanVan lv1 = new LuanVan(sv,gv,tenLV1,linhVuc1,tomTatLV,noiDung1,mssv1,magv1);
				lv.add(lv1);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lv;
	}
	
	public LuanVan TimLuanVan(String tenTK) {
		Connection con = DBconnect.getInstance().getConnection();
		try {
			String sql = "select * from LuanVan as LV, GiangVien as GV  where LV.maGiangVien = GV.maGiaoVien and LV.mssv = ?";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, tenTK);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String mssv = rs.getString(1);
				String mgv = rs.getString(2);
				String tenLV = rs.getString(3);
				String lv = rs.getString(4);
				String ttlv = rs.getString(5);
				String nd = rs.getString(6);
				SinhVien sv = new SinhVien();
				SinhVienDAO svDAO = new SinhVienDAO();
				sv = svDAO.TimTheoMaSinhVien(mssv);
				GiangVien gv = new GiangVien();
				GiangVienDAO gvDAO = new GiangVienDAO();
				gv = gvDAO.TimTheoMaGiangVien(mgv);
				LuanVan lv1 = new LuanVan(sv,gv,tenLV,lv,ttlv,nd,null,null); 
				return lv1;
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<LuanVan> getAllLuanVan(){
		Connection con = DBconnect.getInstance().getConnection();
		ArrayList<LuanVan> dslv = new ArrayList<LuanVan>();
		try {			
			String sql = "select * from LuanVan as LV, GiangVien as GV  where LV.maGiangVien = GV.maGiaoVien";
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String mssv = rs.getString(1);
				String mgv = rs.getString(2);
				String tenLV = rs.getString(3);
				String lv = rs.getString(4);
				String ttlv = rs.getString(5);
				String nd = rs.getString(6);
				SinhVien sv = new SinhVien();
				SinhVienDAO svDAO = new SinhVienDAO();
				sv = svDAO.TimTheoMaSinhVien(mssv);
				GiangVien gv = new GiangVien();
				GiangVienDAO gvDAO = new GiangVienDAO();
				gv = gvDAO.TimTheoMaGiangVien(mgv);
				LuanVan lv1 = new LuanVan(sv,gv,tenLV,lv,ttlv,nd,null,null);
				dslv.add(lv1);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dslv;
	}
	
	public int getAllLuanVan(String mssv1){
		Connection con = DBconnect.getInstance().getConnection();
		int i=0;
		try {			
			String sql = "select * from LuanVan as LV, GiangVien as GV  where LV.maGiangVien = GV.maGiaoVien";
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String mssv = rs.getString(1);
				String mgv = rs.getString(2);
				if(mssv.equalsIgnoreCase(mssv1))
					return i;
				i++;
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}
}
