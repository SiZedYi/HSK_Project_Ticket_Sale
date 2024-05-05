package tables;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.NhanVien_Dao;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import entity.HoaDon;
import entity.NhanVien;

public class BangNhanVien extends JTable{
	private DefaultTableModel model;
    private static String[] columnsName = {
            "Mã nhân viên",
            "Tên nhân viên",
            "Giới tính",
            "Số điện thoại",
            "Email",
    };

    public BangNhanVien() {
        model = new DefaultTableModel(columnsName, 1);
        setModel(model);
        
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    int selectedRow = getSelectedRow();
                    if (selectedRow != -1) {
                        Object maNhanVien = model.getValueAt(selectedRow, 0);
                        System.out.println(NhanVien_Dao.getInstance().getByAttribute("maNV", (String)maNhanVien).toString());
                    }
                }
            }
        });
    }

    public void capNhatDuLieu(ArrayList<NhanVien> dsNhanVien) {
        model.setRowCount(0);
        for (NhanVien nhanVien : dsNhanVien) {
            model.addRow(new Object[]{
                    nhanVien.getMaNV(),
                    nhanVien.getTenNV(),
                    nhanVien.getGioiTinh(),
                    nhanVien.getSdt(),
                    nhanVien.getEmail()
            });
        }
    }

    public void toDamHang(int index) {
        this.setRowSelectionAllowed(true);
        this.setRowSelectionInterval(index, index);
    }
}	
