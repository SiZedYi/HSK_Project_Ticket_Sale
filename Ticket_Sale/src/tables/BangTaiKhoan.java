package tables;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.TaiKhoan_Dao;
import entity.TaiKhoan;

public class BangTaiKhoan extends JTable {
    private DefaultTableModel model;
    private static String[] columnsName = {
            "Mã tài khoản",
            "Tên đăng nhập",
            "Mật khẩu",
            "Mã nhân viên",
            "Quyền",
    };

    public BangTaiKhoan() {
        model = new DefaultTableModel(columnsName, 1);
        setModel(model);

        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    int selectedRow = getSelectedRow();
                    if (selectedRow != -1) {
                        Object maTaiKhoan = model.getValueAt(selectedRow, 0);

                    }
                }
            }
        });
        setFontSize(14);
        setRowHeight(30);
    }

    public void capNhatDuLieu(ArrayList<TaiKhoan> dsTaiKhoan) {
        model.setRowCount(0);
        for (TaiKhoan taiKhoan : dsTaiKhoan) {
            model.addRow(new Object[]{
                    taiKhoan.getMaTK(),
                    taiKhoan.getTenDangNhap(),
                    taiKhoan.getMatKhau(),
                    taiKhoan.getNhanVien() != null ? taiKhoan.getNhanVien().getMaNV() : "",
                    taiKhoan.getQuyen().toString(),
            });
        }
    }

    public void setFontSize(int size) {
        Font font = getFont().deriveFont((float) size);
        setFont(font);
    }

    public void setRowHeight(int height) {
        super.setRowHeight(height);
    }

    public void toDamHang(int index) {
        this.setRowSelectionAllowed(true);
        this.setRowSelectionInterval(index, index);
    }
}
