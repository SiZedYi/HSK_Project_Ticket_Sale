package gui;

import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connectDB.ConnectDB;
import dao.Phim_Dao;

public class A extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//ConnectDB
		ConnectDB dbConnection = new ConnectDB();
        try {
			dbConnection.connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
        //All Dao
        Phim_Dao phimDao = new Phim_Dao();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListMovie frame = new ListMovie();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public A() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	}

}
