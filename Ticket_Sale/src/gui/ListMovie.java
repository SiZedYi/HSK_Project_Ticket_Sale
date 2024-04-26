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

public class ListMovie extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public ListMovie() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1108, 686);
		contentPane = new JPanel();
		contentPane.setToolTipText(" ");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel header = new JPanel();
		contentPane.add(header, BorderLayout.NORTH);
		
		JPanel body = new JPanel();
		contentPane.add(body, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		body.add(scrollPane);
		
		JPanel listMovie = new JPanel();
		listMovie.setBackground(new Color(192, 192, 192));
		listMovie.setBounds(8, 0, 800, 800);
		scrollPane.setViewportView(listMovie);
		listMovie.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel movieDetail = new JPanel();
		movieDetail.setPreferredSize(new Dimension(1000, 100));
		listMovie.add(movieDetail);
		movieDetail.setLayout(new BorderLayout(0, 0));
		
		JPanel movieImage = new JPanel();
		movieImage.setMinimumSize(new Dimension(300, 80));
		movieImage.setBounds(new Rectangle(0, 0, 300, 80));
		movieDetail.add(movieImage, BorderLayout.WEST);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\ANH THANG\\Downloads\\rsJjBcH.png"));
		lblNewLabel.setPreferredSize(new Dimension(80, 90));
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setBounds(new Rectangle(0, 0, 300, 80));
		movieImage.add(lblNewLabel);
		
		JPanel movieInfo = new JPanel();
		movieInfo.setAlignmentX(Component.LEFT_ALIGNMENT);
		movieDetail.add(movieInfo, BorderLayout.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("NOBITA VÀ VÙNG ĐẤT TRÊN BẦU TRỜI");
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
		setVisible(true);
	}

}
