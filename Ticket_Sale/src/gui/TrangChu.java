package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dao.NhanVien_Dao;
import entity.NhanVien;

public class TrangChu extends JFrame implements ActionListener, MouseListener {
	
	private JLabel lbl_ve,lbl_thongke,img_logo,lbl_home,lbl_phim,lbl_DangXuat,lbl_nv,lbl_ttcn, lbl_tk;
	private JPanel  right_container,left_container,home_container,phim_container, thongke_container,ve_container,DangXuat_container, left_menu,logo_container,nv_container,ttcn_container,tk_container;



	public TrangChu(){
		
		initComponents();
		setRole();
			
	}
	
	public void setRole(){
        
    }
	

	private void initComponents() {
		setTitle("Nhóm 3 con báo");
		setSize(1200, 780);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
		
		
		//left
        left_container = new JPanel();
        left_container.setBackground(new Color(253, 245, 244));
        left_container.setPreferredSize(new Dimension(200,780));
        
        
        //logo
        logo_container= new JPanel();
        ImageIcon icon = new ImageIcon("data/icon/logo.jpg");// 
		Image image = icon.getImage();//Lấy hình ảnh từ ImageIcon
		Image resizedImage = image.getScaledInstance(200, 90, Image.SCALE_SMOOTH);
		ImageIcon resizedIcon = new ImageIcon(resizedImage);
		img_logo = new JLabel(resizedIcon);
		logo_container.add(img_logo);
		
		left_container.add(logo_container,BorderLayout.NORTH);
		
        //home
        home_container = new JPanel();
        home_container.setBorder( BorderFactory.createMatteBorder(1, 0, 1,0 ,Color.BLACK));
        home_container.setPreferredSize(new Dimension(200,50));
       
        
        lbl_home = new JLabel("HOME");
        lbl_home.setFont(new Font("Segoe UI", 0, 20));
        lbl_home.setForeground(Color.RED);
        lbl_home.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        home_container.add(lbl_home);
        
        //phim
        phim_container = new JPanel();
        phim_container.setBorder( BorderFactory.createMatteBorder(1, 0, 1,0 ,Color.BLACK));
        phim_container.setPreferredSize(new Dimension(200,50));

        lbl_phim = new JLabel("PHIM");
        lbl_phim.setFont(new Font("Segoe UI", 0, 20));
        lbl_phim.setForeground(Color.RED);
        lbl_phim.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        phim_container.add(lbl_phim);
        
        
        //Vé
        ve_container = new JPanel();
        ve_container.setBorder( BorderFactory.createMatteBorder(1, 0, 1,0 ,Color.BLACK));
        ve_container.setPreferredSize(new Dimension(200,50));

        
        lbl_ve = new JLabel("VÉ");
        lbl_ve.setFont(new Font("Segoe UI", 0, 20));
        lbl_ve.setForeground(Color.RED);
        lbl_ve.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        ve_container.add(lbl_ve);
        
      //Nhân viên 
        nv_container = new JPanel();
        nv_container.setBorder( BorderFactory.createMatteBorder(1, 0, 1,0 ,Color.BLACK));
        nv_container.setPreferredSize(new Dimension(200,50));

        
        lbl_nv = new JLabel("NHÂN VIÊN");
        lbl_nv.setFont(new Font("Segoe UI", 0, 20));
        lbl_nv.setForeground(Color.RED);
        lbl_nv.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        nv_container.add(lbl_nv);
        
        //TaiKhoan
        tk_container = new JPanel();
        tk_container.setBorder( BorderFactory.createMatteBorder(1, 0, 1,0 ,Color.BLACK));
        tk_container.setPreferredSize(new Dimension(200,50));

        
        lbl_tk = new JLabel("TÀI KHOẢN");
        lbl_tk.setFont(new Font("Segoe UI", 0, 20));
        lbl_tk.setForeground(Color.RED);
        lbl_tk.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        tk_container.add(lbl_tk);
        
        //thongke
        thongke_container = new JPanel();
        thongke_container.setBorder( BorderFactory.createMatteBorder(1, 0, 1,0 ,Color.BLACK));
        thongke_container.setPreferredSize(new Dimension(200,50));

        
        lbl_thongke = new JLabel("THỐNG KÊ");
        lbl_thongke.setFont(new Font("Segoe UI", 0, 20));
        lbl_thongke.setForeground(Color.RED);
        lbl_thongke.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        thongke_container.add(lbl_thongke);
        
        //Thong tin ca nhan
        ttcn_container = new JPanel();
        ttcn_container.setBorder( BorderFactory.createMatteBorder(1, 0, 1,0 ,Color.BLACK));
        ttcn_container.setPreferredSize(new Dimension(200,50));

        
        lbl_ttcn = new JLabel("THÔNG TIN CÁ NHÂN");
        lbl_ttcn.setFont(new Font("Segoe UI", 0, 20));
        lbl_ttcn.setForeground(Color.RED);
        lbl_ttcn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        
        ttcn_container.add(lbl_ttcn);
        //head
        left_menu = new JPanel();
        left_menu.setLayout(new BoxLayout(left_menu, BoxLayout.Y_AXIS));
        
        left_menu.add(home_container);
        left_menu.add(phim_container);
        left_menu.add(ve_container);
        left_menu.add(nv_container);
        left_menu.add(tk_container);
        left_menu.add(thongke_container);
        left_menu.add(ttcn_container);
        left_container.add(left_menu,BorderLayout.CENTER);

        
        //ĐĂNG XUẤT 
        DangXuat_container = new JPanel();
        DangXuat_container.setBorder( BorderFactory.createMatteBorder(1, 0, 0,0 ,Color.BLACK));
        DangXuat_container.setPreferredSize(new Dimension(200,50));
        
        lbl_DangXuat = new JLabel("ĐĂNG XUẤT");
        lbl_DangXuat.setFont(new Font("Segoe UI", 0, 20));
        lbl_DangXuat.setForeground(Color.RED);
        lbl_DangXuat.setCursor(new Cursor(Cursor.HAND_CURSOR));
        DangXuat_container.add(lbl_DangXuat);
       
        
       left_container.add(DangXuat_container,BorderLayout.SOUTH);
        
        
        
        
        add(left_container,BorderLayout.WEST);
        
        
        
        
        
        
        
        
        
        
        //right
        right_container = new JPanel();
       right_container.setPreferredSize(new Dimension(980,780));
        
        right_container.setBorder( BorderFactory.createMatteBorder(1, 1, 1,1 ,Color.BLACK));
        
      
//        addPanel(right_container);

       
       
        
        
        add(right_container,BorderLayout.EAST);
        
        
       
        pack();
        setVisible(true);
        
        lbl_phim.addMouseListener(this);
        lbl_ve.addMouseListener(this);
		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		 if (e.getSource().equals(lbl_ve)) {
			 right_container.setVisible(true); // Hiển thị right_container
		        right_container.removeAll(); // Xóa tất cả các thành phần cũ trong right_container
	        right_container.add(new TrangThongTinCaNhan()); // Thêm QuanLyVe vào right_container
		        right_container.revalidate(); // Cập nhật giao diện
		        right_container.repaint();
	       }
		 else if(e.getSource().equals(lbl_nv)) {
			right_container.setVisible(true); // Hiển thị right_container
	        right_container.removeAll(); // Xóa tất cả các thành phần cũ trong right_container
	        right_container.add(new TrangQuanLyNhanVien()); // Thêm QuanLyVe vào right_container
	        right_container.revalidate(); // Cập nhật giao diện
	        right_container.repaint();
		}
		 else if(e.getSource().equals(lbl_tk)) {
				right_container.setVisible(true); // Hiển thị right_container
		        right_container.removeAll(); // Xóa tất cả các thành phần cũ trong right_container
		        right_container.add(new TrangQuanLyTaiKhoan()); // Thêm QuanLyVe vào right_container
		        right_container.revalidate(); // Cập nhật giao diện
		        right_container.repaint();
			}
		 else if(e.getSource().equals(lbl_nv)) {
				right_container.setVisible(true); // Hiển thị right_container
		        right_container.removeAll(); // Xóa tất cả các thành phần cũ trong right_container
		        right_container.add(new TrangQuanLyNhanVien()); // Thêm QuanLyVe vào right_container
		        right_container.revalidate(); // Cập nhật giao diện
		        right_container.repaint();
			}
		 
		 else if(e.getSource().equals(lbl_ttcn)) {
				right_container.setVisible(true); // Hiển thị right_container
		        right_container.removeAll(); // Xóa tất cả các thành phần cũ trong right_container
		        right_container.add(new TrangThongTinCaNhan()); // Thêm QuanLyVe vào right_container
		        right_container.revalidate(); // Cập nhật giao diện
		        right_container.repaint();
		        
		        
		        System.out.println("swap panel isn't working");
			}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	



}