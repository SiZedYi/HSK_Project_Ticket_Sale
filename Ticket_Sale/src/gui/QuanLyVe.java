package gui;


import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


public class QuanLyVe extends JPanel {
	
	
	private JTabbedPane tabbedPane;

	public QuanLyVe() {
		initComponents();
//		addTabbedPane();

        
    }
	
//	private void addTabbedPane(){
//        tabbedPane.add("Chọn Phim",new TabChonPhim());
//        tabbedPane.add("Đặt Vé Theo Phim", new TabDatVe());
//        tabbedPane.add("Chọn Ghế",new TabChonGhe());
//        tabbedPane.add("Thanh Toán", new TabThanhToan());
//     
//    }
	
	 private void initComponents() {
        tabbedPane = new JTabbedPane();

        setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        setPreferredSize(new Dimension(970,780));
        setLayout(new javax.swing.BoxLayout(this, BoxLayout.LINE_AXIS));
       
        tabbedPane.setPreferredSize(new Dimension(970,780));
        add(tabbedPane);
	    }

}
