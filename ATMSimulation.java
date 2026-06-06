import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ATMSimulation extends JFrame implements ActionListener {

    JLabel l1;
    JTextField t1;
    JButton deposit, withdraw, balance, exit;

    double amount = 10000; 

    public ATMSimulation() {

        setTitle("ATM Simulation");

        l1 = new JLabel("Enter Amount:");
        l1.setBounds(50, 50, 100, 30);

        t1 = new JTextField();
        t1.setBounds(160, 50, 120, 30);

        deposit = new JButton("Deposit");
        deposit.setBounds(30, 120, 100, 30);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(150, 120, 100, 30);

        balance = new JButton("Balance");
        balance.setBounds(270, 120, 100, 30);

        exit = new JButton("Exit");
        exit.setBounds(150, 180, 100, 30);

        deposit.addActionListener(this);
        withdraw.addActionListener(this);
        balance.addActionListener(this);
        exit.addActionListener(this);

        add(l1);
        add(t1);
        add(deposit);
        add(withdraw);
        add(balance);
        add(exit);

        setLayout(null);
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == deposit) {

            double depositAmt = Double.parseDouble(t1.getText());
            amount += depositAmt;

            JOptionPane.showMessageDialog(this,
                    "Amount Deposited Successfully\nCurrent Balance: ₹" + amount);
        }

        else if (e.getSource() == withdraw) {

            double withdrawAmt = Double.parseDouble(t1.getText());

            if (withdrawAmt <= amount) {
                amount -= withdrawAmt;

                JOptionPane.showMessageDialog(this,
                        "Withdrawal Successful\nCurrent Balance: ₹" + amount);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Insufficient Balance!");
            }
        }

        else if (e.getSource() == balance) {

            JOptionPane.showMessageDialog(this,
                    "Current Balance: ₹" + amount);
        }

        else if (e.getSource() == exit) {
            System.exit(0);
        }

        t1.setText("");
    }

    public static void main(String[] args) {
        new ATMSimulation();
    }
}