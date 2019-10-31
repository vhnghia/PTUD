package FrmGUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class GiaoDienChamDiemSinhVien extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lbLogo;
	private JMenuItem menuIQLSV , menuIDangXuat, menuIThoat, menuIQLGV, menuIThongKe, menuIThemHoiDong;
	private JMenu menu1,menu2,menuThongKe; 
	private JMenuBar menuBar;
	private JPanel jp;
	public GiaoDienChamDiemSinhVien() {
		// TODO Auto-generated constructor stub
		setTitle("Giao Diện Chấm Điểm Sinh Viên");
		setSize(1250, 750);
		setLocationRelativeTo(null);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		GiaoDienChamDiem();
	}
	
	public void GiaoDienChamDiem() {
		jp = new JPanel();
		jp.setLayout(new BorderLayout());
		menuBar = new JMenuBar();

		menu1 = new JMenu("Quản lý");
		menu2 = new JMenu("Hệ thống");
		menuThongKe = new JMenu("Thống kê");
		menuBar.add(menu1);
		menuBar.add(menu2);
		menuBar.add(menuThongKe);
		//Menu Con chức năng 
		menuIQLSV = new JMenuItem("Quản lý sinh viên");
		menuIQLGV = new JMenuItem("Quản lý giảng viên");
		menuIThongKe = new JMenuItem("Thống kê luận văn");
		
		menuIDangXuat = new JMenuItem("Đăng xuất");
		menuIThoat = new JMenuItem("Thoát hệ thống");
		menuIThemHoiDong = new JMenuItem("Tạo hội đồng");
		menu1.add(menuIQLGV);
		menu1.add(menuIQLSV);
		menu1.add(menuIThemHoiDong);
		menu2.add(menuIDangXuat);
		menu2.add(menuIThoat);
		menuThongKe.add(menuIThongKe);
		
		ImageIcon img2 = new ImageIcon("Images/ql.png");
		ImageIcon img4 = new ImageIcon("Images/dx.png");
		ImageIcon img5 = new ImageIcon("Images/ht.png");
		ImageIcon img6 = new ImageIcon("Images/thoat.png");
		ImageIcon img1 = new ImageIcon("Images/st.png");
		ImageIcon img3 = new ImageIcon("Images/gv.png");
		ImageIcon img7 = new ImageIcon("Images/tk.png");		
		ImageIcon img8 = new ImageIcon("Images/kqtk.png");
		ImageIcon img9 = new ImageIcon("Images/HD.png");
		
		menu1.setIcon(img2);
		menu2.setIcon(img5);
		menuIDangXuat.setIcon(img4);
		menuIQLSV.setIcon(img2);
		menuIThoat.setIcon(img6);
		menuIQLGV.setIcon(img3);
		menuIQLSV.setIcon(img1);
		menuIThongKe.setIcon(img8);
		menuThongKe.setIcon(img7);
		menuIThemHoiDong.setIcon(img9);
		jp.add(menuBar,BorderLayout.NORTH);
		
		
		
		add(jp);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
