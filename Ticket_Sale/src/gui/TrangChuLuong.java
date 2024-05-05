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
import dao.NhanVien_Dao;
import entity.NhanVien;
import tables.BangHoaDon;

public class TrangChuLuong extends JFrame {

    public TrangChuLuong() {
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
        NhanVien_Dao nhanVienDao = new NhanVien_Dao();
        bangHoaDon.capNhatDuLieu(HoaDon_Dao.getInstance().getAllData());
        
        //Phần hoàn thiện trang chủ
        //mainPanel.add(connectResult, BorderLayout.NORTH);
        NhanVien a = (NhanVien)NhanVien_Dao.getInstance().getAllData().getFirst();
        mainPanel.add(new TrangThongTinCaNhan(a), BorderLayout.SOUTH);
        add(mainPanel);
        //mainPanel.add(new TrangQuanLyNhanVien(), BorderLayout.SOUTH);
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
