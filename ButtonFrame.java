import javax.swing.JButton;
import javax.swing.JFrame;

public class ButtonFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Button Example");
        JButton button = new JButton("Login");

        button.setBounds(130, 100, 120, 40);

        frame.add(button);
        frame.setSize(400, 300);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}