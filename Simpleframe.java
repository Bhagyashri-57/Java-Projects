import javax.swing.JFrame;

public class Simpleframe {
    public static void main(String[] args) {
        JFrame frame = new JFrame("My First JFrame");

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
