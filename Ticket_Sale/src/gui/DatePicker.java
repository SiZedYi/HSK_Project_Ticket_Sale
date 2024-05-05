package gui;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Date;
import java.util.Calendar;

public class DatePicker extends JPanel {

    private JComboBox<String> dayComboBox;
    private JComboBox<String> monthComboBox;
    private JComboBox<String> yearComboBox;

    public DatePicker() {
        initUI();
    }

    private void initUI() {
        dayComboBox = new JComboBox<>();
        monthComboBox = new JComboBox<>();
        yearComboBox = new JComboBox<>();

        for (int i = 1; i <= 31; i++) {
            dayComboBox.addItem(String.valueOf(i));
        }

        String[] vietnameseMonths = {"Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12"};
        for (String month : vietnameseMonths) {
            monthComboBox.addItem(month);
        }

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 1900; i <= currentYear; i++) {
            yearComboBox.addItem(String.valueOf(i));
        }

        add(dayComboBox);
        add(monthComboBox);
        add(yearComboBox);
    }

    public Date getDate() {
        int day = Integer.parseInt((String) dayComboBox.getSelectedItem());
        int month = monthComboBox.getSelectedIndex();
        int year = Integer.parseInt((String) yearComboBox.getSelectedItem()) - 1900;
        return new Date(year, month, day);
    }

    public void setDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        int day = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);

        dayComboBox.setSelectedItem(String.valueOf(day));
        monthComboBox.setSelectedIndex(month);
        yearComboBox.setSelectedItem(String.valueOf(year));
    }

    public void setEditable(boolean editable) {
        dayComboBox.setEnabled(editable);
        monthComboBox.setEnabled(editable);
        yearComboBox.setEnabled(editable);
    }
    
    public void setHardSize (Dimension dimension) {
    	dayComboBox.setPreferredSize(new Dimension(dimension.width/4-5,dimension.height));
    	monthComboBox.setPreferredSize(new Dimension(dimension.width/2-5,dimension.height));
    	yearComboBox.setPreferredSize(new Dimension(dimension.width/4+5,dimension.height));
    }
}
