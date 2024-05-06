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
import dao.TaiKhoan_Dao;
import entity.NhanVien;
import entity.TaiKhoan;
import enums.InputType;
import enums.Quyen;
import tables.BangTaiKhoan;

public class TrangQuanLyTaiKhoan extends JPanel {
    private BangTaiKhoan bangTaiKhoan;
    private InputGroub maTKField, tenDangNhapField, matKhauField, nvField, quyenField, searchField;
    private JButton addButton, editButton, saveButton, deleteButton, findButton, fillButton;
    private boolean isAdding = false;
    private boolean isEditing = false;

    public TrangQuanLyTaiKhoan() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(970, 700));
        setBorder(new EmptyBorder(20, 20, 20, 20));
        // Label
        JLabel label = new JLabel("Danh sách tài khoản", SwingConstants.CENTER);
        label.setPreferredSize(new Dimension(850, 50));
        label.setFont(new Font("Segoe UI", 0, 20));
        add(label, BorderLayout.NORTH);
        
        // Table
        JPanel tablePanel = new JPanel();
        bangTaiKhoan = new BangTaiKhoan();
        JScrollPane paneTaiKhoan = new JScrollPane(bangTaiKhoan);
        paneTaiKhoan.setPreferredSize(new Dimension(850, 250));
        
        
        tablePanel.add(label);
        tablePanel.add(paneTaiKhoan);
        add(tablePanel, BorderLayout.NORTH);

        // Form
        JPanel formPanel = new JPanel();
        formPanel.setPreferredSize(new Dimension(970, 250));
        formPanel.setBackground(Color.WHITE);
        formPanel.setLayout(new GridLayout(0, 1));
        formPanel.setBorder(new EmptyBorder(50, 20, 20, 20));
        
        maTKField = new InputGroub(300, 25, "Mã tài khoản:",20, 200, 25, InputType.STRING);
        tenDangNhapField = new InputGroub(300, 25, "Tên đăng nhập:",20, 200, 25, InputType.STRING);
        matKhauField = new InputGroub(300, 25, "Mật khẩu:",20, 200, 25, InputType.STRING);
        nvField = new InputGroub(300, 25, "Mã nhân viên:",20, 200, 25, InputType.STRING);
        quyenField = new InputGroub(300, 25, "Quyền:",20, 200, 25, InputType.COMBO_BOX, Quyen.values());

        formPanel.add(Box.createHorizontalStrut(5)); 
        formPanel.add(maTKField);
        formPanel.add(tenDangNhapField);
        formPanel.add(matKhauField);
        formPanel.add(nvField);
        formPanel.add(quyenField);
        formPanel.setOpaque(true);
        formPanel.setBackground(new Color(0,0,0,0));
        // Buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));
        addButton = new JButton("Thêm");
        editButton = new JButton("Chỉnh sửa");
        saveButton = new JButton("Lưu");
        deleteButton = new JButton("Xóa");
        findButton = new JButton("Tìm");
        searchField = new InputGroub(250, 25, "Mã cần tìm:",15, 100, 25, InputType.STRING);
        fillButton = new JButton("Fill");
        
        addButton.setMinimumSize(new Dimension(150, 50));

        
        //buttonPanel.add(fillButton);
        add(buttonPanel, BorderLayout.WEST);
        JPanel searchPanel = new JPanel();
        searchPanel.add(searchField);
        searchPanel.add(findButton);
        searchPanel.setPreferredSize(new Dimension(350, 50));
        searchPanel.setBorder(BorderFactory.createTitledBorder("Tìm kiếm: "));
        
        buttonPanel.add(searchPanel);
        buttonsPanel.add(Box.createHorizontalStrut(5));
        buttonsPanel.add(addButton);
        buttonsPanel.add(Box.createHorizontalStrut(5));
        buttonsPanel.add(editButton);
        buttonsPanel.add(Box.createHorizontalStrut(5));
        buttonsPanel.add(saveButton);
        buttonsPanel.add(Box.createHorizontalStrut(5));
        buttonsPanel.add(deleteButton);
        buttonsPanel.add(Box.createHorizontalStrut(5));
        buttonPanel.add(buttonsPanel);
        

        // Add formPanel to main Panel
        add(formPanel, BorderLayout.CENTER);
        
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
                	if(!TaiKhoan_Dao.getInstance().getByAttribute("maTK", maTKField.getText()).isEmpty()) {
                		JOptionPane.showMessageDialog(null, "Mã tài khoản đã tồn tại");
                		return;
                	}
                	if(!TaiKhoan_Dao.getInstance().getByAttribute("tenDangNhap", tenDangNhapField.getText()).isEmpty()) {
                		JOptionPane.showMessageDialog(null, "Tên Đăng Nhập đã tồn tại");
                		return;
                	}
                	if(matKhauField.getText().equals("")) {
                		JOptionPane.showMessageDialog(null, "Mật khẩu không được để trống");
                		return;
                	}
                	if(NhanVien_Dao.getInstance().getByAttribute("maNV", nvField.getText()).isEmpty()) {
                		JOptionPane.showMessageDialog(null, "Không tồn tại nhân viên");
                		return;
                	}
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
    
    private TaiKhoan createTaiKhoanFromFields() {
        TaiKhoan newTaiKhoan = new TaiKhoan(maTKField.getText());
        newTaiKhoan.setTenDangNhap(tenDangNhapField.getText());
        newTaiKhoan.setMatKhau(matKhauField.getText());
        newTaiKhoan.setNhanVien(new NhanVien(nvField.getText()));
        newTaiKhoan.setQuyen((Quyen) quyenField.getSelected());
        System.out.println(newTaiKhoan);
        return newTaiKhoan;
    }

}

