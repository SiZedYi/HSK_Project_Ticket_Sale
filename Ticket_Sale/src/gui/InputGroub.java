package gui;

import java.awt.Dimension;
import java.awt.Font;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.sql.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import enums.InputType;

public class InputGroub extends JPanel {
    private JLabel titlePanel;
    private JTextField field;
    private DatePicker datePicker;
    private JComboBox comboBox;

    public InputGroub(int width, int height, String title, int fontSize, int fieldWidth, int fieldHeight,InputType type) {
    	super();
        initialize(title, fieldWidth, fieldHeight);
        titlePanel.setFont(new Font("Segoe UI", 0, fontSize));
        
        if(type == InputType.DATE) {
        	 datePicker = new DatePicker();
        	 datePicker.setHardSize(new Dimension(fieldWidth, fieldHeight));
        	 add(datePicker);
        }
        else if(type == InputType.STRING){
        	field = new JTextField();
            field.setPreferredSize(new Dimension(fieldWidth, fieldHeight));
            field.setFont(new Font("Segoe UI", 0, fontSize-2));
            add(field);
        }
       
        setPreferredSize(new Dimension(width, height));
    }
    
    public InputGroub(int width, int height, String title, int fontSize, int fieldWidth, int fieldHeight,InputType type, Object[] comboBoxOptions) {
    	super();
        initialize(title, fieldWidth, fieldHeight);
        titlePanel.setFont(new Font("Segoe UI", 0, fontSize));
        comboBox = new JComboBox(comboBoxOptions);
        comboBox.setPreferredSize(new Dimension(fieldWidth, fieldHeight));
        add(comboBox);
        
        setPreferredSize(new Dimension(width, height));
    }

    private void initialize(String title, int fieldWidth, int fieldHeight) {
        titlePanel = new JLabel(title);
        titlePanel.setPreferredSize(new Dimension(fieldWidth - 10, fieldHeight));
        add(titlePanel);

    }

    public String getText() {
        return field.getText();
    }

    public void setText(String newContent) {
        if(field!=null)field.setText(newContent);
    }

    public void setEditable(boolean editable) {
        if(field!=null)field.setEditable(editable);
        if(datePicker!=null) datePicker.setEditable(editable);
        if(comboBox!= null)comboBox.setEditable(editable);
    }
    
    public Date getDate() {
    	return datePicker.getDate();
    }
    
    public void setDate(Date date) {
    	datePicker.setDate(date);
    }
    
    public Object getSelected() {
    	return comboBox.getSelectedItem();
    }
    
    public void setSelected(Object target) {
    	comboBox.setSelectedItem(target);
    }
    
    public void updateComboBox(Object[] newOptions) {
        comboBox.setModel(new DefaultComboBoxModel<>(newOptions));
    }
}

