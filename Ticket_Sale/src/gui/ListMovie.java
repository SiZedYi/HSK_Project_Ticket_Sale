package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JInternalFrame;
import javax.swing.UIManager;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import java.awt.Rectangle;
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
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;

public class ListMovie extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public ListMovie() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
//		setBounds(100, 100, 1108, 686);
		contentPane = new JPanel();
		contentPane.setAlignmentY(Component.TOP_ALIGNMENT);
		contentPane.setAlignmentX(Component.LEFT_ALIGNMENT);
		contentPane.setToolTipText(" ");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel header = new JPanel();
		contentPane.add(header, BorderLayout.NORTH);
		
		JLabel movieDetailTitle = new JLabel("PHIM ĐANG CHIẾU");
		movieDetailTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		header.add(movieDetailTitle);
		
		JPanel body = new JPanel();
		contentPane.add(body, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		body.add(scrollPane);
		
		JPanel listMovie = new JPanel();
		listMovie.setBackground(new Color(192, 192, 192));
		listMovie.setBounds(8, 0, 800, 800);
		scrollPane.setViewportView(listMovie);
		FlowLayout fl_listMovie = new FlowLayout(FlowLayout.CENTER, 2, 3);
		fl_listMovie.setAlignOnBaseline(true);
		listMovie.setLayout(fl_listMovie);
		
		JPanel movieDetail = new JPanel();
		movieDetail.setPreferredSize(new Dimension(1000, 100));
		listMovie.add(movieDetail);
		movieDetail.setLayout(new BoxLayout(movieDetail, BoxLayout.X_AXIS));
		
		JPanel movieImage = new JPanel();
		movieImage.setMinimumSize(new Dimension(150, 100));
		movieImage.setPreferredSize(new Dimension(150, 100));
		movieDetail.add(movieImage);
		movieImage.setLayout(new BoxLayout(movieImage, BoxLayout.X_AXIS));
		
		ImageJFrame imageJFrame = new ImageJFrame("./image/nobita.png", (int) movieImage.getPreferredSize().getWidth(),(int) movieImage.getPreferredSize().getHeight());
		movieImage.add(imageJFrame);
		
		JPanel movieInfo = new JPanel();
		movieInfo.setAlignmentX(Component.LEFT_ALIGNMENT);
		movieDetail.add(movieInfo);
		
		JLabel lblNewLabel_1 = new JLabel("NOBITA VÀ VÙNG ĐẤT TRÊN BẦU TRỜI");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setPreferredSize(new Dimension(650, 30));
		lblNewLabel_1.setMinimumSize(new Dimension(300, 15));
		lblNewLabel_1.setMaximumSize(new Dimension(300, 15));
		lblNewLabel_1.setAlignmentY(Component.TOP_ALIGNMENT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		movieInfo.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Hoạt hình, Trẻ em\r\n");
		lblNewLabel_1_1.setPreferredSize(new Dimension(650, 30));
		lblNewLabel_1_1.setMinimumSize(new Dimension(300, 15));
		lblNewLabel_1_1.setMaximumSize(new Dimension(300, 15));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.ITALIC, 17));
		lblNewLabel_1_1.setAlignmentY(0.0f);
		movieInfo.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Giới hạn tuổi: 13");
		lblNewLabel_1_2.setPreferredSize(new Dimension(650, 30));
		lblNewLabel_1_2.setMinimumSize(new Dimension(300, 15));
		lblNewLabel_1_2.setMaximumSize(new Dimension(300, 15));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_2.setAlignmentY(0.0f);
		movieInfo.add(lblNewLabel_1_2);
		add(contentPane);
		setVisible(true);
	}

}
