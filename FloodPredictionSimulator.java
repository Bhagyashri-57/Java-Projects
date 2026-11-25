
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class FloodPredictionSimulator extends JFrame {

    private JTextField rainfallField;
    private JTextField waterLevelField;
    private JTextField soilField;
    private JComboBox<String> drainageBox;

    private JLabel riskLabel;
    private JTextArea recommendationArea;

    public FloodPredictionSimulator() {

        setTitle("Flood Prediction Simulator");
        setSize(650, 620);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        getContentPane().setBackground(new Color(225, 242, 255));
        setLayout(null);

        JLabel heading = new JLabel("FLOOD PREDICTION SYSTEM");
        heading.setFont(new Font("Arial", Font.BOLD, 25));
        heading.setForeground(new Color(15, 75, 130));
        heading.setBounds(115, 20, 450, 40);
        add(heading);

        JLabel subtitle = new JLabel(
            "Enter environmental conditions to analyze flood risk"
        );
        subtitle.setBounds(100, 65, 500, 25);
        add(subtitle);

        // Rainfall input
        addLabel("Rainfall (mm):", 60, 120);
        rainfallField = addField(280, 115);

        // River water level input
        addLabel("River Water Level (m):", 60, 175);
        waterLevelField = addField(280, 170);

        // Soil moisture input
        addLabel("Soil Moisture (%):", 60, 230);
        soilField = addField(280, 225);

        // Drainage condition
        addLabel("Drainage Condition:", 60, 285);

        String[] drainageOptions = {
            "Good", "Moderate", "Poor"
        };

        drainageBox = new JComboBox<>(drainageOptions);
        drainageBox.setBounds(280, 280, 230, 35);
        add(drainageBox);

        // Predict button
        JButton predictButton = new JButton("PREDICT FLOOD RISK");
        predictButton.setBounds(190, 340, 250, 45);
        predictButton.setBackground(new Color(20, 115, 190));
        predictButton.setForeground(Color.WHITE);
        predictButton.setFont(new Font("Arial", Font.BOLD, 15));
        add(predictButton);

        // Risk result
        riskLabel = new JLabel("Flood Risk: Waiting for Analysis");
        riskLabel.setFont(new Font("Arial", Font.BOLD, 19));
        riskLabel.setBounds(90, 405, 500, 35);
        add(riskLabel);

        // Recommendations
        JLabel recommendationTitle = new JLabel(
            "Safety Recommendations:"
        );
        recommendationTitle.setFont(
            new Font("Arial", Font.BOLD, 15)
        );
        recommendationTitle.setBounds(60, 455, 300, 25);
        add(recommendationTitle);

        recommendationArea = new JTextArea();
        recommendationArea.setBounds(60, 485, 520, 75);
        recommendationArea.setEditable(false);
        recommendationArea.setLineWrap(true);
        recommendationArea.setWrapStyleWord(true);
        recommendationArea.setFont(
            new Font("Arial", Font.PLAIN, 13)
        );
        recommendationArea.setBackground(Color.WHITE);
        add(recommendationArea);

        predictButton.addActionListener(e -> predictFlood());

        setVisible(true);
    }

    private void addLabel(String text, int x, int y) {

        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.BOLD, 15));
        label.setBounds(x, y, 210, 30);
        add(label);
    }

    private JTextField addField(int x, int y) {

        JTextField field = new JTextField();
        field.setBounds(x, y, 230, 35);
        field.setFont(new Font("Arial", Font.PLAIN, 15));
        add(field);

        return field;
    }

    private void predictFlood() {

        try {

            double rainfall = Double.parseDouble(
                rainfallField.getText().trim()
            );

            double waterLevel = Double.parseDouble(
                waterLevelField.getText().trim()
            );

            double soilMoisture = Double.parseDouble(
                soilField.getText().trim()
            );

            String drainage = (String)
                drainageBox.getSelectedItem();

            // Validate inputs
            if (rainfall < 0 || rainfall > 1000 ||
                waterLevel < 0 || waterLevel > 20 ||
                soilMoisture < 0 || soilMoisture > 100) {

                JOptionPane.showMessageDialog(
                    this,
                    "Enter valid environmental values."
                );
                return;
            }

            int riskScore = 0;

            // Rainfall analysis
            if (rainfall >= 150) {
                riskScore += 3;
            } else if (rainfall >= 75) {
                riskScore += 2;
            } else if (rainfall >= 30) {
                riskScore += 1;
            }

            // River water level analysis
            if (waterLevel >= 8) {
                riskScore += 3;
            } else if (waterLevel >= 5) {
                riskScore += 2;
            } else if (waterLevel >= 3) {
                riskScore += 1;
            }

            // Soil moisture analysis
            if (soilMoisture >= 90) {
                riskScore += 2;
            } else if (soilMoisture >= 70) {
                riskScore += 1;
            }

            // Drainage analysis
            if (drainage.equals("Poor")) {
                riskScore += 2;
            } else if (drainage.equals("Moderate")) {
                riskScore += 1;
            }

            String risk;
            String recommendations;
            Color resultColor;

            // Flood risk classification
            if (riskScore >= 8) {

                risk = "VERY HIGH FLOOD RISK";
                resultColor = Color.RED;

                recommendations =
                    "URGENT WARNING!\n" +
                    "1. Move to safer and higher locations.\n" +
                    "2. Avoid rivers and flooded roads.\n" +
                    "3. Follow official emergency instructions.";

            } else if (riskScore >= 6) {

                risk = "HIGH FLOOD RISK";
                resultColor = new Color(220, 80, 20);

                recommendations =
                    "1. Stay alert and monitor water levels.\n" +
                    "2. Prepare emergency supplies.\n" +
                    "3. Avoid low-lying areas.";

            } else if (riskScore >= 3) {

                risk = "MODERATE FLOOD RISK";
                resultColor = new Color(210, 150, 0);

                recommendations =
                    "1. Monitor rainfall and river conditions.\n" +
                    "2. Keep emergency contacts ready.\n" +
                    "3. Check nearby drainage systems.";

            } else {

                risk = "LOW FLOOD RISK";
                resultColor = new Color(20, 140, 70);

                recommendations =
                    "1. Conditions appear relatively stable.\n" +
                    "2. Continue monitoring weather conditions.\n" +
                    "3. Maintain proper drainage.";

            }

            riskLabel.setText("Flood Risk: " + risk);
            riskLabel.setForeground(resultColor);

            recommendationArea.setText(
                recommendations
            );

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                this,
                "Please enter valid numerical values."
            );
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() ->
            new FloodPredictionSimulator()
        );
    }
}
