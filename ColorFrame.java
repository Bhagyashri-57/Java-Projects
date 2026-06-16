import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ColorFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Colorful JFrame");

        JLabel label = new JLabel("HI!", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));

        frame.add(label);
        frame.getContentPane().setBackground(Color.PINK);

        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}