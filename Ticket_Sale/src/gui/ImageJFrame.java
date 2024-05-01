package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageJFrame extends JPanel {
	private BufferedImage image;
	private int prefWidth, prefHeight;
	public ImageJFrame(String imagePath, int prefWidth, int prefHeight){
		// Đặt kích thước preferred width và preferred height
        this.prefWidth = prefWidth;
        this.prefHeight = prefHeight;

	    //reads the image
	    try {
	    	 // Load hình ảnh từ file
            File file = new File(imagePath);
            image = ImageIO.read(file);
	    } catch (IOException ioe) {
	        System.out.println("Could not read in the pic");
	        //System.exit(0);
	    }

	}

	public Dimension getPreferredSize() {
		return new Dimension(prefWidth, prefHeight);
	}
	//this will draw the image
	public void paintComponent(Graphics g){
	    super.paintComponent(g);
	    if (image != null) {
            // Tính toán tỷ lệ scale theo preferred width và height
            double scaleX = (double) prefWidth / image.getWidth();
            double scaleY = (double) prefHeight / image.getHeight();

            // Chọn tỷ lệ scale nhỏ nhất để không bị méo ảnh
            double scale = Math.min(scaleX, scaleY);

            // Tính toán kích thước mới dựa trên tỷ lệ scale
            int newWidth = (int)  Math.ceil(image.getWidth() * scale);
            int newHeight = (int)  Math.ceil(image.getHeight() * scale);

            // Vẽ ảnh đã scale lên JPanel
            g.drawImage(image, 0, 0, newWidth, newHeight, null);
        }
	}

}
