package tables;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entity.HoaDon;

public class BangHoaDon extends JTable{
	private DefaultTableModel  model;
	private static String[] columnsName = { 
			"Mã hóa đơn",
			"Số tiền",
			"thời gian xuất",
			"Phương thức thanh toán"
			}; 
	
	public BangHoaDon() {
		model = new DefaultTableModel(columnsName, 1);
		setModel(model);
		
	}
	
	public void capNhatDuLieu(ArrayList<HoaDon> dsHoaDon) {
		model.setRowCount(0);
		for(HoaDon hoaDon : dsHoaDon) {
			model.addRow(new Object[] {
				hoaDon.getMaHD(),
				hoaDon.getSoTien(),
				hoaDon.getThoiGianXuat(),
				hoaDon.getPhuongThucThanhToan()
			});
		}
	}
	
	public void toDamHang(int index) {
	    this.setRowSelectionAllowed(true); 
	    this.setRowSelectionInterval(index, index); 
	}
}
