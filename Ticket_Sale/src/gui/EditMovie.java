package gui;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import connectDB.ConnectDB;
import dao.Phim_Dao;
import entity.Phim;
import enums.GioiHanTuoi;
import enums.TheLoai;
import enums.TrangThaiPhim;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.table.TableModel;
import java.awt.Insets;
import java.awt.Panel;
import javax.swing.ImageIcon;

public class EditMovie extends JPanel implements ActionListener{
	private DefaultTableModel movieModel;
	private JTable tableMovie;
	private JPanel header_1, body;
	private ImageJFrame imageJFrame;
	private JButton themBtn, suaBtn, xoaBtn, chonAnhBtn;
	private JLabel movieDetailTitle;
	private Phim_Dao movieDao = new Phim_Dao();
    ArrayList<Phim> listMovieInDB = movieDao.getAllData();
	private String movieFileName = "./data/Image/movie-placeholder.jpg";
	private InputTextField maPhimInputField, tenPhimInputField, giaInputField;
	private JComboBox<TheLoai> theLoaiInputField;
	private JComboBox<GioiHanTuoi> gioiHanTuoiInputField;
	private JComboBox<TrangThaiPhim> trangThaiInputField;
	public EditMovie() {
		setLayout(new BorderLayout(0, 0));
		setPreferredSize(new Dimension(900,800));
		JPanel header = createHeader();
		add(header, BorderLayout.NORTH);
		
		
		JPanel footer = new JPanel();
		String[] tableHeader= {"Mã Phim","Tên Phim","Trạng Thái Phim","Giá", "Thể Loại", "Giới Hạn Tuổi", "Hình Ảnh"};
		movieModel = new DefaultTableModel(tableHeader,0);
		for(Phim phim : listMovieInDB) {
			String categoryValueDisplay = phim.getTheLoai().toString();
			if (categoryValueDisplay.toString().startsWith("[") && categoryValueDisplay.toString().endsWith("]")) 
				categoryValueDisplay = categoryValueDisplay.toString().substring(1, categoryValueDisplay.toString().length() - 1);
        
	        movieModel.addRow(new Object[]{
						phim.getMaPhim(),
						phim.getTenPhim(),
						phim.getTrangThai(),
						phim.getGia(),
						categoryValueDisplay,
						phim.getGioiHanTuoi(),
						phim.getHinhAnh(),
				});
		}
		tableMovie = new JTable(movieModel);
		tableMovie.setRowHeight(30);
		TableColumnModel columnModel = tableMovie.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(40);
		columnModel.getColumn(1).setPreferredWidth(100);
		columnModel.getColumn(2).setPreferredWidth(40);
		columnModel.getColumn(3).setPreferredWidth(30);
		columnModel.getColumn(4).setPreferredWidth(60);
		columnModel.getColumn(5).setPreferredWidth(50);
		footer.setLayout(new FlowLayout(FlowLayout.LEADING,1, 5));
		JScrollPane scrollPaneMovie = new JScrollPane(tableMovie);
		scrollPaneMovie.setPreferredSize(new Dimension(850, 400));
		footer.add(scrollPaneMovie);   
    	footer.setBorder(BorderFactory.createTitledBorder("Danh sách phim hiện hành"));
		footer.setSize(1000 ,400);
		add(footer, BorderLayout.SOUTH);
		
        
        body = new JPanel();
        body.setBorder(null);
		body.setSize(1138,50);
		add(body, BorderLayout.CENTER);
		body.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel editMoviePanel = new JPanel();
		body.add(editMoviePanel);
		editMoviePanel.setLayout(new BoxLayout(editMoviePanel, BoxLayout.X_AXIS));
		
		JPanel inputMoviePanel = new JPanel();
		editMoviePanel.add(inputMoviePanel);
		inputMoviePanel.setLayout(new BoxLayout(inputMoviePanel, BoxLayout.Y_AXIS));
		
		JPanel panel_4 = new JPanel();
		editMoviePanel.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));
		Component horizontalStrut = Box.createHorizontalStrut(40);
		panel_4.add(horizontalStrut);
		JPanel panel = new JPanel();
		panel_4.add(panel);
		panel.setLayout(new GridLayout(9, 1, 0, 0));
		
		
		chonAnhBtn = new JButton("Chọn Ảnh");
		chonAnhBtn.setFont(new Font("Tahoma", Font.PLAIN, 10));
		chonAnhBtn.setAlignmentX(0.5f);
		chonAnhBtn.addActionListener(this);
		
		Panel panel_1_1 = new Panel();
		panel.add(panel_1_1);
		panel.add(chonAnhBtn);
		
		Panel panel_3 = new Panel();
		panel.add(panel_3);
		
		themBtn = new JButton("THÊM");
		themBtn.setForeground(new Color(255, 255, 255));
		themBtn.setBackground(new Color(0, 128, 0));
		themBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		themBtn.setAlignmentX(0.5f);
		themBtn.addActionListener(this);
		panel.add(themBtn);
		
		Panel panel_1 = new Panel();
		panel.add(panel_1);
		
		suaBtn = new JButton("SỬA");
		suaBtn.setForeground(new Color(255, 255, 255));
		suaBtn.setBackground(new Color(142, 146, 12));
		suaBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		suaBtn.setAlignmentX(0.5f);
		suaBtn.addActionListener(this);
		panel.add(suaBtn);
		
		Panel panel_2 = new Panel();
		panel.add(panel_2);
		
		xoaBtn = new JButton("XÓA");
		xoaBtn.setForeground(new Color(255, 255, 255));
		xoaBtn.setBackground(new Color(220, 20, 60));
		xoaBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		xoaBtn.setAlignmentX(0.5f);
		xoaBtn.addActionListener(this);
		panel.add(xoaBtn);
		
		Panel panel_2_1 = new Panel();
		panel.add(panel_2_1);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(40);
		panel_4.add(horizontalStrut_1);
		
		JPanel panel_5 = new JPanel();
		editMoviePanel.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));
		
		imageJFrame = new ImageJFrame(movieFileName, 200, 200);
		FlowLayout flowLayout = (FlowLayout) imageJFrame.getLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		panel_5.add(imageJFrame);
		
		maPhimInputField = new InputTextField(400, 25,"Mã Phim:",17, 300, 25);
		inputMoviePanel.add(maPhimInputField);
		
		tenPhimInputField = new InputTextField(400, 25, "Tên Phim:",17, 300, 25);
		inputMoviePanel.add(tenPhimInputField);
		
		// Trạng thái 
		JPanel trangThaiPanel = new JPanel();
		JLabel trangThaiLabel = new JLabel("Trạng Thái:");
		trangThaiLabel.setPreferredSize(new Dimension(400 - 300-10, 25));
		trangThaiLabel.setFont(new Font("Serif", Font.PLAIN, 17));
		
		trangThaiInputField = new JComboBox<TrangThaiPhim>();
		trangThaiInputField.setEditable(true);
		TrangThaiPhim[] trangThaiPhims = TrangThaiPhim.values();
		for(TrangThaiPhim ttp : trangThaiPhims) 
			trangThaiInputField.addItem(ttp);
		trangThaiInputField.setPreferredSize(new Dimension(300, 25));
		trangThaiPanel.add(trangThaiLabel);
		trangThaiPanel.add(trangThaiInputField);
		inputMoviePanel.add(trangThaiPanel);
		
		giaInputField = new InputTextField(400, 25, "Giá:",17, 300, 25);
		inputMoviePanel.add(giaInputField);
		
		// Thể loại
		JPanel theLoaiPanel = new JPanel();
		JLabel theLoaiLabel = new JLabel("Thể Loại:");
		theLoaiLabel.setPreferredSize(new Dimension(400 - 300-10, 25));
		theLoaiLabel.setFont(new Font("Serif", Font.PLAIN, 17));
		
		theLoaiInputField = new JComboBox<TheLoai>();
		theLoaiInputField.setEditable(true);
		TheLoai[] theLoaiPhims = TheLoai.values();
		for(TheLoai theLoai : theLoaiPhims) 
			theLoaiInputField.addItem(theLoai);
		theLoaiInputField.setPreferredSize(new Dimension(300, 25));
		theLoaiPanel.add(theLoaiLabel);
		theLoaiPanel.add(theLoaiInputField);
		inputMoviePanel.add(theLoaiPanel);
		
		// Giới hạn tuổi
		JPanel gioiHanTuoiPanel = new JPanel();
		JLabel gioiHanTuoiLabel = new JLabel("Giới hạn tuổi:");
		gioiHanTuoiLabel.setPreferredSize(new Dimension(400 - 300-10, 25));
		gioiHanTuoiLabel.setFont(new Font("Serif", Font.PLAIN, 17));
		
		gioiHanTuoiInputField = new JComboBox<GioiHanTuoi>();
		gioiHanTuoiInputField.setEditable(true);
		GioiHanTuoi[] gioiHanTuoiPhims = GioiHanTuoi.values();
		
		for(GioiHanTuoi ght : gioiHanTuoiPhims) 
			gioiHanTuoiInputField.addItem(ght);
		gioiHanTuoiInputField.setPreferredSize(new Dimension(300, 25));
		gioiHanTuoiPanel.add(gioiHanTuoiLabel);
		gioiHanTuoiPanel.add(gioiHanTuoiInputField);
		inputMoviePanel.add(gioiHanTuoiPanel);

		tableMovie.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = tableMovie.getSelectedRow();
				// Lấy giá trị enum từ JTable
		        String trangThaiValue = tableMovie.getValueAt(row, 2).toString();
		        String theLoaiValue = tableMovie.getValueAt(row, 4).toString();
		        String gioiHanTuoiValue = tableMovie.getValueAt(row, 5).toString();
		        
				 // Tìm index của enum trong mảng enum
		        int trangThaiIndex = -1;
		        int theLoaiIndex = -1;
		        int gioiHanTuoiIndex = -1;
		        TrangThaiPhim[] trangThaiValues = TrangThaiPhim.values();
		        for (int i = 0; i < trangThaiValues.length; i++) {
		            if (trangThaiValues[i].toString().equals(trangThaiValue)) {
		                trangThaiIndex = i;
		                break;
		            }
		        }

		        TheLoai[] theLoaiValues = TheLoai.values();
		        for (int i = 0; i < theLoaiValues.length; i++) {
		            if (theLoaiValues[i].toString().equals(theLoaiValue)) {
		                theLoaiIndex = i;
		                break;
		            }
		        }

		        GioiHanTuoi[] gioiHanTuoiValues = GioiHanTuoi.values();
		        for (int i = 0; i < gioiHanTuoiValues.length; i++) {
		            if (gioiHanTuoiValues[i].toString().equals(gioiHanTuoiValue)) {
		                gioiHanTuoiIndex = i;
		                break;
		            }
		        }
		        // Thiết lập mục được chọn cho các JComboBox
		        if (trangThaiIndex != -1) {
		            trangThaiInputField.setSelectedIndex(trangThaiIndex);
		        }
		        if (theLoaiIndex != -1) {
		            theLoaiInputField.setSelectedIndex(theLoaiIndex);
		        }
		        if (gioiHanTuoiIndex != -1) {
		            gioiHanTuoiInputField.setSelectedIndex(gioiHanTuoiIndex);
		        }

				maPhimInputField.setText(tableMovie.getValueAt(row, 0).toString());
				tenPhimInputField.setText(tableMovie.getValueAt(row, 1).toString());
				giaInputField.setText(tableMovie.getValueAt(row, 3).toString());
				imageJFrame.loadImage(tableMovie.getValueAt(row, 6).toString());
			}
		} );
	}
	
	public static Border createShadowBorder() {
        Border emptyBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        Border lineBorder = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
        Border compoundBorder = BorderFactory.createCompoundBorder(emptyBorder, lineBorder);
        Border shadowBorder = BorderFactory.createSoftBevelBorder(SoftBevelBorder.RAISED, Color.WHITE, Color.GRAY);
        return BorderFactory.createCompoundBorder(compoundBorder, shadowBorder);
    }
	
	private JPanel createHeader() {
        header_1 = new JPanel();
        header_1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 40));

        movieDetailTitle = new JLabel("QUẢN LÝ PHIM");
        movieDetailTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
        header_1.add(movieDetailTitle);

        return header_1;
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
        EditMovie listMovie = new EditMovie();
        frame.getContentPane().add(listMovie);

//        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
	}
	
	private void copyFile(String sourcePath, String destinationPath) {
        try {
            Path source = Paths.get(sourcePath);
            Path destination = Paths.get(destinationPath);
            Files.copy(source, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	private void clearInput() {
		maPhimInputField.setText("");
		tenPhimInputField.setText("");
		giaInputField.setText("");
		trangThaiInputField.setSelectedIndex(0);
		theLoaiInputField.setSelectedIndex(0);
		gioiHanTuoiInputField.setSelectedIndex(0);
		movieFileName = "./data/Image/movie-placeholder.jpg";
		imageJFrame.loadImage("./data/Image/movie-placeholder.jpg");
	}
	
	 private int tenPhimExists(String tenPhim) {
	        int rowCount = tableMovie.getRowCount();
	        for (int i = 0; i < rowCount; i++) {
	            String tenPhimInTable = (String) tableMovie.getValueAt(i, 1); // Lấy tên phim từ cột đầu tiên (index 0)
	            if (tenPhimInTable.equals(tenPhim)) {
	                return i; // Trả về true nếu tìm thấy tên phim trong JTable
	            }
	        }
	        return -1; // Trả về false nếu không tìm thấy tên phim trong JTable
	    }
	 
	 private int maPhimExists(String tenPhim) {
	        int rowCount = tableMovie.getRowCount();
	        for (int i = 0; i < rowCount; i++) {
	            String tenPhimInTable = (String) tableMovie.getValueAt(i, 0); // Lấy tên phim từ cột đầu tiên (index 0)
	            if (tenPhimInTable.equals(tenPhim)) {
	                return i; // Trả về true nếu tìm thấy tên phim trong JTable
	            }
	        }
	        return -1; // Trả về false nếu không tìm thấy tên phim trong JTable
	    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj == chonAnhBtn) {
			JFileChooser fileChooser = new JFileChooser();
			// Tạo một bộ lọc để chỉ hiển thị các tệp có định dạng ảnh
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png", "gif");
            fileChooser.setFileFilter(filter);
            int returnValue = fileChooser.showOpenDialog(body);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                movieFileName = selectedFile.getAbsolutePath();
                imageJFrame.loadImage(movieFileName);
//                JOptionPane.showMessageDialog(body, "Bạn đã chọn: " + movieFileName);
                // Tại đây, bạn có thể thực hiện xử lý hiển thị trước ảnh nếu cần
            }
//			JOptionPane.showMessageDialog(body, "Bạn đã chọn: " + movieFileName);
		}
		else if(obj == themBtn) {
			String maPhimValue = maPhimInputField.getText();
			String tenPhimValue = tenPhimInputField.getText();
			double giaValue = Double.parseDouble(giaInputField.getText());
			
			// Kiểm tra mã, tên trùng
			if(!Pattern.matches("P\\d{3}", maPhimValue))
				JOptionPane.showMessageDialog(body,"Mã phim phải bắt đầu bằng P và có 3 chữ số theo sau");
			else if(maPhimExists(maPhimValue)>-1) {
				JOptionPane.showMessageDialog(body,"Mã phim đã tồn tại");
				tableMovie.setRowSelectionInterval(maPhimExists(maPhimValue), maPhimExists(maPhimValue));
			}
			else if(tenPhimExists(tenPhimValue)>-1) {
				JOptionPane.showMessageDialog(body,"Tên phim đã tồn tại");
				tableMovie.setRowSelectionInterval(tenPhimExists(tenPhimValue), tenPhimExists(tenPhimValue));
			}
			else {
				TrangThaiPhim trangThaiValue = (TrangThaiPhim) trangThaiInputField.getSelectedItem();
					
				TheLoai theLoaiValue = (TheLoai) theLoaiInputField.getSelectedItem();
				ArrayList<TheLoai> theLoaiValues= new ArrayList<TheLoai>();
				theLoaiValues.add(theLoaiValue);
				
				GioiHanTuoi ghtValue = (GioiHanTuoi) gioiHanTuoiInputField.getSelectedItem();
				
				// Xử lý ảnh phim
				String destinationPath = "./data/Image/" + new File(movieFileName).getName();
				copyFile(movieFileName, destinationPath);
				
				// Tạo đối tượng
				Phim phim = new Phim(maPhimValue, tenPhimValue, destinationPath, trangThaiValue, giaValue, theLoaiValues, ghtValue);
				if(movieDao.create(phim)) {
					String categoryValueDisplay = phim.getTheLoai().toString();
					if (categoryValueDisplay.toString().startsWith("[") && categoryValueDisplay.toString().endsWith("]")) 
						categoryValueDisplay = categoryValueDisplay.toString().substring(1, categoryValueDisplay.toString().length() - 1);
					 movieModel.addRow(new Object[]{
								phim.getMaPhim(),
								phim.getTenPhim(),
								phim.getTrangThai(),
								phim.getGia(),
								categoryValueDisplay,
								phim.getGioiHanTuoi(),
								phim.getHinhAnh(),
						});
					clearInput();
					JOptionPane.showMessageDialog(body, "Đã thêm vào một phim mới");
				}
				else JOptionPane.showMessageDialog(body, "Không tạo phim mới được");;
			}
		}
		
		else if (obj == suaBtn) {
		    // Lấy dữ liệu từ các trường nhập
		    String maPhimValue = maPhimInputField.getText();
		    String tenPhimValue = tenPhimInputField.getText();
		    double giaValue = Double.parseDouble(giaInputField.getText());

		    // Kiểm tra mã phim có hợp lệ không
		    if (!Pattern.matches("P\\d{3}", maPhimValue)) {
		        JOptionPane.showMessageDialog(body, "Mã phim phải bắt đầu bằng P và có 3 chữ số theo sau");
		    } else {
		        // Lấy chỉ mục của hàng được chọn trong bảng
		        int selectedRowIndex = tableMovie.getSelectedRow();
		        // Kiểm tra xem có hàng nào được chọn không
		        if (selectedRowIndex != -1) {
		            // Lấy mã phim của hàng được chọn
		            String maPhimSelected = (String) tableMovie.getValueAt(selectedRowIndex, 0);
		            // Kiểm tra nếu mã phim được chọn giống với mã phim trong trường nhập
		            if (maPhimValue.equals(maPhimSelected)) {
		                // Cập nhật thông tin của phim trong bảng và cơ sở dữ liệu
		                TrangThaiPhim trangThaiValue = (TrangThaiPhim) trangThaiInputField.getSelectedItem();
		                TheLoai theLoaiValue = (TheLoai) theLoaiInputField.getSelectedItem();
		                ArrayList<TheLoai> theLoaiValues = new ArrayList<TheLoai>();
		                theLoaiValues.add(theLoaiValue);
		                GioiHanTuoi ghtValue = (GioiHanTuoi) gioiHanTuoiInputField.getSelectedItem();

		                // Xử lý ảnh phim
		                String destinationPath = "./data/Image/" + new File(movieFileName).getName();
		                copyFile(movieFileName, destinationPath);

		                // Tạo đối tượng Phim
		                Phim phim = new Phim(maPhimValue, tenPhimValue, destinationPath, trangThaiValue, giaValue, theLoaiValues, ghtValue);
		                
		                // Cập nhật thông tin trong bảng và cơ sở dữ liệu
		                if (movieDao.update(phim)) {
		                    String categoryValueDisplay = phim.getTheLoai().toString();
		                    if (categoryValueDisplay.startsWith("[") && categoryValueDisplay.endsWith("]")) {
		                        categoryValueDisplay = categoryValueDisplay.substring(1, categoryValueDisplay.length() - 1);
		                    }
		                    // Cập nhật dữ liệu trong hàng được chọn trong bảng
		                    tableMovie.setValueAt(phim.getMaPhim(), selectedRowIndex, 0);
		                    tableMovie.setValueAt(phim.getTenPhim(), selectedRowIndex, 1);
		                    tableMovie.setValueAt(phim.getTrangThai(), selectedRowIndex, 2);
		                    tableMovie.setValueAt(phim.getGia(), selectedRowIndex, 3);
		                    tableMovie.setValueAt(categoryValueDisplay, selectedRowIndex, 4);
		                    tableMovie.setValueAt(phim.getGioiHanTuoi(), selectedRowIndex, 5);
		                    tableMovie.setValueAt(phim.getHinhAnh(), selectedRowIndex, 6);
		                    clearInput();
		                } else {
		                    JOptionPane.showMessageDialog(body, "Không cập nhật được thông tin phim");
		                }
		            } else {
		                JOptionPane.showMessageDialog(body, "Không thể thay đổi mã phim khi cập nhật");
		            }
		        } else {
		            JOptionPane.showMessageDialog(body, "Vui lòng chọn một hàng để cập nhật");
		        }
		    }
		}
		
		else if(obj==xoaBtn) {
	        int row = tableMovie.getSelectedRow();
	        if (row == -1) {
	            // Kiểm tra nếu không có hàng nào được chọn
	            JOptionPane.showMessageDialog(body, "Vui lòng chọn một hàng để xóa", "Thông báo", JOptionPane.WARNING_MESSAGE);
	        } else {
	            // Lấy mã phim của hàng được chọn
	            String maPhim = tableMovie.getValueAt(row, 0).toString();
	            
	            // Xác nhận việc xóa
	            int choice = JOptionPane.showConfirmDialog(body, "Bạn có chắc chắn muốn xóa phim này không?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
	            if (choice == JOptionPane.YES_OPTION) {
	                // Gọi phương thức xóa trong DAO
	                if (movieDao.delete(maPhim)) {
	                    // Xóa hàng khỏi JTable
	                    ((DefaultTableModel) tableMovie.getModel()).removeRow(row);
	                    JOptionPane.showMessageDialog(body, "Đã xóa phim thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
	                } else {
	                    JOptionPane.showMessageDialog(body, "Không thể xóa phim", "Lỗi", JOptionPane.ERROR_MESSAGE);
	                }
	            }
			};
		}

	}
}
