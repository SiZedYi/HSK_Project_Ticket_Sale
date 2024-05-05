package gui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entity.NhanVien;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.SimpleDateFormat;

public class TrangThongTinCaNhan extends JPanel {
    private NhanVien nhanVien;

    // Labels
    private JLabel maNVLabel = new JLabel("Mã NV:");
    private JLabel tenNVLabel = new JLabel("Tên NV:");
    private JLabel gioiTinhLabel = new JLabel("Giới tính:");
    private JLabel ngaySinhLabel = new JLabel("Ngày sinh:");
    private JLabel cccdLabel = new JLabel("CCCD:");
    private JLabel noiCuTruLabel = new JLabel("Nơi cư trú:");
    private JLabel sdtLabel = new JLabel("Số điện thoại:");
    private JLabel trinhDoLabel = new JLabel("Trình độ:");
    private JLabel emailLabel = new JLabel("Email:");
    private JLabel ngayTuyenDungLabel = new JLabel("Ngày tuyển dụng:");
    private JLabel luongLabel = new JLabel("Lương:");
    private JLabel quanLyLabel = new JLabel("Quản lý:");

    // Text Fields
    private JTextField maNVField = new JTextField(20);
    private JTextField tenNVField = new JTextField(20);
    private JTextField gioiTinhField = new JTextField(20);
    private JTextField ngaySinhField = new JTextField(20);
    private JTextField cccdField = new JTextField(20);
    private JTextField noiCuTruField = new JTextField(20);
    private JTextField sdtField = new JTextField(20);
    private JTextField trinhDoField = new JTextField(20);
    private JTextField emailField = new JTextField(20);
    private JTextField ngayTuyenDungField = new JTextField(20);
    private JTextField luongField = new JTextField(20);
    private JTextField quanLyField = new JTextField(20);

    public TrangThongTinCaNhan(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
        setupUI();
        displayNhanVienInfo();
    }

    private void setupUI() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        addLabelAndField(maNVLabel, maNVField, gbc);
        addLabelAndField(tenNVLabel, tenNVField, gbc);
        addLabelAndField(gioiTinhLabel, gioiTinhField, gbc);
        addLabelAndField(ngaySinhLabel, ngaySinhField, gbc);
        addLabelAndField(cccdLabel, cccdField, gbc);
        addLabelAndField(noiCuTruLabel, noiCuTruField, gbc);
        addLabelAndField(sdtLabel, sdtField, gbc);
        addLabelAndField(trinhDoLabel, trinhDoField, gbc);
        addLabelAndField(emailLabel, emailField, gbc);
        addLabelAndField(ngayTuyenDungLabel, ngayTuyenDungField, gbc);
        addLabelAndField(luongLabel, luongField, gbc);
        addLabelAndField(quanLyLabel, quanLyField, gbc);
    }

    private void addLabelAndField(JLabel label, JTextField textField, GridBagConstraints gbc) {
        gbc.gridx = 0;
        this.add(label, gbc);
        gbc.gridx = 1;
        this.add(textField, gbc);
        gbc.gridy++;
    }

    private void displayNhanVienInfo() {
        maNVField.setText(nhanVien.getMaNV());
        tenNVField.setText(nhanVien.getTenNV());
        gioiTinhField.setText(nhanVien.getGioiTinh().toString());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        ngaySinhField.setText(dateFormat.format(nhanVien.getNgaySinh()));
        cccdField.setText(nhanVien.getCccd());
        noiCuTruField.setText(nhanVien.getNoiCuTru());
        sdtField.setText(nhanVien.getSdt());
        trinhDoField.setText(nhanVien.getTrinhDo());
        emailField.setText(nhanVien.getEmail());
        ngayTuyenDungField.setText(dateFormat.format(nhanVien.getNgayTuyenDung()));
        luongField.setText(String.valueOf(nhanVien.getLuong()));
        quanLyField.setText(nhanVien.getQuanLy() != null ? nhanVien.getQuanLy().getTenNV() : "");
    }
}
