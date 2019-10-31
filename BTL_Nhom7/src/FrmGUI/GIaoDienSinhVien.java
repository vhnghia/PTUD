package FrmGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import org.w3c.dom.events.EventTarget;
import org.w3c.dom.events.MouseEvent;
import org.w3c.dom.views.AbstractView;

import DAO.LuanVanDAO;
import Entites.LuanVan;

public class GIaoDienSinhVien extends JFrame implements ActionListener, MouseListener {

	private JButton btnTimKiem, btnCLear;
	private JPanel jp;
	private JLabel lbMSVV, lbtenSV, lbTenDeTai, lbTomTat, lbGVHD, lbTTLV, lbLogo, lbKhoa;
	private JTextField jtMSVV, jttenSV, jtTenDeTai, jtTomTat, jtGVHD, jtKhoa, jtMSSV1;
	private String tk;
	private JMenuItem menuI1, menuIMatKhau, menuDangXuat, menuThoat, menuKQHT;
	private JMenu menu1, menu2, menu3, menu4;
	private JMenuBar menuBar;
	private DefaultTableModel modelLuanVan;
	private JTable jtTable;
	private JComboBox cboTimKiem;
	private LuanVanDAO lvDAO;
	private ArrayList<String> items = new ArrayList<String>();
	private ArrayList<LuanVan> lv = new ArrayList<LuanVan>();

	public GIaoDienSinhVien(String tenTK) {
		setTitle("Sinh Vien");
		setSize(1250, 750);
		setLocationRelativeTo(null);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		GiaoDien(tenTK);
	}

	public void GiaoDien(String tenTK) {
		jp = new JPanel();
		tk = tenTK;
		jp.setLayout(new BorderLayout());
		// Jpanel West

		// Tạo thanh Menu Ngang trên South
		menuBar = new JMenuBar();

		menu1 = new JMenu("Sinh viên");
		menu2 = new JMenu("Hệ thống");
		menuBar.add(menu1);
		menuBar.add(menu2);
		ImageIcon ht = new ImageIcon("Images/ht.png");
		menu2.setIcon(ht);
		// Menu Con chức năng
		menuI1 = new JMenuItem("Thông tin sinh viên");
		menuIMatKhau = new JMenuItem("Cập nhật mật khẩu");
		menuDangXuat = new JMenuItem("Đăng xuất");
		menuThoat = new JMenuItem("Thoát hệ thống");
		menuKQHT = new JMenuItem("Kết quả học tập");
		menu1.add(menuI1);
		menu1.add(menuIMatKhau);
		menu1.add(menuKQHT);
		menu2.add(menuDangXuat);
		menu2.add(menuThoat);

		ImageIcon img1 = new ImageIcon("Images/home.png");
		ImageIcon img2 = new ImageIcon("Images/st.png");
		ImageIcon img3 = new ImageIcon("Images/kqht.png");
		ImageIcon img4 = new ImageIcon("Images/dx.png");
		ImageIcon img5 = new ImageIcon("Images/ht.png");
		ImageIcon img6 = new ImageIcon("Images/thoat.png");
		ImageIcon img7 = new ImageIcon("Images/ps.png");

		menu1.setIcon(img2);
		menu2.setIcon(img5);
		menuDangXuat.setIcon(img4);
		menuKQHT.setIcon(img3);
		menuI1.setIcon(img2);
		menuIMatKhau.setIcon(img7);
		menuThoat.setIcon(img6);

		jp.add(menuBar, BorderLayout.NORTH);

		JPanel jpCenter = new JPanel();
		jpCenter.setPreferredSize(new Dimension(1120, 160));
		jp.add(jpCenter, BorderLayout.CENTER);

		JPanel jpTTSVNorth = new JPanel();
		jpTTSVNorth.setPreferredSize(new Dimension(1120, 350));
		jpTTSVNorth.setLayout(null);

		lbTTLV = new JLabel("QUẢN LÍ KHOÁ LUẬN TỐT NGHIỆP");
		lbTTLV.setFont(new Font("Arial", Font.BOLD, 24));
		lbTTLV.setForeground(Color.RED);
		jpTTSVNorth.add(lbTTLV);
		ImageIcon logo = new ImageIcon("Images/logoIUH.png");
		lbLogo = new JLabel();
		lbLogo.setIcon(logo);
		jpTTSVNorth.add(lbLogo);

		lbLogo.setBounds(700, 8, 400, 400);

		lbMSVV = new JLabel("Mã số sinh viên: ");
		jtMSVV = new JTextField(10);
		jpTTSVNorth.add(lbMSVV);
		jpTTSVNorth.add(jtMSVV);

		lbtenSV = new JLabel("Tên sinh viên: ");
		jttenSV = new JTextField(10);
		jpTTSVNorth.add(lbtenSV);
		jpTTSVNorth.add(jttenSV);

		lbTenDeTai = new JLabel("Tên khoá luận: ");
		jtTenDeTai = new JTextField(10);
		jpTTSVNorth.add(lbTenDeTai);
		jpTTSVNorth.add(jtTenDeTai);

		lbKhoa = new JLabel("Khoa:");
		jtKhoa = new JTextField(10);
		jpTTSVNorth.add(lbKhoa);
		jpTTSVNorth.add(jtKhoa);

		lbTomTat = new JLabel("Tóm tắt: ");
		jtTomTat = new JTextField(10);
		jpTTSVNorth.add(lbTomTat);
		jpTTSVNorth.add(jtTomTat);

		lbGVHD = new JLabel("Giáo viên hướng dẫn:");
		jtGVHD = new JTextField(10);
		jpTTSVNorth.add(lbGVHD);
		jpTTSVNorth.add(jtGVHD);

		btnTimKiem = new JButton("Tìm kiếm: ");
		jtMSSV1 = new JTextField(10);
		jpTTSVNorth.add(btnTimKiem);
		jpTTSVNorth.add(jtMSSV1);
		// thiet lap compoent

		btnCLear = new JButton("Xoá Trắng");
		jpTTSVNorth.add(btnCLear);

		lbTTLV.setBounds(350, 20, 500, 30);

		lbMSVV.setBounds(60, 100, 150, 20);
		jtMSVV.setBounds(210, 100, 300, 20);

		lbtenSV.setBounds(60, 135, 150, 20);
		jttenSV.setBounds(210, 135, 300, 20);

		lbTenDeTai.setBounds(60, 165, 150, 20);
		jtTenDeTai.setBounds(210, 165, 300, 20);

		lbKhoa.setBounds(60, 195, 150, 20);
		jtKhoa.setBounds(210, 195, 300, 20);

		lbTomTat.setBounds(60, 225, 150, 20);
		jtTomTat.setBounds(210, 225, 300, 20);

		lbGVHD.setBounds(60, 255, 150, 20);
		jtGVHD.setBounds(210, 255, 300, 20);

		btnTimKiem.setBounds(60, 310, 150, 20);
		jtMSSV1.setBounds(220, 310, 150, 20);
		btnCLear.setBounds(380, 310, 150, 20);

		jpCenter.add(jpTTSVNorth, BorderLayout.NORTH);

		JPanel jpLuanVan = new JPanel();
		JScrollPane scrollhd;
		String Header[] = { "Mã số sinh viên", "Tên sinh viên", "Khoa", "Tên đề tài", "Tóm tắt",
				"Giáo viên hướng dẫn" };
		modelLuanVan = new DefaultTableModel(Header, 0);
		jtTable = new JTable(modelLuanVan);
		jp.add(scrollhd = new JScrollPane(jtTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.SOUTH);
		scrollhd.setBorder(BorderFactory.createTitledBorder("Thông Tin Luận Văn"));
		scrollhd.setPreferredSize(new Dimension(1110, 180));
		jpLuanVan.add(scrollhd);
		jpCenter.add(jpLuanVan);

		lvDAO = new LuanVanDAO();
		lv = lvDAO.getAllLuanVan();
		NapVaoBang(lv);

		Box b = Box.createVerticalBox();
		Box b_lb = Box.createHorizontalBox();
		JLabel south_lb = new JLabel("Đại Học Công Nghiệp Thành Phố Hồ Chí Minh", SwingConstants.CENTER);
		south_lb.setFont(new Font("Arial", Font.BOLD, 20));
		b.add(Box.createVerticalStrut(10));
		b_lb.add(south_lb);
		b.add(b_lb);

		Box b_lb1 = Box.createHorizontalBox();
		JLabel south_lb1 = new JLabel("12 Nguyễn Văn Bảo, phường 7, Quận Gò Vấp", SwingConstants.CENTER);
		b.add(Box.createVerticalStrut(10));
		b_lb1.add(south_lb1);
		b.add(b_lb1);
		jp.add(b, BorderLayout.SOUTH);
		add(jp);
		// Dang Ky su kien

		menuI1.addActionListener(this);
		menuIMatKhau.addActionListener(this);
		menuDangXuat.addActionListener(this);
		menuThoat.addActionListener(this);
		menuI1.addActionListener(this);
		menuKQHT.addActionListener(this);
		btnTimKiem.addActionListener(this);
		btnCLear.addActionListener(this);
		jtTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				int row = jtTable.getSelectedRow();
				fillForm(row);
			}
		});
		for (int i = 0; i < jtTable.getRowCount(); i++)
			items.add(jtTable.getValueAt(i, 0).toString());
		setupAutoComplete(jtMSSV1, items);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(menuI1)) {
			GiaoDienTTSV gdttsv = new GiaoDienTTSV(tk);
			gdttsv.setVisible(true);
			dispose();
		}

		if (e.getSource().equals(menuIMatKhau)) {
			GiaoDienCapNhatMatKhau gdcnmk = new GiaoDienCapNhatMatKhau(tk);
			gdcnmk.setVisible(true);
		}

		if (e.getSource().equals(menuDangXuat)) {
			GiaoDienDangNhap gddn = new GiaoDienDangNhap();
			gddn.setVisible(true);
			dispose();
		}

		if (e.getSource().equals(menuThoat)) {
			int click = JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát hệ thống không?", "Thoát hệ thống",
					JOptionPane.YES_NO_OPTION);
			if (click == JOptionPane.YES_OPTION)
				System.exit(0);
		}

		if (e.getSource().equals(menuKQHT)) {
			GiaoDienKetQuaHocTap gdkqht = new GiaoDienKetQuaHocTap(tk);
			gdkqht.setVisible(true);
			dispose();
		}

		if (e.getSource().equals(btnTimKiem)) {
			String ma = jtMSSV1.getText().toString();
			if (ma.equalsIgnoreCase("") || ma.equalsIgnoreCase(null)) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập mã số sinh ");
			} else {
				LuanVanDAO lvdao = new LuanVanDAO();
				int i = lvdao.getAllLuanVan(ma);
				jtTable.requestFocus();
				jtTable.changeSelection(i, 1, false, false);

			}
		}

		if (e.getSource().equals(btnCLear)) {
			jtMSVV.setText("");
			jttenSV.setText("");
			jtTenDeTai.setText("");
			jtKhoa.setText("");
			jtTomTat.setText("");
			jtGVHD.setText("");
			jtTable.clearSelection();
		}

	}

	public void NapVaoBang(List<LuanVan> lv) {
		for (int i = 0; i < lv.size(); i++) {
			String row[] = { lv.get(i).getSinhVien().getMssv(), lv.get(i).getSinhVien().getHoten(),
					lv.get(i).getSinhVien().getKhoaSV().getTenKhoa(), lv.get(i).getTenLuanVan(),
					lv.get(i).getTomTatLuanVan(), lv.get(i).getGiangVien().getTenGiangVien() };
			modelLuanVan.addRow(row);

		}

	}

	public void fillForm(int row) {
		if (row != -1) {
			jtMSVV.setText(jtTable.getValueAt(row, 0) + "");
			jttenSV.setText(jtTable.getValueAt(row, 1) + "");
			jtTenDeTai.setText(jtTable.getValueAt(row, 2) + "");
			jtKhoa.setText(jtTable.getValueAt(row, 3) + "");
			jtTomTat.setText(jtTable.getValueAt(row, 4) + "");
			jtGVHD.setText(jtTable.getValueAt(row, 5) + "");

		}
	}

	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub

	}

	private static boolean isAdjusting(JComboBox cbInput) {
		if (cbInput.getClientProperty("is_adjusting") instanceof Boolean) {
			return (Boolean) cbInput.getClientProperty("is_adjusting");
		}
		return false;
	}

	private static void setAdjusting(JComboBox cbInput, boolean adjusting) {
		cbInput.putClientProperty("is_adjusting", adjusting);
	}

	public static void setupAutoComplete(JTextField txtInput, ArrayList<String> items) {
		final DefaultComboBoxModel model = new DefaultComboBoxModel();
		final JComboBox cbInput = new JComboBox(model) {
			public Dimension getPreferredSize() {
				return new Dimension(super.getPreferredSize().width, 0);
			}
		};
		setAdjusting(cbInput, false);
		for (String item : items) {
			model.addElement(item);
		}
		cbInput.setSelectedItem(null);
		cbInput.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!isAdjusting(cbInput)) {
					if (cbInput.getSelectedItem() != null) {
						txtInput.setText(cbInput.getSelectedItem().toString());
					}
				}
			}
		});

		txtInput.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				setAdjusting(cbInput, true);
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					if (cbInput.isPopupVisible()) {
						e.setKeyCode(KeyEvent.VK_ENTER);
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_UP
						|| e.getKeyCode() == KeyEvent.VK_DOWN) {
					e.setSource(cbInput);
					cbInput.dispatchEvent(e);
					if (e.getKeyCode() == KeyEvent.VK_ENTER) {
						txtInput.setText(cbInput.getSelectedItem().toString());
						cbInput.setPopupVisible(false);
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					cbInput.setPopupVisible(false);
				}
				setAdjusting(cbInput, false);
			}
		});
		txtInput.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				updateList();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				updateList();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				updateList();
			}

			private void updateList() {
				setAdjusting(cbInput, true);
				model.removeAllElements();
				String input = txtInput.getText();
				if (!input.isEmpty()) {
					for (String item : items) {
						if (item.toLowerCase().startsWith(input.toLowerCase())) {
							model.addElement(item);
						}
					}
				}
				cbInput.setPopupVisible(model.getSize() > 0);
				setAdjusting(cbInput, false);
			}
		});
		txtInput.setLayout(new BorderLayout());
		txtInput.add(cbInput, BorderLayout.SOUTH);
	}
}
