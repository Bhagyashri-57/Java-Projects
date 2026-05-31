import javax.swing.*;
import java.awt.event.*;

public class ElectricityBillingSystem extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4, l5;
    JTextField t1, t2, t3;
    JButton calculate, clear;
    JTextArea result;

    ElectricityBillingSystem() {

        setTitle("Electricity Billing System");
        setLayout(null);

        l1 = new JLabel("Customer Name");
        l1.setBounds(50, 30, 120, 25);
        add(l1);

        t1 = new JTextField();
        t1.setBounds(180, 30, 150, 25);
        add(t1);

        l2 = new JLabel("Customer ID");
        l2.setBounds(50, 70, 120, 25);
        add(l2);

        t2 = new JTextField();
        t2.setBounds(180, 70, 150, 25);
        add(t2);

        l3 = new JLabel("Units Consumed");
        l3.setBounds(50, 110, 120, 25);
        add(l3);

        t3 = new JTextField();
        t3.setBounds(180, 110, 150, 25);
        add(t3);

        calculate = new JButton("Calculate Bill");
        calculate.setBounds(50, 160, 130, 30);
        calculate.addActionListener(this);
        add(calculate);

        clear = new JButton("Clear");
        clear.setBounds(200, 160, 100, 30);
        clear.addActionListener(this);
        add(clear);

        result = new JTextArea();
        result.setBounds(50, 220, 300, 150);
        add(result);

        setSize(450, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == calculate) {

            String name = t1.getText();
            String id = t2.getText();
            int units = Integer.parseInt(t3.getText());

            double bill;

            if (units <= 100)
                bill = units * 1.5;
            else if (units <= 300)
                bill = 100 * 1.5 + (units - 100) * 2.5;
            else
                bill = 100 * 1.5 + 200 * 2.5 + (units - 300) * 4.0;

            result.setText(
                    "Electricity Bill\n\n" +
                    "Customer Name : " + name + "\n" +
                    "Customer ID   : " + id + "\n" +
                    "Units Used    : " + units + "\n" +
                    "Bill Amount   : ₹" + bill);
        }

        if (e.getSource() == clear) {
            t1.setText("");
            t2.setText("");
            t3.setText("");
            result.setText("");
        }
    }

    public static void main(String[] args) {
        new ElectricityBillingSystem();
    }
}