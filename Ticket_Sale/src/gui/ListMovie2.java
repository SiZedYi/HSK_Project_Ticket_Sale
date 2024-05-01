package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import connectDB.ConnectDB;
import dao.Phim_DAO;
import entity.Phim;
import enums.GioiHanTuoi;
import enums.TheLoai;
import enums.TrangThaiPhim;

import javax.swing.JInternalFrame;
import javax.swing.UIManager;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import java.awt.Rectangle;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Canvas;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import javax.swing.ScrollPaneConstants;

public class ListMovie2 extends JPanel {

    private static final long serialVersionUID = 1L;
    private int prevY;
    private boolean isDragging = false;
    private Phim_DAO movieDao = new Phim_DAO();
    ArrayList<Phim> listMovieInDB = movieDao.getAllData();
    public ListMovie2() {
        setLayout(new BorderLayout(0, 0));

        JPanel header = new JPanel();
        header.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 40));

        JLabel movieDetailTitle = new JLabel("PHIM ĐANG CHIẾU");
        movieDetailTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
        header.add(movieDetailTitle);
        add(header, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane();
    	// Bắt sự kiện kéo chuột trên JScrollPane
        scrollPane.addMouseMotionListener(new MouseAdapter() {
        	 @Override
             public void mouseDragged(MouseEvent e) {
                 if (!isDragging) {
                     prevY = e.getY();
                     isDragging = true;
                 } else {
                     int currentY = e.getY();
                     int diffY = currentY - prevY;
                     JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
                     verticalScrollBar.setValue(verticalScrollBar.getValue() - diffY);
                     prevY = currentY;
                 }
             }
        });
        
        // Bắt sự kiện nhả chuột để kết thúc việc kéo
        scrollPane.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                isDragging = false;
            }
        });
        add(scrollPane, BorderLayout.CENTER);

        JPanel listMovie = new JPanel();
        listMovie.setBackground(new Color(192, 192, 192));
        listMovie.setLayout(new BoxLayout(listMovie, BoxLayout.Y_AXIS));
        scrollPane.setViewportView(listMovie);
        
        // xử lý để thêm vào component
        JPanel movieDetail = new JPanel();
        movieDetail.setAlignmentY(Component.TOP_ALIGNMENT);
        movieDetail.setSize(new Dimension(800, 100));
        movieDetail.setLayout(new GridLayout(1, 2, 0, 0));
        
        //  Component ảnh phim
        JPanel movieImage = new JPanel();
        movieImage.setSize(new Dimension(100, 100));
        movieDetail.add(movieImage);
         movieImage.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        // Tạo và thêm hình ảnh vào movieImage
         ImageJFrame imageJFrame = new ImageJFrame("./image/nobita.png", (int) movieImage.getSize().getWidth(),(int) movieImage.getSize().getHeight());
         movieImage.add(imageJFrame);
         imageJFrame.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

         // Component thông tin phim
        JPanel movieInfo = new JPanel();
        movieInfo.setAlignmentX(Component.LEFT_ALIGNMENT);
        movieDetail.setSize(new Dimension(650, 100));
        movieDetail.add(movieInfo);
        movieInfo.setLayout(new GridLayout(3, 1, 0, 0));

        JLabel lblNewLabel_1 = new JLabel("Nabito");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1.setSize(new Dimension(650, 30));
        lblNewLabel_1.setAlignmentY(Component.TOP_ALIGNMENT);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
        movieInfo.add(lblNewLabel_1);
        
        String categoryValueDisplay = "Hành động";
        if (categoryValueDisplay.toString().startsWith("[") && categoryValueDisplay.toString().endsWith("]")) {
        	categoryValueDisplay = categoryValueDisplay.toString().substring(1, categoryValueDisplay.toString().length() - 1);
        }
        JLabel lblNewLabel_1_1 = new JLabel(categoryValueDisplay);
        lblNewLabel_1_1.setSize(new Dimension(650, 30));
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.ITALIC, 17));
        lblNewLabel_1_1.setAlignmentY(0.0f);
        movieInfo.add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_2 = new JLabel("Giới hạn tuổi: 18");
        lblNewLabel_1_2.setSize(new Dimension(650, 30));
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_1_2.setAlignmentY(0.0f);
        movieInfo.add(lblNewLabel_1_2);
        
        listMovie.add(movieDetail);
        
        JPanel movieDetail_1 = new JPanel();
        movieDetail_1.setSize(new Dimension(800, 100));
        movieDetail_1.setAlignmentY(0.0f);
        listMovie.add(movieDetail_1);
        movieDetail_1.setLayout(new GridLayout(1, 2, 0, 0));
        
        JPanel movieImage_1 = new JPanel();
        movieImage_1.setSize(new Dimension(100, 100));
        movieDetail_1.add(movieImage_1);
        movieImage_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        ImageJFrame imageJFrame_1 = new ImageJFrame("./image/nobita.png", 100, 100);
        movieImage_1.add(imageJFrame_1);
        imageJFrame_1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        
        JPanel movieInfo_1 = new JPanel();
        movieInfo_1.setAlignmentX(0.0f);
        movieDetail_1.add(movieInfo_1);
        movieInfo_1.setLayout(new GridLayout(3, 1, 0, 0));
        
        JLabel lblNewLabel_1_3 = new JLabel("Nabito");
        lblNewLabel_1_3.setSize(new Dimension(650, 30));
        lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblNewLabel_1_3.setAlignmentY(0.0f);
        movieInfo_1.add(lblNewLabel_1_3);
        
        JLabel lblNewLabel_1_1_1 = new JLabel("Hành động");
        lblNewLabel_1_1_1.setSize(new Dimension(650, 30));
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.ITALIC, 17));
        lblNewLabel_1_1_1.setAlignmentY(0.0f);
        movieInfo_1.add(lblNewLabel_1_1_1);
        
        JLabel lblNewLabel_1_2_1 = new JLabel("Giới hạn tuổi: 18");
        lblNewLabel_1_2_1.setSize(new Dimension(650, 30));
        lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_1_2_1.setAlignmentY(0.0f);
        movieInfo_1.add(lblNewLabel_1_2_1);
        setVisible(true);
    }

    
    public static void main(String[] args) {
    	JFrame frame = new JFrame("List Movie Demo");
    	frame.setSize(1000, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // Tạo một instance của ListMovie
        ListMovie2 listMovie = new ListMovie2();
        frame.getContentPane().add(listMovie);

//        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
	}
}
