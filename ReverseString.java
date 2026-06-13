import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class ReverseString extends JFrame implements ActionListener {

    JTextField t1, t2;
    JButton b;

    ReverseString() {
        setSize(300, 200);
        setLayout(null);

        t1 = new JTextField();
        t1.setBounds(50, 30, 150, 25);
        add(t1);

        b = new JButton("Reverse");
        b.setBounds(50, 70, 100, 30);
        b.addActionListener(this);
        add(b);

        t2 = new JTextField();
        t2.setBounds(50, 120, 150, 25);
        add(t2);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String s = t1.getText();
        String rev = new StringBuilder(s).reverse().toString();
        t2.setText(rev);
    }

    public static void main(String[] args) {
        new ReverseString();
    }
}