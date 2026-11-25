
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class TypingSpeedChallenge extends JFrame {

    String[] sentences = {
        "Java programming is interesting and useful.",
        "Practice makes a person perfect.",
        "Technology changes the world every day.",
        "Learning coding improves problem solving skills.",
        "Artificial intelligence is transforming our future."
    };

    String currentSentence;
    long startTime;
    boolean started = false;

    JLabel sentenceLabel, timerLabel, resultLabel;
    JTextArea typingArea;
    JButton startButton, submitButton;

    public TypingSpeedChallenge() {

        setTitle("Typing Speed Challenge");
        setSize(650, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        getContentPane().setBackground(new Color(235, 245, 255));
        setLayout(null);

        JLabel heading = new JLabel("TYPING SPEED CHALLENGE");
        heading.setFont(new Font("Arial", Font.BOLD, 25));
        heading.setBounds(125, 25, 450, 40);
        heading.setForeground(new Color(35, 75, 130));
        add(heading);

        JLabel instruction = new JLabel(
            "Type the sentence below as quickly and accurately as possible"
        );
        instruction.setBounds(65, 85, 550, 25);
        add(instruction);

        sentenceLabel = new JLabel();
        sentenceLabel.setFont(new Font("Arial", Font.BOLD, 17));
        sentenceLabel.setForeground(new Color(30, 90, 140));
        sentenceLabel.setBounds(50, 135, 550, 40);
        add(sentenceLabel);

        typingArea = new JTextArea();
        typingArea.setFont(new Font("Arial", Font.PLAIN, 16));
        typingArea.setLineWrap(true);
        typingArea.setWrapStyleWord(true);
        typingArea.setBorder(
            BorderFactory.createLineBorder(Color.GRAY)
        );
        typingArea.setBounds(50, 200, 540, 90);
        typingArea.setEnabled(false);
        add(typingArea);

        timerLabel = new JLabel("Time: 0 seconds");
        timerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        timerLabel.setBounds(50, 310, 200, 30);
        add(timerLabel);

        startButton = new JButton("START TEST");
        startButton.setBounds(100, 355, 150, 40);
        startButton.setBackground(new Color(70, 150, 220));
        startButton.setForeground(Color.WHITE);
        add(startButton);

        submitButton = new JButton("SUBMIT");
        submitButton.setBounds(350, 355, 150, 40);
        submitButton.setBackground(new Color(40, 170, 120));
        submitButton.setForeground(Color.WHITE);
        submitButton.setEnabled(false);
        add(submitButton);

        resultLabel = new JLabel("Your result will appear here");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 15));
        resultLabel.setBounds(50, 415, 550, 30);
        add(resultLabel);

        startButton.addActionListener(e -> startTest());
        submitButton.addActionListener(e -> calculateResult());

        setVisible(true);
    }

    void startTest() {

        Random random = new Random();

        currentSentence = sentences[
            random.nextInt(sentences.length)
        ];

        sentenceLabel.setText(currentSentence);

        typingArea.setText("");
        typingArea.setEnabled(true);
        typingArea.requestFocus();

        startTime = System.currentTimeMillis();
        started = true;

        startButton.setEnabled(false);
        submitButton.setEnabled(true);

        resultLabel.setText("Keep typing...");
    }

    void calculateResult() {

        if (!started) {
            return;
        }

        long endTime = System.currentTimeMillis();

        double timeTaken = (endTime - startTime) / 1000.0;

        String typedText = typingArea.getText();

        int correctCharacters = 0;

        for (int i = 0;
            i < Math.min(typedText.length(), currentSentence.length());
            i++) {

            if (typedText.charAt(i) == currentSentence.charAt(i)) {
                correctCharacters++;
            }
        }

        double accuracy = currentSentence.isEmpty()
                ? 0
                : (correctCharacters * 100.0 /
                currentSentence.length());

        int words = typedText.trim().isEmpty()
                ? 0
                : typedText.trim().split("\\s+").length;

        double minutes = timeTaken / 60.0;

        double wpm = minutes > 0
                ? words / minutes
                : 0;

        timerLabel.setText(
            String.format("Time: %.2f seconds", timeTaken)
        );

        resultLabel.setText(
            String.format(
                "Speed: %.2f WPM | Accuracy: %.2f%%",
                wpm, accuracy
            )
        );

        typingArea.setEnabled(false);
        submitButton.setEnabled(false);
        startButton.setEnabled(true);

        started = false;

        if (accuracy >= 90) {
            JOptionPane.showMessageDialog(
                this,
                "Excellent typing performance!"
            );
        } else {
            JOptionPane.showMessageDialog(
                this,
                "Good attempt! Keep practicing."
            );
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(
            () -> new TypingSpeedChallenge()
        );
    }
}
