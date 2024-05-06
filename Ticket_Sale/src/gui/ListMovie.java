
package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;

import connectDB.ConnectDB;
import dao.Phim_Dao;
import entity.Phim;
import enums.TheLoai;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;

public class ListMovie extends JPanel {

    private static final long serialVersionUID = 1L;
    private int prevY;
    private boolean isDragging = false;
    private Phim_Dao movieDao = new Phim_Dao();
    ArrayList<Phim> listMovieInDB = movieDao.getAllData();
    public ListMovie() {
        setLayout(new BorderLayout(0, 0));

        JPanel header = createHeader();
        add(header, BorderLayout.NORTH);

        JScrollPane scrollPane = createScrollPane();
        add(scrollPane, BorderLayout.CENTER);

        JPanel listMovie = new JPanel();
        listMovie.setBackground(new Color(192, 192, 192));
        listMovie.setLayout(new BoxLayout(listMovie, BoxLayout.Y_AXIS));
        scrollPane.setViewportView(listMovie);
        
        
        for (Phim phim : listMovieInDB) {
            JPanel movieDetail = createMovieDetail(phim);
            listMovie.add(movieDetail);
        }

        setVisible(true);
    }
    
    public ListMovie(String maPhim, boolean isShowHeader) {
        setLayout(new BorderLayout(0, 0));
        
        if(isShowHeader) {
        	JPanel header = createHeader();
        	add(header, BorderLayout.NORTH);
        }

        JScrollPane scrollPane = createScrollPane();
        add(scrollPane, BorderLayout.CENTER);

        JPanel listMovie = new JPanel();
        listMovie.setBackground(new Color(192, 192, 192));
        listMovie.setLayout(new BoxLayout(listMovie, BoxLayout.Y_AXIS));
        scrollPane.setViewportView(listMovie);
        
        ArrayList<Phim> getPhimById = movieDao.getByAttribute("maPhim", maPhim);
        for (Phim phim : getPhimById) {
            JPanel movieDetail = createMovieDetail(phim);
            listMovie.add(movieDetail);
        }

        setVisible(true);
    }

    private JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 40));

        JLabel movieDetailTitle = new JLabel("DANH SÁCH PHIM ĐANG CHIẾU");
        movieDetailTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
        header.add(movieDetailTitle);

        return header;
    }
    
    private JScrollPane createScrollPane() {
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
        return scrollPane;
    }

    private JPanel createMovieDetail(Phim movie) {
    	// lấy các giá trị từ obj phim
    	String movieIdValue = movie.getMaPhim();
    	String movieNameValue = movie.getTenPhim();
    	String movieImageValue = movie.getHinhAnh()!= null ? movie.getHinhAnh() : "./image/movie-placeholder.jpg";
    	System.out.println(movieImageValue);
    	String movieStatusValue = movie.getTrangThai().toString();
        double priceValue = movie.getGia();
        ArrayList<TheLoai> categoryValue = movie.getTheLoai();
        String ageLimitValue = movie.getGioiHanTuoi().toString();
        
        // xử lý để thêm vào component
        JPanel movieDetail = new JPanel();
        movieDetail.setSize(new Dimension(800, 100));
        movieDetail.setLayout(new BoxLayout(movieDetail, BoxLayout.X_AXIS));
        movieDetail.setBorder(createShadowBorder());
        
        //  Component ảnh phim
        JPanel movieImage = new JPanel();
        FlowLayout flowLayout = (FlowLayout) movieImage.getLayout();
        flowLayout.setVgap(0);
        flowLayout.setHgap(0);
        movieImage.setMinimumSize(new Dimension(200, 100));
        movieImage.setMaximumSize(new Dimension(200, 100));
        movieImage.setPreferredSize(new Dimension(200, 100));
        movieDetail.add(movieImage);

        // Tạo và thêm hình ảnh vào movieImage
         ImageJFrame imageJFrame = new ImageJFrame(movieImageValue, (int) movieImage.getPreferredSize().getWidth(),(int) movieImage.getPreferredSize().getHeight());
         movieImage.add(imageJFrame);

         // Component thông tin phim
        JPanel movieInfo = new JPanel();
        movieInfo.setAlignmentX(Component.LEFT_ALIGNMENT);
        movieDetail.setSize(new Dimension(650, 100));
        movieDetail.add(movieInfo);
        movieInfo.setLayout(new GridLayout(3, 1, 0, 0));

        JLabel lblNewLabel_1 = new JLabel(movieNameValue);
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1.setSize(new Dimension(650, 30));
        lblNewLabel_1.setAlignmentY(Component.TOP_ALIGNMENT);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
        movieInfo.add(lblNewLabel_1);
        
        String categoryValueDisplay = categoryValue.toString();
        if (categoryValueDisplay.toString().startsWith("[") && categoryValueDisplay.toString().endsWith("]")) {
        	categoryValueDisplay = categoryValueDisplay.toString().substring(1, categoryValueDisplay.toString().length() - 1);
        }
        JLabel lblNewLabel_1_1 = new JLabel(categoryValueDisplay);
        lblNewLabel_1_1.setPreferredSize(new Dimension(650, 30));
        lblNewLabel_1_1.setMinimumSize(new Dimension(300, 15));
        lblNewLabel_1_1.setMaximumSize(new Dimension(300, 15));
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.ITALIC, 17));
        lblNewLabel_1_1.setAlignmentY(0.0f);
        movieInfo.add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_2 = new JLabel("Giới hạn tuổi: " + ageLimitValue);
        lblNewLabel_1_2.setPreferredSize(new Dimension(650, 30));
        lblNewLabel_1_2.setMinimumSize(new Dimension(300, 15));
        lblNewLabel_1_2.setMaximumSize(new Dimension(300, 15));
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_1_2.setAlignmentY(0.0f);
        movieInfo.add(lblNewLabel_1_2);

        return movieDetail;
    }
    
    public static Border createShadowBorder() {
        Border emptyBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        Border lineBorder = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
        Border compoundBorder = BorderFactory.createCompoundBorder(emptyBorder, lineBorder);
        Border shadowBorder = BorderFactory.createSoftBevelBorder(SoftBevelBorder.RAISED, Color.WHITE, Color.GRAY);
        return BorderFactory.createCompoundBorder(compoundBorder, shadowBorder);
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
        ListMovie listMovie = new ListMovie();
        frame.getContentPane().add(listMovie);

//        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
	}
}

