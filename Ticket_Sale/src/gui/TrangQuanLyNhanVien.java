package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import dao.NhanVien_Dao;
import tables.BangNhanVien;

public class TrangQuanLyNhanVien extends JPanel implements ActionListener{
	
	public BangNhanVien bangNhanVien;
	
	public TrangQuanLyNhanVien() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(500,300));
        bangNhanVien= new BangNhanVien();
        add(new JScrollPane(bangNhanVien), BorderLayout.CENTER);
        bangNhanVien.capNhatDuLieu(NhanVien_Dao.getInstance().getAllData());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
