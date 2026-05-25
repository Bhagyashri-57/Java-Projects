import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BirthdayWish extends JFrame implements ActionListener {

    JLabel titleLabel, messageLabel;
    JTextField nameField;
    JButton wishButton, clearButton, exitButton;
    JTextArea displayArea;

    BirthdayWish() {

        // Frame Settings
        setTitle("Birthday Wish Application");
        setSize(600, 500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Background Color
        getContentPane().setBackground(new Color(255, 228, 242));

        // Title
        titleLabel = new JLabel("BIRTHDAY WISH GENERATOR");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.MAGENTA);
        titleLabel.setBounds(120, 30, 400, 40);
        add(titleLabel);

        // Name Label
        messageLabel = new JLabel("Enter Birthday Person Name:");
        messageLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        messageLabel.setBounds(50, 100, 250, 30);
        add(messageLabel);

        // Text Field
        nameField = new JTextField();
        nameField.setBounds(300, 100, 200, 30);
        add(nameField);

        // Wish Button
        wishButton = new JButton("Generate Wish");
        wishButton.setBounds(70, 180, 150, 40);
        wishButton.setBackground(Color.PINK);
        wishButton.addActionListener(this);
        add(wishButton);

        // Clear Button
        clearButton = new JButton("Clear");
        clearButton.setBounds(240, 180, 120, 40);
        clearButton.setBackground(Color.CYAN);
        clearButton.addActionListener(this);
        add(clearButton);

        // Exit Button
        exitButton = new JButton("Exit");
        exitButton.setBounds(380, 180, 120, 40);
        exitButton.setBackground(Color.ORANGE);
        exitButton.addActionListener(this);
        add(exitButton);

        // Text Area
        displayArea = new JTextArea();
        displayArea.setFont(new Font("Monospaced", Font.BOLD, 16));
        displayArea.setEditable(false);
        displayArea.setBackground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setBounds(50, 260, 480, 150);
        add(scrollPane);

        setVisible(true);
    }

    // Action Events
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == wishButton) {

            String name = nameField.getText();

            if (name.isEmpty()) {

                JOptionPane.showMessageDialog(this,
                        "Please Enter Name!");

            } else {

                displayArea.setText("");

                displayArea.append("🎉🎂 HAPPY BIRTHDAY 🎂🎉\n\n");
                displayArea.append("Dear " + name + ",\n\n");
                displayArea.append("Wishing you a day filled with\n");
                displayArea.append("love, happiness, joy and success!\n\n");
                displayArea.append("May all your dreams come true.\n");
                displayArea.append("Have a wonderful year ahead!\n\n");
                displayArea.append("✨ Enjoy Your Special Day ✨");

                JOptionPane.showMessageDialog(this,
                        "Birthday Wish Generated!");
            }

        } else if (e.getSource() == clearButton) {

            nameField.setText("");
            displayArea.setText("");

        } else if (e.getSource() == exitButton) {

            System.exit(0);
        }
    }

    // Main Method
    public static void main(String[] args) {

        new BirthdayWish();
    }
}