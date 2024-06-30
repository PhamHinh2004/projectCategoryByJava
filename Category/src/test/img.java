package test;

import javax.swing.*;
import java.awt.*;

public class img extends JPanel {
    private ImageIcon imageIcon;

    public img(Image image) {
        this.imageIcon = new ImageIcon(image);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Vẽ hình ảnh lên JPanel
        if (imageIcon != null) {
            Image image = imageIcon.getImage();
            g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }

    // Phương thức này để thay đổi hình ảnh khi cần
    public void setImage(Image image) {
        this.imageIcon = new ImageIcon(image);
        repaint(); // Vẽ lại JPanel
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ImagePanel Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Tạo một JPanel mới và thêm vào JFrame
        img panel = new img(new ImageIcon("C:\\Users\\phamv\\OneDrive\\Desktop\\java.jpg").getImage());
        frame.add(panel);
        
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}
