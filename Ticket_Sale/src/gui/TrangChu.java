package gui;

import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.SwingUtilities;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import connectDB.ConnectDB;
import dao.HoaDon_Dao;

public class TrangChu extends JFrame {

    public TrangChu() {
        setTitle("Trang Chủ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(204, 166, 166));
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        setGlobalFont(new Font("Arial", Font.BOLD, 14));
        
        
        //Table
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setPreferredSize(new Dimension(800,600));
        BangHoaDon bangHoaDon= new BangHoaDon();
        mainPanel.add(new JScrollPane(bangHoaDon), BorderLayout.CENTER);
        
        
        /*
         * 
         *Phần connect !!!
         * 
         */
        ConnectDB dbConnection = new ConnectDB();
        JLabel connectResult= new JLabel("Ket qua Ket noi");
        try {
			dbConnection.connect();
			connectResult.setText("Kết nối database thành công");
		} catch (SQLException e) {
			connectResult.setText("Kết nối database thất bại");
			e.printStackTrace();
		}
        
        //Đọc dữ liệu hóa đơn
        HoaDon_Dao hoaDonDao = new HoaDon_Dao();
        bangHoaDon.CapNhatDuLieu(hoaDonDao.getAllData());
        
        //Phần hoàn thiện trang chủ
        mainPanel.add(connectResult, BorderLayout.NORTH);
        add(mainPanel);
        pack();
        setVisible(true);
    }

    private void setGlobalFont(Font font) {
        java.util.Enumeration keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof javax.swing.plaf.FontUIResource) {
                UIManager.put(key, font);
            }
        }
    }


}
