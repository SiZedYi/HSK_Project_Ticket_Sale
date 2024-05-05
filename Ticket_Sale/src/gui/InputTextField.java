package gui;

import java.awt.Dimension;
import java.awt.Font;
import java.text.DateFormat;
import java.text.ParseException;
import java.sql.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InputTextField extends JPanel {
    private JLabel titlePanel;
    private JTextField field;
    private DateFormat dateFormat;

    public InputTextField(int width, int height, String title, int fieldWidth, int fieldHeight) {
        super();
        initialize(title, fieldWidth, fieldHeight);
        setPreferredSize(new Dimension(width, height));
    }

    public InputTextField(int width, int height, String title, int fontSize, int fieldWidth, int fieldHeight) {
        super();
        initialize(title, fieldWidth, fieldHeight);
        titlePanel.setFont(new Font("Serif", Font.PLAIN, fontSize));
        setPreferredSize(new Dimension(width, height));
    }

    public InputTextField(int width, int height, String title, int fontSize, int fieldWidth, int fieldHeight,
            DateFormat dateFormat) {
        super();
        initialize(title, fieldWidth, fieldHeight);
        titlePanel.setFont(new Font("Serif", Font.PLAIN, fontSize));
        this.dateFormat = dateFormat;
        setPreferredSize(new Dimension(width, height));
    }

    private void initialize(String title, int fieldWidth, int fieldHeight) {
        titlePanel = new JLabel(title);
        titlePanel.setPreferredSize(new Dimension(fieldWidth - 10, fieldHeight));

        field = new JTextField();
        field.setPreferredSize(new Dimension(fieldWidth, fieldHeight));

        add(titlePanel);
        add(field);
    }

    public String getText() {
        return field.getText();
    }

    public void setText(String newContent) {
        field.setText(newContent);
    }

    public void setEditable(boolean editable) {
        field.setEditable(editable);
    }
    

}

