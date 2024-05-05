package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

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
        setPreferredSize(new Dimension(950, 700));
        setBorder(new EmptyBorder(0, 20, 20, 20));
        // Label
        JLabel label = new JLabel("Danh sách nhân viên", SwingConstants.CENTER);
        label.setPreferredSize(new Dimension(970, 50));
        label.setFont(new Font("Segoe UI", 0, 20));
        add(label, BorderLayout.NORTH);

        // Table
        bangNhanVien = new BangNhanVien();
        JScrollPane paneNhanVien = new JScrollPane(bangNhanVien);
        paneNhanVien.setPreferredSize(new Dimension(900, 250));
        add(paneNhanVien, BorderLayout.CENTER);
        
        // Form
        JPanel formPanel = new JPanel();
        formPanel.setPreferredSize(new Dimension(900, 350));
        formPanel.setBackground(Color.WHITE);
        formPanel.setBorder(BorderFactory.createTitledBorder("Thông tin nhân viên"));
        ((javax.swing.border.TitledBorder)formPanel.getBorder()).setTitleFont(new Font("Segoe UI", 0, 20));
        formPanel.setOpaque(true);
        formPanel.setBackground(new Color(0,0,0,0));
        formPanel.setLayout(new GridLayout(0, 2));
        
        

        maNVField = new InputGroub(300, 25, "Mã nhân viên:",20, 200, 25, InputType.STRING);
        tenNVField = new InputGroub(300, 25, "Tên nhân viên:",20, 200, 25, InputType.STRING);
        gioiTinhField = new InputGroub(300, 25, "Giới tính:",20, 200, 25, InputType.COMBO_BOX, GioiTinh.values());
        ngaySinhField = new InputGroub(300, 25, "Ngày sinh:", 20, 200-5, 25, InputType.DATE);
        cccdField = new InputGroub(300, 25, "CCCD:",20, 200, 25, InputType.STRING);
        noiCuTruField = new InputGroub(500, 25, "Nơi cư trú:",20, 200, 25, InputType.STRING);
        sdtField = new InputGroub(300, 25, "Số điện thoại:",20, 200, 25, InputType.STRING);
        trinhDoField = new InputGroub(300, 25, "Trình độ:",20, 200, 25, InputType.STRING);
        emailField = new InputGroub(300, 25, "Email:",20, 200, 25, InputType.STRING);
        ngayTuyenDungField = new InputGroub(300, 25, "Ngày tuyển dụng:",20, 200-5, 25, InputType.DATE);
        luongField = new InputGroub(300, 25, "Lương:",20, 200, 25, InputType.STRING);
        quanLyField = new InputGroub(300, 25, "Quản lý:",20, 200, 25, InputType.COMBO_BOX, danhSachQuanLy(NhanVien_Dao.getInstance().getAllData()));

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
        
        //Infor
        JPanel inforPanel = new JPanel();
        inforPanel.setPreferredSize(new Dimension(900, 450));
        
        findButton = new JButton("Tìm");
        searchField = new InputGroub(400, 25, "Mã nhân viên cần tìm:",18, 200, 25, InputType.STRING);
        
        inforPanel.add(searchField);
        inforPanel.add(findButton);
        inforPanel.add(formPanel);
        
        // Buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout( new java.awt.GridLayout( 0,1 ) );
        buttonPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        addButton = new JButton("Thêm"); 
        editButton = new JButton("Chỉnh sửa");
        saveButton = new JButton("Lưu");
        deleteButton = new JButton("Xóa");
        fillButton = new JButton("Fill");

        buttonPanel.add( addButton);
        buttonPanel.add(Box.createHorizontalStrut(5));
        buttonPanel.add(editButton);
        buttonPanel.add(Box.createHorizontalStrut(5));
        buttonPanel.add(saveButton);
        buttonPanel.add(Box.createHorizontalStrut(5));
        buttonPanel.add(deleteButton);
        buttonPanel.add(Box.createHorizontalStrut(5));
        buttonPanel.add(fillButton);
        add(buttonPanel, BorderLayout.EAST);

        
        //Add inforPanel to main Panel
        add(inforPanel, BorderLayout.SOUTH);
        
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
                	if(!NhanVien_Dao.getInstance().getByAttribute("maNV", maNVField.getText()).isEmpty()) {
                		JOptionPane.showMessageDialog(null, "Mã đã tồn tại");
                		return;
                	}
                    NhanVien newNhanVien = createNhanVienFromFields();
                    NhanVien_Dao.getInstance().create(newNhanVien);
                }
                isEditing = false;
                isAdding = false;
                setEditable(false);
                bangNhanVien.capNhatDuLieu(NhanVien_Dao.getInstance().getAllData());
                quanLyField.updateComboBox(danhSachQuanLy(NhanVien_Dao.getInstance().getAllData()));
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 NhanVien_Dao.getInstance().delete(maNVField.getText());
                bangNhanVien.capNhatDuLieu(NhanVien_Dao.getInstance().getAllData());
                quanLyField.updateComboBox(danhSachQuanLy(NhanVien_Dao.getInstance().getAllData()));
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
            gioiTinhField.setSelected(nhanVien.getGioiTinh());
            ngaySinhField.setDate(nhanVien.getNgaySinh());
            cccdField.setText(nhanVien.getCccd());
            noiCuTruField.setText(nhanVien.getNoiCuTru());
            sdtField.setText(nhanVien.getSdt());
            trinhDoField.setText(nhanVien.getTrinhDo());
            emailField.setText(nhanVien.getEmail());
            ngayTuyenDungField.setDate(nhanVien.getNgayTuyenDung());
            luongField.setText(String.valueOf(nhanVien.getLuong()));
            ArrayList<NhanVien> ql = NhanVien_Dao.getInstance().getByAttribute("maNV", nhanVien.getQuanLy().getMaNV());
            System.out.println(danhSachQuanLy(ql)[0]);
            quanLyField.setSelected(danhSachQuanLy(ql)[0]);
            
        }
    }

    private void clearForm() {
        maNVField.setText("");
        tenNVField.setText("");
        gioiTinhField.setSelected(GioiTinh.NAM);
        ngaySinhField.setDate(Date.valueOf("1950-01-01"));
        cccdField.setText("");
        noiCuTruField.setText("");
        sdtField.setText("");
        trinhDoField.setText("");
        emailField.setText("");
        ngayTuyenDungField.setDate(Date.valueOf("1950-01-01"));
        luongField.setText("");
        //quanLyField.setText("");
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
        if(!sdtField.getText().matches("^(\\+?\\d{2}|0)\\d{9}$")) {
        	JOptionPane.showMessageDialog(null,"Số điện thoại không hợp lệ");
        	return null;
        }
        
        if(!emailField.getText().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")){
        	JOptionPane.showMessageDialog(null,"Email không hợp lệ");
        	return null;
        }
        newNhanVien.setTenNV(tenNVField.getText());
        newNhanVien.setNgaySinh(ngaySinhField.getDate());
        newNhanVien.setGioiTinh((GioiTinh)gioiTinhField.getSelected());
        newNhanVien.setCccd(cccdField.getText());
        newNhanVien.setNoiCuTru(noiCuTruField.getText());
        newNhanVien.setSdt(sdtField.getText());
        newNhanVien.setTrinhDo(trinhDoField.getText());
        newNhanVien.setEmail(emailField.getText());
        newNhanVien.setNgayTuyenDung(ngayTuyenDungField.getDate());
        newNhanVien.setLuong(luong);
        newNhanVien.setQuanLy(new NhanVien(tachMa((String) quanLyField.getSelected())));
        return newNhanVien;
    }

    private void autoFill() {
        maNVField.setText(Date.valueOf(LocalDate.now()).toString());
        tenNVField.setText("Lê Văn A");
        ngaySinhField.setDate(Date.valueOf("1950-01-01"));
        cccdField.setText("fasa");
        noiCuTruField.setText("afaaa");
        sdtField.setText("030303");
        trinhDoField.setText("faf");
        emailField.setText("aaa@gmail.com");
        ngayTuyenDungField.setDate(Date.valueOf("1950-01-01"));
        luongField.setText("2330.0");
    }
    
    public String[] danhSachQuanLy(ArrayList<NhanVien> listQuanLy) {
    	String[] dsQuanLy = new String[listQuanLy.size()];
    	for(int i = 0; i < dsQuanLy.length; i++) {
    		dsQuanLy[i] = listQuanLy.get(i).getTenNV() + " | Mã NV: " + listQuanLy.get(i).getMaNV();
    	}
    	return dsQuanLy;
    }
    
    public static String tachMa(String chuoiHop) {
    	String[] parts = chuoiHop.split("\\| Mã NV: "); 
    	return parts[1].trim();
    }
}
