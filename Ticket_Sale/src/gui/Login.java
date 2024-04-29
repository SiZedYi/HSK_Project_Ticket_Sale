package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dao.NhanVien_DAO;
import entity.NhanVien;

public class Login extends JFrame implements ActionListener, MouseListener {
	    private JPasswordField txt_password;
	    private JLabel lbl_hiddenicon;
		private JButton btnLogin;
    

//    public static NhanVien nhanVien = null;
//    private NhanVienDAO nv_DAO = new NhanVienDAO();
    
   


	public Login() {
//        KetNoiSQL.getInstance().connect();
        
        initComponents();
        
        

    }


    private void initComponents() {

        setTitle("Nhóm 3 con báo");
		setSize(800,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);// cửa sổ xuất hiện ở trung tâm 
		setResizable(false);
		
		
		//lefl
		JPanel pleft = new JPanel();
		pleft.setBackground(new Color(212,66,51));
		
		//right
		JPanel pright = new JPanel();
		JPanel pLogin = new JPanel();

		//banner
		ImageIcon icon = new ImageIcon("data/Image/login2.jpg");// 
		Image image = icon.getImage();//Lấy hình ảnh từ ImageIcon
		Image resizedImage = image.getScaledInstance(300, 450, Image.SCALE_SMOOTH);
		ImageIcon resizedIcon = new ImageIcon(resizedImage);
		JLabel banner = new JLabel(resizedIcon);
        pleft.add(banner );
        add(pleft,BorderLayout.WEST);
        
       
        
        //login
        pright.setBackground(new Color(212,66,51));
        pright.setBorder(new EmptyBorder(20,0,0,0));
        pLogin.setBackground(new Color(247,210,158));
        pLogin.setLayout(new BoxLayout(pLogin, BoxLayout.Y_AXIS));
       //pLogin.setPreferredSize(new Dimension(400,420));
        
        //title:Login
        JPanel pTitle = new JPanel();
        pTitle.setBackground(new Color(247,210,158));
		pTitle.setLayout(new FlowLayout(FlowLayout.LEFT));
		pTitle.setBorder(BorderFactory.createEmptyBorder(20,20,50,0));// top left bottom right
		JLabel lblNorth = new JLabel("LOGIN");
		lblNorth.setFont(new Font("Dosis", Font.BOLD, 28));
		lblNorth.setForeground(Color.WHITE);
		pTitle.add(lblNorth);
		
		
		
		//pInput
		JPanel pInput = new JPanel();
		pInput.setLayout(new BoxLayout(pInput, BoxLayout.Y_AXIS));
        
        //username
        JPanel pusn = new JPanel();
        pusn.setLayout(new BoxLayout(pusn, BoxLayout.Y_AXIS));
        pusn.setBackground(new Color(247,210,158));
        pusn.setBorder(BorderFactory.createEmptyBorder(5, 5, 15, 5));
        
        
        JLabel lbl_username = new JLabel("USERNAME");
        lbl_username.setPreferredSize(new Dimension(0, 30));
        JPanel ptxtn = new JPanel();
        ptxtn.setLayout(new BoxLayout(ptxtn, BoxLayout.X_AXIS));
        JTextField txt_username =  new JTextField(30);
        txt_username.setBorder(BorderFactory.createEmptyBorder(15, 5, 5, 5));
        JLabel lbl_usericon= new JLabel(new ImageIcon("src/icon/userLogin.png"));
        
        ptxtn.add(txt_username);
        ptxtn.add(lbl_usericon);
        pusn.add(lbl_username);
        pusn.add(ptxtn);
       
     
        //password
        JPanel ppw = new JPanel();
        ppw.setBackground(new Color(247,210,158));
        ppw.setLayout(new BoxLayout(ppw, BoxLayout.Y_AXIS));
        ppw.setBorder(BorderFactory.createEmptyBorder(5, 5, 15, 5));
        
       
        JLabel lbl_password = new JLabel("PASSWORD");
        
        lbl_password.setPreferredSize(new Dimension(0, 30));
        
        JPanel ptxtpw = new JPanel();
        ptxtpw.setLayout(new BoxLayout(ptxtpw, BoxLayout.X_AXIS));
        txt_password =new JPasswordField(30);
        txt_password.setEchoChar('*');
        txt_password.setBorder(BorderFactory.createEmptyBorder(15, 5, 5, 5));
        
        lbl_hiddenicon= new JLabel(new ImageIcon("src/icon/hide-password.png"));
        lbl_hiddenicon.setCursor(new Cursor(Cursor.HAND_CURSOR));
       
        ptxtpw.add(txt_password);
        ptxtpw.add(lbl_hiddenicon);
        ppw.add(lbl_password);
        ppw.add(ptxtpw);
        
        //foget password
        JPanel pfgpw = new JPanel();
        pfgpw.setBackground(new Color(247,210,158));
		pfgpw.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		JLabel lblfgpw = new JLabel("Foget Password?");
		lblfgpw.setFont(new Font("Dosis", 0, 14));
		lblfgpw.setForeground(Color.BLACK);
		lblfgpw.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pfgpw.add(lblfgpw);
        
		
		
		//button Login
		JPanel pbtnLogin = new JPanel();
		pbtnLogin.setBackground(new Color(247,210,158));
		pbtnLogin.setBorder(BorderFactory.createEmptyBorder(30,0,30,0));
		btnLogin = new JButton("Login");
		btnLogin.setBackground(new Color(212,66,51));
		btnLogin.setPreferredSize(new Dimension(250, 30));
		btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pbtnLogin.add(btnLogin);
		
		
        
        
        pInput.add(pusn);
        pInput.add(ppw);
        pLogin.add(pTitle);
        pLogin.add(pInput);
        pLogin.add(pfgpw);
        pLogin.add(pbtnLogin);
        pright.add(pLogin);
        
        add(pright,BorderLayout.CENTER);
        
        setVisible(true);
        btnLogin.addActionListener(this);
        lbl_hiddenicon.addMouseListener(this);
     	
	}

  
    public static void main(String args[]) {
        new Login();
    }


	@Override
	public void mouseClicked(MouseEvent e) {
		 if (e.getSource().equals( lbl_hiddenicon)) {
	            if (txt_password.getEchoChar() == '*') {
	                txt_password.setEchoChar((char)0); // Hiển thị mật khẩu
	            } else {
	                txt_password.setEchoChar('*'); // Ẩn mật khẩu
	            }
	        }
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnLogin)) {
			
//			Connection conn = KetNoiSQL.getConnection();
//		       try{
//		       String sql="SELECT * FROM TaiKhoan WHERE tenTaiKhoan=? AND matKhau=? and (isDeleted is null or isDeleted = 0)";
//		       PreparedStatement stmt= conn.prepareCall(sql);
//		       stmt.setString(1, txt_TaiKhoan.getText());
//		       stmt.setString(2, String.valueOf(pwd_MatKhau.getPassword()));
//		       ResultSet rs= stmt.executeQuery();
//		       if(rs.next()){
//		           JOptionPane.showMessageDialog(null,"Đăng nhập thành công");
//		           nhanVien = nv_DAO.getNhanVienByID(rs.getString(4));
//		           this.setVisible(false);
//		           new TrangChu().setVisible(true);
//		       }else{
//		           JOptionPane.showMessageDialog(null, "Tài khoản hoặc mật khẩu không đúng");
//		           pwd_MatKhau.setText("");
//		       }
//		       }catch(Exception ex){
//		       JOptionPane.showMessageDialog(null, ex);
//		       }
			
			new TrangChu();
			dispose();
		}
		
		
	}



}
