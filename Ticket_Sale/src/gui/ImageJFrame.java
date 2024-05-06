
package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageJFrame extends JPanel {
    private BufferedImage image;
    private int prefWidth, prefHeight;

    public ImageJFrame(String imagePath, int prefWidth, int prefHeight) {
        this.prefWidth = prefWidth;
        this.prefHeight = prefHeight;
        loadImage(imagePath);
    }

    public Dimension getPreferredSize() {
        return new Dimension(prefWidth, prefHeight);
    }

    public void loadImage(String imagePath) {
        try {
            File file = new File(imagePath);
            image = ImageIO.read(file);
            repaint(); // Gọi repaint() để vẽ lại hình ảnh mới
        } catch (IOException ioe) {
            System.out.println("Could not read the image");
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            double scaleX = (double) prefWidth / image.getWidth();
            double scaleY = (double) prefHeight / image.getHeight();
            double scale = Math.min(scaleX, scaleY);
            int newWidth = (int) Math.ceil(image.getWidth() * scale);
            int newHeight = (int) Math.ceil(image.getHeight() * scale);
            int x = (getWidth() - newWidth) / 2;
            int y = (getHeight() - newHeight) / 2;
            g.drawImage(image, x, y, newWidth, newHeight, null);
        }
    }
}

