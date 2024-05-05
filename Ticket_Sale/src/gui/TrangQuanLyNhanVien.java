package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import dao.NhanVien_Dao;
import entity.NhanVien;
import enums.GioiTinh;
import enums.InputType;
import tables.BangNhanVien;

public class TrangQuanLyNhanVien extends JPanel {
    private BangNhanVien bangNhanVien;
    private InputGroub maNVField, tenNVField, gioiTinhField, ngaySinhField, cccdField, noiCuTruField,
            sdtField, trinhDoField, emailField, ngayTuyenDungField, luongField, quanLyField, searchField;
    private JButton addButton, editButton, saveButton, deleteButton, findButton, fillButton;
    private boolean isAdding = false;
    private boolean isEditing = false;

    public TrangQuanLyNhanVien() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(970, 700));

        // Label
        JLabel label = new JLabel("Danh sách nhân viên", SwingConstants.CENTER);
        label.setPreferredSize(new Dimension(970, 50));
        label.setFont(new Font("Segoe UI", 0, 20));
        add(label, BorderLayout.NORTH);

        // Table
        bangNhanVien = new BangNhanVien();
        JScrollPane paneNhanVien = new JScrollPane(bangNhanVien);
        paneNhanVien.setPreferredSize(new Dimension(970, 250));
        add(paneNhanVien, BorderLayout.CENTER);

        // Form
        JPanel formPanel = new JPanel();
        formPanel.setPreferredSize(new Dimension(970, 400));
        formPanel.setBackground(Color.WHITE);
        formPanel.setLayout(new GridLayout(0, 2));
        
        maNVField = new InputGroub(300, 25, "Mã nhân viên:",20, 200, 25, InputType.STRING);
        tenNVField = new InputGroub(300, 25, "Tên nhân viên:",20, 200, 25, InputType.STRING);
        gioiTinhField = new InputGroub(300, 25, "Giới tính:",20, 200, 25, InputType.STRING);
        ngaySinhField = new InputGroub(300, 25, "Ngày sinh:", 20, 200, 25, InputType.DATE);
        cccdField = new InputGroub(300, 25, "CCCD:",20, 200, 25, InputType.STRING);
        noiCuTruField = new InputGroub(300, 25, "Nơi cư trú:",20, 200, 25, InputType.STRING);
        sdtField = new InputGroub(300, 25, "Số điện thoại:",20, 200, 25, InputType.STRING);
        trinhDoField = new InputGroub(300, 25, "Trình độ:",20, 200, 25, InputType.STRING);
        emailField = new InputGroub(300, 25, "Email:",20, 200, 25, InputType.STRING);
        ngayTuyenDungField = new InputGroub(300, 25, "Ngày tuyển dụng:",20, 200, 25, InputType.DATE);
        luongField = new InputGroub(300, 25, "Lương:",20, 200, 25, InputType.STRING);
        quanLyField = new InputGroub(300, 25, "Quản lý:",20, 200, 25, InputType.STRING);

        formPanel.add(maNVField);
        formPanel.add(tenNVField);
        formPanel.add(gioiTinhField);
        formPanel.add(ngaySinhField);
        formPanel.add(cccdField);
        formPanel.add(noiCuTruField);
        formPanel.add(sdtField);
        formPanel.add(trinhDoField);
        formPanel.add(emailField);
        formPanel.add(ngayTuyenDungField);
        formPanel.add(luongField);
        formPanel.add(quanLyField);

        // Buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        addButton = new JButton("Thêm");
        editButton = new JButton("Chỉnh sửa");
        saveButton = new JButton("Lưu");
        deleteButton = new JButton("Xóa");
        findButton = new JButton("Tìm");
        searchField = new InputGroub(100, 25, "Mã cần tìm",20, 200, 25, InputType.STRING);
        fillButton = new JButton("Fill");

        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(findButton);
        buttonPanel.add(searchField);
        buttonPanel.add(fillButton);
        add(buttonPanel, BorderLayout.EAST);

        
        //Add formPanel to main Panel
        add(formPanel, BorderLayout.SOUTH);
        
        // Cap nhat du lieu
        bangNhanVien.capNhatDuLieu(NhanVien_Dao.getInstance().getAllData());

        bangNhanVien.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                capNhatForm();
            }
        });
        
        //set editable
        setEditable(false);
        
        
        //Buttons Handle

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                isAdding = true;
                clearForm();
                setEditable(true);
            }
        });

        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                isEditing = true;
                setEditable(true);
                maNVField.setEditable(false);
            }
        });

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isEditing) {
                	NhanVien newNhanVien = createNhanVienFromFields();
                    NhanVien_Dao.getInstance().update(newNhanVien);
                    
                } else if (isAdding) {
                    NhanVien newNhanVien = createNhanVienFromFields();
                    NhanVien_Dao.getInstance().create(newNhanVien);
                }
                isEditing = false;
                isAdding = false;
                setEditable(false);
                bangNhanVien.capNhatDuLieu(NhanVien_Dao.getInstance().getAllData());
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 NhanVien_Dao.getInstance().delete(maNVField.getText());
                bangNhanVien.capNhatDuLieu(NhanVien_Dao.getInstance().getAllData());
            }
        });
        
        findButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	ArrayList<NhanVien> dsNV = NhanVien_Dao.getInstance().getByAttribute("maNV", searchField.getText());
            	if(dsNV.size() == 0) {
            		JOptionPane.showMessageDialog(null, "Không tìm thấy");
            	}
            	else if(dsNV.size() == 1) {
            		hienThiThongTin(dsNV.getFirst());
            	}
            	else {
            		JOptionPane.showMessageDialog(null, "Dữ liệu có vấn đề!!!");
            	}
            }
        });
        
        fillButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                autoFill();
            }
        });
    }

    public void capNhatForm() {
        int selectedRow = bangNhanVien.getSelectedRow();
        if (selectedRow != -1) {
            String maNhanVien = (String) bangNhanVien.getValueAt(selectedRow, 0);
            ArrayList<NhanVien> dsNhanVien = NhanVien_Dao.getInstance().getByAttribute("maNV", maNhanVien);
            hienThiThongTin(dsNhanVien.get(0));
        }
    }

    private void hienThiThongTin(NhanVien nhanVien) {
        if (nhanVien != null) {
            maNVField.setText(nhanVien.getMaNV());
            tenNVField.setText(nhanVien.getTenNV());
            gioiTinhField.setText(nhanVien.getGioiTinh().toString());
            ngaySinhField.setDate(nhanVien.getNgaySinh());
            cccdField.setText(nhanVien.getCccd());
            noiCuTruField.setText(nhanVien.getNoiCuTru());
            sdtField.setText(nhanVien.getSdt());
            trinhDoField.setText(nhanVien.getTrinhDo());
            emailField.setText(nhanVien.getEmail());
            ngayTuyenDungField.setText(nhanVien.getNgayTuyenDung().toString());
            luongField.setText(String.valueOf(nhanVien.getLuong()));
            quanLyField.setText(nhanVien.getQuanLy() != null ? nhanVien.getQuanLy().getTenNV() : "");
        }
    }

    private void clearForm() {
        maNVField.setText("");
        tenNVField.setText("");
        gioiTinhField.setText("");
        ngaySinhField.setDate(Date.valueOf("1950-01-01"));
        cccdField.setText("");
        noiCuTruField.setText("");
        sdtField.setText("");
        trinhDoField.setText("");
        emailField.setText("");
        ngayTuyenDungField.setDate(Date.valueOf("1950-01-01"));
        luongField.setText("");
        quanLyField.setText("");
    }

    private void setEditable(boolean editable) {
        maNVField.setEditable(editable);
        tenNVField.setEditable(editable);
        gioiTinhField.setEditable(editable);
        ngaySinhField.setEditable(editable);
        cccdField.setEditable(editable);
        noiCuTruField.setEditable(editable);
        sdtField.setEditable(editable);
        trinhDoField.setEditable(editable);
        emailField.setEditable(editable);
        ngayTuyenDungField.setEditable(editable);
        luongField.setEditable(editable);
        quanLyField.setEditable(editable);
    }
    
    private NhanVien createNhanVienFromFields() {
    	NhanVien newNhanVien = new NhanVien(maNVField.getText());
       
        double luong = 0;
        try {
        	luong = Double.parseDouble(luongField.getText());
        }catch(Exception e){
        	JOptionPane.showMessageDialog(null,"Lương phải là số thập phân");
        }

        newNhanVien.setTenNV(tenNVField.getText());
        newNhanVien.setNgaySinh(ngaySinhField.getDate());
        newNhanVien.setGioiTinh(GioiTinh.stringToPhuongThucGioiTinh(gioiTinhField.getText()));
        newNhanVien.setCccd(cccdField.getText());
        newNhanVien.setNoiCuTru(noiCuTruField.getText());
        newNhanVien.setSdt(sdtField.getText());
        newNhanVien.setTrinhDo(trinhDoField.getText());
        newNhanVien.setEmail(emailField.getText());
        newNhanVien.setNgayTuyenDung(ngayTuyenDungField.getDate());
        newNhanVien.setLuong(luong);
        newNhanVien.setQuanLy(new NhanVien(quanLyField.getText()));
        return newNhanVien;
    }

    private void autoFill() {
        maNVField.setText(Date.valueOf(LocalDate.now()).toString());
        tenNVField.setText("Lê Văn A");
        gioiTinhField.setText("Nam");
        ngaySinhField.setDate(Date.valueOf("1950-01-01"));
        cccdField.setText("fasa");
        noiCuTruField.setText("afaaa");
        sdtField.setText("030303");
        trinhDoField.setText("faf");
        emailField.setText("aaa@gmail.com");
        ngayTuyenDungField.setDate(Date.valueOf("1950-01-01"));
        luongField.setText("2330.0");
        quanLyField.setText("NV001");
    }
}
