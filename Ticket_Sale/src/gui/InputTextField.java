package gui;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InputTextField extends JPanel {
	private JLabel titlePanel;
	private JTextField inputField;
	
	public InputTextField(int width, int height, String title, int inputFieldWidth, int inputFieldHeight) {
		super();
		
		this.titlePanel = new JLabel(title);
		titlePanel.setPreferredSize(new Dimension(width - inputFieldWidth-10, inputFieldHeight));
		
		inputField = new JTextField();
		inputField.setPreferredSize(new Dimension(inputFieldWidth, inputFieldHeight));
		
		add(titlePanel);
		add(inputField);
		setPreferredSize(new Dimension(width, height));
	}
	
	public InputTextField(int width, int height, String title, int fontSize, int inputFieldWidth, int inputFieldHeight) {
		super();
		
		this.titlePanel = new JLabel(title);
		titlePanel.setPreferredSize(new Dimension(width - inputFieldWidth-10, inputFieldHeight));
		titlePanel.setFont(new Font("Serif", Font.PLAIN, fontSize));
		
		inputField = new JTextField();
		inputField.setPreferredSize(new Dimension(inputFieldWidth, inputFieldHeight));
		
		add(titlePanel);
		add(inputField);
		setPreferredSize(new Dimension(width, height));
	}
	
	public String getText() {
		return inputField.getText();
	}
	
	public void setText(String newContent) {
		inputField.setText(newContent);
	}
}
