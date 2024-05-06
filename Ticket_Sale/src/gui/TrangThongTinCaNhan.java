package gui;
import javax.swing.*;

import dao.NhanVien_Dao;
import dao.TaiKhoan_Dao;
import entity.NhanVien;
import entity.TaiKhoan;
import enums.InputType;

import java.awt.*;
import java.text.SimpleDateFormat;

public class TrangThongTinCaNhan extends JPanel {
    private NhanVien nhanVien;

    // InputGroubs
    private InputGroub maNVGroup = new InputGroub(500, 40, "Mã NV:", 16, 200, 30, InputType.STRING);
    private InputGroub tenNVGroup = new InputGroub(500, 40, "Tên NV:", 16, 200, 30, InputType.STRING);
    private InputGroub gioiTinhGroup = new InputGroub(500, 40, "Giới tính:", 16, 200, 30, InputType.STRING);
    private InputGroub ngaySinhGroup = new InputGroub(500, 40, "Ngày sinh:", 16, 200, 30, InputType.DATE);
    private InputGroub cccdGroup = new InputGroub(500, 40, "CCCD:", 16, 200, 30, InputType.STRING);
    private InputGroub noiCuTruGroup = new InputGroub(500, 40, "Nơi cư trú:", 16, 200, 30, InputType.STRING);
    private InputGroub sdtGroup = new InputGroub(500, 40, "Số điện thoại:", 16, 200, 30, InputType.STRING);
    private InputGroub trinhDoGroup = new InputGroub(500, 40, "Trình độ:", 16, 200, 30, InputType.STRING);
    private InputGroub emailGroup = new InputGroub(500, 40, "Email:", 16, 200, 30, InputType.STRING);
    private InputGroub ngayTuyenDungGroup = new InputGroub(500, 40, "Ngày tuyển dụng:", 16, 200, 30, InputType.DATE);
    private InputGroub luongGroup = new InputGroub(500, 40, "Lương:", 16, 200, 30, InputType.STRING);
    private InputGroub quanLyGroup = new InputGroub(500, 40, "Quản lý:", 16, 200, 30, InputType.STRING);

    public TrangThongTinCaNhan() {
        TaiKhoan tk = (TaiKhoan) TaiKhoan_Dao.getInstance().getByAttribute("tenDangNhap", LoginManager.currentUser).getFirst();
        this.nhanVien = (NhanVien) NhanVien_Dao.getInstance().getByAttribute("maNV", tk.getNhanVien().getMaNV()).getFirst();
        setupUI();
        displayNhanVienInfo();
    }

    private void setupUI() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel titleLabel = new JLabel("Thông tin cá nhân của tôi:");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18)); 
        add(titleLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(0, 1, 0, 10)); 
        add(inputPanel, BorderLayout.CENTER);

        inputPanel.add(maNVGroup);
        inputPanel.add(tenNVGroup);
        inputPanel.add(gioiTinhGroup);
        inputPanel.add(ngaySinhGroup);
        inputPanel.add(cccdGroup);
        inputPanel.add(noiCuTruGroup);
        inputPanel.add(sdtGroup);
        inputPanel.add(trinhDoGroup);
        inputPanel.add(emailGroup);
        inputPanel.add(ngayTuyenDungGroup);
        inputPanel.add(luongGroup);
        inputPanel.add(quanLyGroup);
    }

    private void displayNhanVienInfo() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        maNVGroup.setText(nhanVien.getMaNV());
        tenNVGroup.setText(nhanVien.getTenNV());
        gioiTinhGroup.setText(nhanVien.getGioiTinh().toString());
        ngaySinhGroup.setDate(nhanVien.getNgaySinh());
        cccdGroup.setText(nhanVien.getCccd());
        noiCuTruGroup.setText(nhanVien.getNoiCuTru());
        sdtGroup.setText(nhanVien.getSdt());
        trinhDoGroup.setText(nhanVien.getTrinhDo());
        emailGroup.setText(nhanVien.getEmail());
        ngayTuyenDungGroup.setDate(nhanVien.getNgayTuyenDung());
        luongGroup.setText(String.valueOf(nhanVien.getLuong()));
        quanLyGroup.setText(nhanVien.getQuanLy() != null ? nhanVien.getQuanLy().getTenNV() : "");

        maNVGroup.setEditable(false);
        tenNVGroup.setEditable(false);
        gioiTinhGroup.setEditable(false);
        ngaySinhGroup.setEditable(false);
        cccdGroup.setEditable(false);
        noiCuTruGroup.setEditable(false);
        sdtGroup.setEditable(false);
        trinhDoGroup.setEditable(false);
        emailGroup.setEditable(false);
        ngayTuyenDungGroup.setEditable(false);
        luongGroup.setEditable(false);
        quanLyGroup.setEditable(false);
    }
}
