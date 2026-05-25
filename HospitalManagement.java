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

public class HospitalManagement extends JFrame implements ActionListener {

    JLabel titleLabel, idLabel, nameLabel, ageLabel, diseaseLabel;

    JTextField idField, nameField, ageField, diseaseField;

    JButton addButton, clearButton, exitButton;

    JTextArea displayArea;

    HospitalManagement() {

        setTitle("Hospital Management System");

        setLayout(null);

        getContentPane().setBackground(new Color(220, 240, 255));

        titleLabel = new JLabel("HOSPITAL MANAGEMENT SYSTEM");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setBounds(120, 20, 400, 30);
        add(titleLabel);

        idLabel = new JLabel("Patient ID:");
        idLabel.setBounds(50, 80, 100, 25);
        add(idLabel);

        idField = new JTextField();
        idField.setBounds(180, 80, 180, 25);
        add(idField);

        nameLabel = new JLabel("Patient Name:");
        nameLabel.setBounds(50, 120, 100, 25);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(180, 120, 180, 25);
        add(nameField);

        ageLabel = new JLabel("Age:");
        ageLabel.setBounds(50, 160, 100, 25);
        add(ageLabel);

        ageField = new JTextField();
        ageField.setBounds(180, 160, 180, 25);
        add(ageField);

        diseaseLabel = new JLabel("Disease:");
        diseaseLabel.setBounds(50, 200, 100, 25);
        add(diseaseLabel);

        diseaseField = new JTextField();
        diseaseField.setBounds(180, 200, 180, 25);
        add(diseaseField);

        addButton = new JButton("Add Patient");
        addButton.setBounds(50, 260, 120, 35);
        addButton.addActionListener(this);
        add(addButton);

        clearButton = new JButton("Clear");
        clearButton.setBounds(190, 260, 100, 35);
        clearButton.addActionListener(this);
        add(clearButton);

        exitButton = new JButton("Exit");
        exitButton.setBounds(310, 260, 100, 35);
        exitButton.addActionListener(this);
        add(exitButton);

        displayArea = new JTextArea();
        displayArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setBounds(50, 320, 500, 180);
        add(scrollPane);

        setSize(650, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == addButton) {

            String id = idField.getText();
            String name = nameField.getText();
            String age = ageField.getText();
            String disease = diseaseField.getText();

            if (id.isEmpty() || name.isEmpty() || age.isEmpty() || disease.isEmpty()) {

                JOptionPane.showMessageDialog(this,
                        "Please fill all fields!");

            } else {

                displayArea.append("===== PATIENT DETAILS =====\n");
                displayArea.append("Patient ID   : " + id + "\n");
                displayArea.append("Patient Name : " + name + "\n");
                displayArea.append("Age          : " + age + "\n");
                displayArea.append("Disease      : " + disease + "\n");
                displayArea.append("------------------------------\n");

                JOptionPane.showMessageDialog(this,
                        "Patient Added Successfully!");
            }

        } else if (e.getSource() == clearButton) {

            idField.setText("");
            nameField.setText("");
            ageField.setText("");
            diseaseField.setText("");

        } else if (e.getSource() == exitButton) {

            System.exit(0);
        }
    }

    public static void main(String[] args) {

        new HospitalManagement();
    }
}