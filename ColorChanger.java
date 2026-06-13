import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ColorChanger extends JFrame implements ActionListener {

    JButton button;
    int index = 0;

    Color[] colors = {
        Color.RED,
        Color.BLUE,
        Color.GREEN,
        Color.YELLOW,
        Color.ORANGE,
        Color.PINK,
        Color.CYAN,
        Color.MAGENTA,
        Color.LIGHT_GRAY
    };

    ColorChanger() {
        setTitle("Multi Color Changer");
        setSize(400, 300);
        setLayout(null);

        button = new JButton("Change Color");
        button.setBounds(120, 100, 150, 40);
        button.addActionListener(this);
        add(button);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        getContentPane().setBackground(colors[index]);
        index = (index + 1) % colors.length;
    }

    public static void main(String[] args) {
        new ColorChanger();
    }
}