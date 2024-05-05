package gui;

import java.awt.Dimension;
import java.awt.Font;
import java.text.DateFormat;
import java.text.ParseException;
import java.sql.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import enums.InputType;

public class InputGroub extends JPanel {
    private JLabel titlePanel;
    private JTextField field;
    private DatePicker datePicker;
    

    public InputGroub(int width, int height, String title, int fontSize, int fieldWidth, int fieldHeight,InputType type) {
    	super();
        initialize(title, fieldWidth, fieldHeight);
        titlePanel.setFont(new Font("Segoe UI", 0, fontSize));
        
        if(type == InputType.DATE) {
        	 datePicker = new DatePicker();
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
    }
    
    public Date getDate() {
    	return datePicker.getDate();
    }
    
    public void setDate(Date date) {
    	datePicker.setDate(date);
    }

}

