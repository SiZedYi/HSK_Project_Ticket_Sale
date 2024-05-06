package gui;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ComboBoxField<E> extends JPanel {
	private JLabel titlePanel;
	private JComboBox comboBoxField;
	
	public ComboBoxField(int width, int height, String title, int inputFieldWidth, int inputFieldHeight, Object[] data) {
		super();
		
		this.titlePanel = new JLabel(title);
		titlePanel.setPreferredSize(new Dimension(width - inputFieldWidth-10, inputFieldHeight));
		
		comboBoxField = new JComboBox<E>();
		comboBoxField.setEditable(true);
		comboBoxField.setPreferredSize(new Dimension(inputFieldWidth, inputFieldHeight));
		
		for(Object obj: data) {
			comboBoxField.addItem(obj);
		}
		add(titlePanel);
		add(comboBoxField);
		setPreferredSize(new Dimension(width, height));
	}
	
	public ComboBoxField(int width, int height, String title, int fontSize, int inputFieldWidth, int inputFieldHeight) {
		super();
		
		this.titlePanel = new JLabel(title);
		titlePanel.setPreferredSize(new Dimension(width - inputFieldWidth-10, inputFieldHeight));
		titlePanel.setFont(new Font("Serif", Font.PLAIN, fontSize));
		
		comboBoxField = new JComboBox<E>();
		comboBoxField.setPreferredSize(new Dimension(inputFieldWidth, inputFieldHeight));
		
		add(titlePanel);
		add(comboBoxField);
		setPreferredSize(new Dimension(width, height));
	}
	
	public Object getSelectedItem() {
		return comboBoxField.getSelectedItem();
	}
	
	public void setSelectedItem(String newContent) {
		comboBoxField.setSelectedItem(newContent);
	}
}
