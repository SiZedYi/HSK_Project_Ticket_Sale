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
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import dao.TaiKhoan_Dao;
import entity.TaiKhoan;
import enums.Quyen;
import tables.BangTaiKhoan;

public class TrangQuanLyTaiKhoan extends JPanel {
    private BangTaiKhoan bangTaiKhoan;
    private InputTextField maTKField, tenDangNhapField, matKhauField, nvField, quyenField, searchField;
    private JButton addButton, editButton, saveButton, deleteButton, findButton, fillButton;
    private boolean isAdding = false;
    private boolean isEditing = false;

    public TrangQuanLyTaiKhoan() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(970, 700));

        // Label
        JLabel label = new JLabel("Danh sách tài khoản", SwingConstants.CENTER);
        label.setPreferredSize(new Dimension(970, 50));
        label.setFont(new Font("Segoe UI", 0, 20));
        add(label, BorderLayout.NORTH);

        // Table
        bangTaiKhoan = new BangTaiKhoan();
        JScrollPane paneTaiKhoan = new JScrollPane(bangTaiKhoan);
        paneTaiKhoan.setPreferredSize(new Dimension(970, 250));
        add(paneTaiKhoan, BorderLayout.CENTER);

        // Form
        JPanel formPanel = new JPanel();
        formPanel.setPreferredSize(new Dimension(970, 400));
        formPanel.setBackground(Color.WHITE);
        formPanel.setLayout(new GridLayout(0, 2));
        
        maTKField = new InputTextField(300, 25, "Mã tài khoản:", 200, 25);
        tenDangNhapField = new InputTextField(300, 25, "Tên đăng nhập:", 200, 25);
        matKhauField = new InputTextField(300, 25, "Mật khẩu:", 200, 25);
        nvField = new InputTextField(300, 25, "Mã nhân viên:", 200, 25);
        quyenField = new InputTextField(300, 25, "Quyền:", 200, 25);

        formPanel.add(maTKField);
        formPanel.add(tenDangNhapField);
        formPanel.add(matKhauField);
        formPanel.add(nvField);
        formPanel.add(quyenField);

        // Buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        addButton = new JButton("Thêm");
        editButton = new JButton("Chỉnh sửa");
        saveButton = new JButton("Lưu");
        deleteButton = new JButton("Xóa");
        findButton = new JButton("Tìm");
        searchField = new InputTextField(100, 25, "Mã cần tìm", 50, 25);
        fillButton = new JButton("Fill");

        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(findButton);
        buttonPanel.add(searchField);
        buttonPanel.add(fillButton);
        add(buttonPanel, BorderLayout.EAST);

        // Add formPanel to main Panel
        add(formPanel, BorderLayout.SOUTH);
        
        // Cap nhat du lieu
        bangTaiKhoan.capNhatDuLieu(TaiKhoan_Dao.getInstance().getAllData());

        bangTaiKhoan.addMouseListener(new MouseAdapter() {
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
                maTKField.setEditable(false);
            }
        });

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isEditing) {
                	TaiKhoan newTaiKhoan = createTaiKhoanFromFields();
                    TaiKhoan_Dao.getInstance().update(newTaiKhoan);
                    
                } else if (isAdding) {
                    TaiKhoan newTaiKhoan = createTaiKhoanFromFields();
                    TaiKhoan_Dao.getInstance().create(newTaiKhoan);
                }
                isEditing = false;
                isAdding = false;
                setEditable(false);
                bangTaiKhoan.capNhatDuLieu(TaiKhoan_Dao.getInstance().getAllData());
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 TaiKhoan_Dao.getInstance().delete(maTKField.getText());
                bangTaiKhoan.capNhatDuLieu(TaiKhoan_Dao.getInstance().getAllData());
            }
        });
        
        findButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	ArrayList<TaiKhoan> dsTK = TaiKhoan_Dao.getInstance().getByAttribute("maTK", searchField.getText());
            	if(dsTK.size() == 0) {
            		JOptionPane.showMessageDialog(null, "Không tìm thấy");
            	}
            	else if(dsTK.size() == 1) {
            		hienThiThongTin(dsTK.getFirst());
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
        int selectedRow = bangTaiKhoan.getSelectedRow();
        if (selectedRow != -1) {
            String maTaiKhoan = (String) bangTaiKhoan.getValueAt(selectedRow, 0);
            ArrayList<TaiKhoan> dsTaiKhoan = TaiKhoan_Dao.getInstance().getByAttribute("maTK", maTaiKhoan);
            hienThiThongTin(dsTaiKhoan.get(0));
        }
    }

    private void hienThiThongTin(TaiKhoan taiKhoan) {
        if (taiKhoan != null) {
            maTKField.setText(taiKhoan.getMaTK());
            tenDangNhapField.setText(taiKhoan.getTenDangNhap());
            matKhauField.setText(taiKhoan.getMatKhau());
            nvField.setText(taiKhoan.getNhanVien().getMaNV());
            quyenField.setText(taiKhoan.getQuyen().toString());
        }
    }

    private void clearForm() {
        maTKField.setText("");
        tenDangNhapField.setText("");
        matKhauField.setText("");
        nvField.setText("");
        quyenField.setText("");
    }

    private void setEditable(boolean editable) {
        maTKField.setEditable(editable);
        tenDangNhapField.setEditable(editable);
        matKhauField.setEditable(editable);
        nvField.setEditable(editable);
        quyenField.setEditable(editable);
    }
    
    // Method to create a TaiKhoan object from input fields
    private TaiKhoan createTaiKhoanFromFields() {
        TaiKhoan newTaiKhoan = new TaiKhoan(maTKField.getText());
        newTaiKhoan.setTenDangNhap(tenDangNhapField.getText());
        newTaiKhoan.setMatKhau(matKhauField.getText());
//        NhanVien nhanVien = NhanVien_Dao.getInstance().getNhanVienByMaNV(nvField.getText());
//        if (nhanVien != null) {
//            newTaiKhoan.setNhanVien(nhanVien);
//        } else {
//            JOptionPane.showMessageDialog(null, "Mã nhân viên không tồn tại!");
//        }
//        // Set Quyen (assuming you have a way to get the selected Quyen)
//        newTaiKhoan.setQuyen(getQuyenFromInput());
        return null;
    }

    private void autoFill() {
//        maTKField.setText(Date.valueOf(LocalDate.now()).toString());
//        tenDangNhapField.setText("user1");
//        matKhauField.setText("password");
//        nvField.setText("NV001"); // Replace with a valid NV maNV
//        quyenField.setText("ADMIN"); // Replace with actual Quyen
    }
}

