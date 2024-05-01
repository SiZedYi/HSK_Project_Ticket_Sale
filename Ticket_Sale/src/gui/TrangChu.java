package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import connectDB.ConnectDB;

import java.awt.Component;





//import GUI.QuanLyNhanVien;

public class TrangChu extends JFrame implements MouseListener, ActionListener {
	
	public TrangChu () {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		initComponents();
	    setRole();
	}

	public void setRole(){
        
    }
	 
	 
	 private static void addPanel(JPanel pnForm){
		 
	 }
	
	// giao diện
	 private void initComponents() {
		JPanel container = new JPanel();
        JPanel left_container = new JPanel();
        JPanel menu_container = new JPanel();
        JLabel lbl_Menu = new JLabel();
        JPanel header_container = new JPanel();
        JLabel txt_Header = new JLabel();
        JPanel phim_container = new JPanel();
        JLabel lbl_phim = new JLabel();
        JPanel home_container = new JPanel();
        JLabel lbl_home = new JLabel();
        JPanel ve_container = new JPanel();
        JLabel lbl_ve = new JLabel();
        JPanel thongke_container = new JPanel();
        JLabel lbl_thongke = new JLabel();
        JPanel DangXuat_container = new JPanel();
        JLabel lbl_DangXuat = new JLabel();
        JPanel right_container = new JPanel();
        
        
        setTitle("Nhóm 3 con báo");
		setSize(1383, 780);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        
        left_container.setBackground(new Color(253, 245, 244));
        left_container.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 0, new Color(0, 0, 0)));
        left_container.setMaximumSize(new java.awt.Dimension(230, 768));
        left_container.setMinimumSize(new java.awt.Dimension(230, 768));


        menu_container.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(255, 255, 255)));

       // logo
        ImageIcon icon = new ImageIcon("src/icon/logo.jpg");
        txt_Header.setIcon(icon);
        
        
        txt_Header.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_Header.setAlignmentY(0.0F);
        txt_Header.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt_Header.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        txt_Header.setMaximumSize(new java.awt.Dimension(320, 100));
        txt_Header.setMinimumSize(new java.awt.Dimension(320, 100));
        txt_Header.setPreferredSize(new java.awt.Dimension(320, 100));
        menu_container.add(txt_Header);
       
        //Home
        home_container.setBackground(new Color(253, 245, 244));
        home_container.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.BLACK));
        home_container.setAlignmentX(0.0F);
        home_container.setMaximumSize(new Dimension(204, 60));
        
        lbl_home.setFont(new java.awt.Font("Segoe UI", 0, 24));
        lbl_home.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_home.setText("TRANG CHỦ");
        lbl_home.setForeground(Color.BLACK);
        lbl_home.setAlignmentY(0.0F);
        lbl_home.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lbl_home.setMaximumSize(new Dimension(236, 60));
        lbl_home.setPreferredSize(new Dimension(236, 45));
        home_container.add(lbl_home);
        
        
        
        //phim
        phim_container.setBackground(new Color(253, 245, 244));
        phim_container.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.BLACK));
        phim_container.setAlignmentX(0.0F);
        phim_container.setMaximumSize(new Dimension(204, 60));

        lbl_phim.setFont(new java.awt.Font("Segoe UI", 0, 24));
        lbl_phim.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_phim.setText("PHIM");
        lbl_phim.setForeground(Color.BLACK);
        lbl_phim.setAlignmentY(0.0F);
        lbl_phim.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lbl_phim.setMaximumSize(new Dimension(236, 60));
        lbl_phim.setPreferredSize(new Dimension(236, 45));
        //thêm sự kiện 
        phim_container.add(lbl_phim);
        
        
     // vé
        ve_container.setBackground(new Color(253, 245, 244));
        ve_container.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        ve_container.setAlignmentX(0.0F);
        ve_container.setMaximumSize(new Dimension(204, 60));

        lbl_ve.setFont(new java.awt.Font("Segoe UI", 0, 24));
        lbl_ve.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_ve.setText("VÉ");
        lbl_ve.setForeground(Color.BLACK);
        lbl_ve.setAlignmentY(0.0F);
        lbl_ve.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lbl_ve.setMaximumSize(new Dimension(236, 60));
        lbl_ve.setPreferredSize(new Dimension(236, 45));
        //thêm sự kiện 
        ve_container.add(lbl_ve);
        
        
      //thông kê
        thongke_container.setBackground(new Color(253, 245, 244));
        thongke_container.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        thongke_container.setAlignmentX(0.0F);
        thongke_container.setMaximumSize(new Dimension(204, 60));

        lbl_thongke.setFont(new java.awt.Font("Segoe UI", 0, 24));
        lbl_thongke.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_thongke.setText("THỐNG KÊ");
        lbl_thongke.setForeground(Color.BLACK);
        lbl_thongke.setAlignmentY(0.0F);
        lbl_thongke.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lbl_thongke.setMaximumSize(new Dimension(236, 60));
        lbl_thongke.setPreferredSize(new Dimension(236, 45));
        //thêm sự kiện 
        thongke_container.add(lbl_thongke);
        
        
        
     // Button đăng xuất
        DangXuat_container.setBackground(new Color(253, 245, 244));
        DangXuat_container.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(255, 255, 255)));
        DangXuat_container.setAlignmentX(0.0F);
        DangXuat_container.setMaximumSize(new Dimension(204, 60));
        
        lbl_DangXuat.setFont(new Font("Segoe UI", 0, 24)); 
        lbl_DangXuat.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_DangXuat.setText("ĐĂNG XUÂT");
        lbl_DangXuat.setForeground(Color.RED);
        lbl_DangXuat.setAlignmentY(0.0F);
        lbl_DangXuat.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lbl_DangXuat.setMaximumSize(new Dimension(236, 60));
        lbl_DangXuat.setPreferredSize(new Dimension(236, 45));
        // thêm sự kiện 
        
        DangXuat_container.add(lbl_DangXuat);
        
        
        
     // layout
        GroupLayout left_containerLayout = new GroupLayout(left_container);
        left_container.setLayout(left_containerLayout);
        left_containerLayout.setHorizontalGroup(
            left_containerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(menu_container, GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
            .addComponent(home_container, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(phim_container, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(thongke_container, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(header_container, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ve_container, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(DangXuat_container, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        left_containerLayout.setVerticalGroup(
            left_containerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(left_containerLayout.createSequentialGroup()
                .addComponent(header_container, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(menu_container, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(home_container, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(phim_container, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(ve_container, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(thongke_container, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(DangXuat_container, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        right_container.setBackground(new java.awt.Color(255, 255, 255));
        right_container.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));
        right_container.setAlignmentY(0.0F);
        right_container.setMaximumSize(new Dimension(1130, 768));//kích thước pannel con 
        right_container.setMinimumSize(new Dimension(1130, 768));
        right_container.setPreferredSize(new Dimension(1130, 768));
        right_container.setLayout(new javax.swing.BoxLayout(right_container, javax.swing.BoxLayout.PAGE_AXIS));
        
        // Test Jframe
        ListMovie listMovie = new ListMovie();
        right_container.add(listMovie);
//        right_container.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{listMovie}));
        
        GroupLayout containerLayout = new GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addComponent(left_container, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(right_container, GroupLayout.PREFERRED_SIZE, 1124, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(left_container, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(right_container, GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(container, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(container, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        
		 
	 }
	 
	 public static void main(String args[]) {
	        new TrangChu().setVisible(true);
	  }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
