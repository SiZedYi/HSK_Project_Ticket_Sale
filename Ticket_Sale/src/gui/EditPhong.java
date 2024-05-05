package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import connectDB.ConnectDB;
import dao.Phim_DAO;
import dao.Rap_DAO;
import entity.PhongChieu;
import entity.Rap;
import entity.SuatChieu;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;

import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class EditPhong extends JPanel{
	private JPanel header;
	private JLabel editRapTitle;
	private ComboBoxField rapCombobox;
	private String maPhim;
	private JComboBox scComboBoxField;
	private JPanel suatChieuGhe;
	private ComboBoxField phongChieuCombobox;
	ArrayList<String> gheDaChon;
	 // Mảng chứa các ký tự để đại diện cho các hàng
    String[] rowLabels = {"A", "B", "C", "D", "E", "F"};
    // Mảng chứa các số để đại diện cho các cột
    String[] colLabels = {" ","1", "2", "3", "4", "5", "6", "7", "8"};
	private Rap_DAO rapDao = new Rap_DAO();
	public EditPhong(String maPhim) {
		this.maPhim = maPhim;
		setPreferredSize(new Dimension(1130,700));
		setLayout(new BorderLayout(0, 0));
		JPanel header = createHeader();
		add(header, BorderLayout.NORTH);
		
		JPanel body = new JPanel();
		body.setSize(1100,700);
		add(body, BorderLayout.CENTER);
		
		JPanel footer = new JPanel();
		footer.setPreferredSize(new Dimension(1000,50));
		JPanel rapPhongChieu = new JPanel();
		rapPhongChieu.setPreferredSize(new Dimension(1130,50));
		
		// chọn rạp
		JPanel rapComboboxPanel = new JPanel();
		rapPhongChieu.setLayout(new BoxLayout(rapPhongChieu, BoxLayout.X_AXIS));
		JLabel rapTitlePanel = new JLabel("Rạp:");
		rapTitlePanel.setPreferredSize(new Dimension(300 - 200-10, 30));
		
		JComboBox rapComboBoxField = new JComboBox();
		rapComboBoxField.setEditable(true);
		rapComboBoxField.setPreferredSize(new Dimension(200, 30));
		for(Rap rap: rapDao.getAllRap()) {
			rapComboBoxField.addItem(rap.getTenRap());
			
		}
		rapComboboxPanel.add(rapTitlePanel);
		rapComboboxPanel.add(rapComboBoxField);
		rapComboboxPanel.setPreferredSize(new Dimension(300, 30));
		rapPhongChieu.add(rapComboboxPanel);
		
		// chọn phòng chiếu
		JPanel phongChieuComboboxPanel = new JPanel();
		rapPhongChieu.setLayout(new BoxLayout(rapPhongChieu, BoxLayout.X_AXIS));
		JLabel pcTitlePanel = new JLabel("Phòng chiếu:");
		pcTitlePanel.setPreferredSize(new Dimension(300 - 200-10, 30));
		
		JComboBox pcComboBoxField = new JComboBox();
		pcComboBoxField.setEditable(true);
		pcComboBoxField.setPreferredSize(new Dimension(200, 30));
		for(PhongChieu pc: rapDao.getAllPhongChieuByPhim(maPhim)) {
			pcComboBoxField.addItem(pc.getTenPC());
			
		}
		phongChieuComboboxPanel.add(pcTitlePanel);
		phongChieuComboboxPanel.add(pcComboBoxField);
		phongChieuComboboxPanel.setPreferredSize(new Dimension(300, 30));
		rapPhongChieu.add(phongChieuComboboxPanel);
		
		// chọn suất chiếu
		JPanel suatChieuComboboxPanel = new JPanel();
		rapPhongChieu.setLayout(new BoxLayout(rapPhongChieu, BoxLayout.X_AXIS));
		JLabel scTitlePanel = new JLabel("Suất chiếu:");
		scTitlePanel.setPreferredSize(new Dimension(300 - 200-10, 30));
		
		scComboBoxField = new JComboBox();
		scComboBoxField.setEditable(true);
		scComboBoxField.setPreferredSize(new Dimension(200, 30));
		for(SuatChieu sc: rapDao.getAllSuatChieuOfPhim(maPhim)) {
			scComboBoxField.addItem(sc.getMaSC() +" - "+ sc.getThoiGianBatDau());
			
		}
		suatChieuComboboxPanel.add(scTitlePanel);
		suatChieuComboboxPanel.add(scComboBoxField);
		suatChieuComboboxPanel.setPreferredSize(new Dimension(300, 30));
		rapPhongChieu.add(suatChieuComboboxPanel);
		
		suatChieuGhe = new JPanel();
		suatChieuGhe.setSize(700,200);
		suatChieuGhe.setLayout(new GridLayout(7, 9, 5, 5));
		
        for(String a : colLabels) {
        	JLabel number = new JLabel(a, SwingConstants.CENTER);
        	number.setPreferredSize(new Dimension(20,20));
        	suatChieuGhe.add(number);
        }
//		// Tạo các ghế
//        for (int row = 0; row < 6; row++) {
//        	JLabel character = new JLabel(rowLabels[row], SwingConstants.CENTER);
//        	character.setSize(50,50);
//        	suatChieuGhe.add(character);
//            for (int col = 0; col < 8; col++) {
//                JButton seat = new JButton(rowLabels[row] + "" + (col + 1));
//                seat.setPreferredSize(new Dimension(30,30)); // Kích thước của mỗi ghế
//                suatChieuGhe.add(seat);
//            }
//        }
        gheDaChon = rapDao.layGheDaChon("SC001"); 
        System.out.println(gheDaChon);
        // Tạo và thêm ghế vào panel
        for (int row = 0; row < 6; row++) {
            JLabel character = new JLabel(rowLabels[row], SwingConstants.CENTER);
            character.setSize(50, 50);
            suatChieuGhe.add(character);

            for (int col = 0; col < 8; col++) {
                String ghe = rowLabels[row] + "" + String.format("%03d", col+1);
                JButton seat = new JButton(ghe);
                seat.setPreferredSize(new Dimension(50, 50)); // Kích thước của mỗi ghế

                // Nếu ghế đã tồn tại trong bảng Ve, làm mờ JButton tương ứng
                if (gheDaChon.contains(ghe)) {
                    seat.setEnabled(false);
                }

                suatChieuGhe.add(seat);
            }
        };
        
		body.setLayout(new BoxLayout(body, BoxLayout.Y_AXIS));
		
		JPanel monitor = new JPanel();
		monitor.setPreferredSize(new Dimension(1100, 50));
		body.add(monitor);
		
		JPanel ghePanel = new JPanel();
		ghePanel.setPreferredSize(new Dimension(1000,300));;
		body.add(ghePanel);
		ghePanel.setLayout(new BoxLayout(ghePanel, BoxLayout.X_AXIS));
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(-60, 300));
		ghePanel.add(panel_1);
		
		ghePanel.add(suatChieuGhe);
		
		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(30, 300));
		ghePanel.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		monitor.setLayout(new BoxLayout(monitor, BoxLayout.X_AXIS));
		
		
		ImageJFrame imageJFrame = new ImageJFrame("./image/screen.jpg", 600,100);
		FlowLayout flowLayout = (FlowLayout) imageJFrame.getLayout();
		monitor.add(imageJFrame);
		body.add(rapPhongChieu);
		
		JPanel suatChieuCombobox = new JPanel();
		rapPhongChieu.add(suatChieuCombobox);
		
		scComboBoxField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //
                // Get the source of the component, which is our combo
                // box.
                //
            	suatChieuGhe.removeAll();
        		suatChieuGhe.revalidate();
        		suatChieuGhe.repaint();
                JComboBox comboBox = (JComboBox) event.getSource();
                String selectedItem = (String) comboBox.getSelectedItem();
                // Cắt chuỗi tại dấu "-" và lấy mã đầu tiên
                String maSuatChieu = selectedItem.substring(0, selectedItem.indexOf(" - "));
                gheDaChon = rapDao.layGheDaChon(maSuatChieu); 
//               // Hiển thị lại danh sách các ghế
        		hienThiDanhSachGhe(suatChieuGhe, maSuatChieu);
//                JOptionPane.showMessageDialog(body, "Bạn đã chọn: " + maSuatChieu);

            }
        });
	}
	

	// Hàm để hiển thị danh sách ghế dựa trên mã suất chiếu
	private void hienThiDanhSachGhe(JPanel suatChieuGhe, String maSuatChieu) {
		for(String a : colLabels) {
        	JLabel number = new JLabel(a, SwingConstants.CENTER);
        	number.setPreferredSize(new Dimension(20,20));
        	suatChieuGhe.add(number);
        }
	    // Tạo và thêm ghế vào panel
	    for (int row = 0; row < 6; row++) {
	        JLabel character = new JLabel(rowLabels[row], SwingConstants.CENTER);
	        character.setSize(50, 50);
	        suatChieuGhe.add(character);
	        
	        for (int col = 0; col < 8; col++) {
	            String ghe = rowLabels[row] + "" + String.format("%03d", col+1);
	            JButton seat = new JButton(ghe);
	            seat.setPreferredSize(new Dimension(50, 50)); // Kích thước của mỗi ghế

	            // Nếu ghế đã tồn tại trong bảng Ve, làm mờ JButton tương ứng
	            if (gheDaChon.contains(ghe)) {
	                seat.setEnabled(false);
	            }

	            suatChieuGhe.add(seat);
	        }
	    }
	}

	private JPanel createHeader() {
			header = new ListMovie(maPhim,false);
        return header;
    }
	
	public static void main(String[] args) {
    	JFrame frame = new JFrame("List Movie Demo");
    	frame.setSize(1138, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // Tạo một instance của ListMovie
        EditPhong statistic = new EditPhong("P001");
        frame.getContentPane().add(statistic);

//        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
	}
}
