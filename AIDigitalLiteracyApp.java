import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class AIDigitalLiteracyApp extends JFrame {

    private CardLayout card = new CardLayout();
    private JPanel main = new JPanel(card);

    private String user, skill, level;

    private JLabel qLabel = new JLabel("", SwingConstants.CENTER);
    private JButton[] options = new JButton[4];

    private java.util.List<Question> quiz = new ArrayList<>();
    private int index = 0;
    private int score = 0;

    private java.util.List<String> review = new ArrayList<>();

    static class Question {
        String q;
        String[] opt;
        String ans;

        Question(String q, String[] opt, String ans) {
            this.q = q;
            this.opt = opt;
            this.ans = ans;
        }
    }

    public AIDigitalLiteracyApp() {

        setTitle("AI Digital Tutor");
        setSize(800, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        main.add(startPage(), "start");
        main.add(namePage(), "name");
        main.add(skillPage(), "skill");
        main.add(levelPage(), "level");
        main.add(quizPage(), "quiz");
        main.add(resultPage(), "result");

        add(main);
        card.show(main, "start");

        setVisible(true);
    }

    // ---------------- START ----------------
    private JPanel startPage() {
        JPanel p = new JPanel(null);
        JButton b = new JButton("START LEARNING");
        b.setBounds(300, 220, 200, 50);

        b.addActionListener(e -> card.show(main, "name"));

        p.add(b);
        return p;
    }

    // ---------------- NAME ----------------
    private JPanel namePage() {
        JPanel p = new JPanel(null);

        JTextField tf = new JTextField();
        tf.setBounds(250, 150, 200, 40);

        JButton b = new JButton("NEXT");
        b.setBounds(300, 220, 120, 40);

        b.addActionListener(e -> {
            user = tf.getText();
            card.show(main, "skill");
        });

        p.add(tf);
        p.add(b);
        return p;
    }

    // ---------------- SKILL ----------------
    private JPanel skillPage() {
        JPanel p = new JPanel(new GridLayout(6, 1));

        String[] skills = {"Java", "Python", "AI", "ML", "Data Mining"};

        for (String s : skills) {
            JButton b = new JButton(s);
            b.addActionListener(e -> {
                skill = s;
                card.show(main, "level");
            });
            p.add(b);
        }
        return p;
    }

    // ---------------- LEVEL ----------------
    private JPanel levelPage() {
        JPanel p = new JPanel(new GridLayout(3, 1));

        String[] levels = {"Beginner", "Medium", "Advanced"};

        for (String l : levels) {
            JButton b = new JButton(l);
            b.addActionListener(e -> {
                level = l;
                generateQuiz();
                card.show(main, "quiz");
                loadQuestion();
            });
            p.add(b);
        }
        return p;
    }

    // ---------------- QUIZ PAGE ----------------
    private JPanel quizPage() {

        JPanel p = new JPanel(new BorderLayout());

        qLabel.setFont(new Font("Arial", Font.BOLD, 18));
        p.add(qLabel, BorderLayout.NORTH);

        JPanel optPanel = new JPanel(new GridLayout(4, 1));

        for (int i = 0; i < 4; i++) {
            options[i] = new JButton();
            int idx = i;
            options[i].addActionListener(e -> checkAnswer(options[idx]));
            optPanel.add(options[i]);
        }

        p.add(optPanel, BorderLayout.CENTER);

        return p;
    }

    // ---------------- RESULT ----------------
    private JPanel resultPage() {
        JPanel p = new JPanel(new BorderLayout());

        JTextArea ta = new JTextArea();
        JButton b = new JButton("SHOW RESULT");

        b.addActionListener(e -> {
            int percent = (score * 100) / quiz.size();

            StringBuilder sb = new StringBuilder();
            sb.append("USER: ").append(user).append("\n");
            sb.append("SKILL: ").append(skill).append("\n");
            sb.append("LEVEL: ").append(level).append("\n\n");

            sb.append("SCORE: ").append(score).append("/").append(quiz.size()).append("\n");
            sb.append("PERCENTAGE: ").append(percent).append("%\n\n");

            sb.append("REVIEW:\n");
            for (String r : review) sb.append(r).append("\n");

            ta.setText(sb.toString());
        });

        p.add(new JScrollPane(ta), BorderLayout.CENTER);
        p.add(b, BorderLayout.SOUTH);

        return p;
    }

    // ---------------- QUIZ GENERATION (5 RANDOM QUESTIONS) ----------------
    private void generateQuiz() {

        quiz.clear();
        index = 0;
        score = 0;
        review.clear();

        java.util.List<Question> pool = new ArrayList<>();

        // -------- JAVA --------
        if (skill.equals("Java")) {
            pool.add(new Question("Java is?", new String[]{"Language", "Database", "OS", "Browser"}, "Language"));
            pool.add(new Question("File extension?", new String[]{".java", ".py", ".cpp", ".txt"}, ".java"));
            pool.add(new Question("Java supports?", new String[]{"OOP", "Markup", "Query", "None"}, "OOP"));
            pool.add(new Question("JVM stands for?", new String[]{"Java Virtual Machine", "Java Visual Mode", "Join VM", "None"}, "Java Virtual Machine"));
            pool.add(new Question("Garbage collection is?", new String[]{"Memory management", "Loop", "Compiler", "File"}, "Memory management"));
        }

        // -------- PYTHON --------
        if (skill.equals("Python")) {
            pool.add(new Question("Python is?", new String[]{"Language", "Database", "Hardware", "OS"}, "Language"));
            pool.add(new Question("Comment symbol?", new String[]{"#", "//", "/*", "$"}, "#"));
            pool.add(new Question("Python file extension?", new String[]{".py", ".java", ".cpp", ".html"}, ".py"));
            pool.add(new Question("Python is used for?", new String[]{"AI/ML", "Only gaming", "Hardware only", "None"}, "AI/ML"));
            pool.add(new Question("Indentation in Python is?", new String[]{"Important", "Optional", "Ignored", "None"}, "Important"));
        }

        // -------- AI --------
        if (skill.equals("AI")) {
            pool.add(new Question("AI means?", new String[]{"Artificial Intelligence", "Auto Input", "Active Internet", "None"}, "Artificial Intelligence"));
            pool.add(new Question("AI used in?", new String[]{"Chatbots", "Paint", "Excel only", "None"}, "Chatbots"));
            pool.add(new Question("AI is part of?", new String[]{"Computer Science", "Cooking", "Sports", "Music"}, "Computer Science"));
            pool.add(new Question("Example of AI?", new String[]{"Siri", "Notepad", "Paint", "Calculator"}, "Siri"));
            pool.add(new Question("AI works using?", new String[]{"Data", "Paint", "Paper", "Ink"}, "Data"));
        }

        // -------- ML --------
        if (skill.equals("ML")) {
            pool.add(new Question("ML is?", new String[]{"AI subset", "OS", "DB", "Network"}, "AI subset"));
            pool.add(new Question("ML uses?", new String[]{"Algorithms", "Paint", "Music", "Photos"}, "Algorithms"));
            pool.add(new Question("ML improves with?", new String[]{"Data", "Time only", "Luck", "Nothing"}, "Data"));
            pool.add(new Question("ML output is?", new String[]{"Prediction", "Sound", "Image only", "None"}, "Prediction"));
            pool.add(new Question("ML is used in?", new String[]{"Recommendations", "Cooking", "Driving only", "None"}, "Recommendations"));
        }

        // -------- DATA MINING --------
        if (skill.equals("Data Mining")) {
            pool.add(new Question("Data Mining is?", new String[]{"Pattern finding", "Coding", "Gaming", "Typing"}, "Pattern finding"));
            pool.add(new Question("Used for?", new String[]{"Data analysis", "Cooking", "Drawing", "Music"}, "Data analysis"));
            pool.add(new Question("Works on?", new String[]{"Large datasets", "Small notes", "Paper", "Pen"}, "Large datasets"));
            pool.add(new Question("Output is?", new String[]{"Patterns", "Songs", "Images", "None"}, "Patterns"));
            pool.add(new Question("Used in?", new String[]{"Business intelligence", "Sports only", "Cooking", "None"}, "Business intelligence"));
        }

        Collections.shuffle(pool);

        for (int i = 0; i < 5 && i < pool.size(); i++) {
            quiz.add(pool.get(i));
        }
    }

    // ---------------- LOAD QUESTION ----------------
    private void loadQuestion() {

        if (index >= quiz.size()) {
            card.show(main, "result");
            return;
        }

        Question q = quiz.get(index);

        qLabel.setText(q.q);

        for (int i = 0; i < 4; i++) {
            if (i < q.opt.length) {
                options[i].setText(q.opt[i]);
                options[i].setEnabled(true);
                options[i].setBackground(null);
            }
        }
    }

    // ---------------- CHECK ANSWER + AUTO NEXT ----------------
    private void checkAnswer(JButton btn) {

        Question q = quiz.get(index);
        String selected = btn.getText();

        if (selected.equals(q.ans)) {
            btn.setBackground(Color.GREEN);
            score++;
            review.add("Q" + (index + 1) + " Correct");
        } else {
            btn.setBackground(Color.RED);
            review.add("Q" + (index + 1) + " Wrong (Ans: " + q.ans + ")");
        }

        for (JButton b : options) b.setEnabled(false);

        // AUTO NEXT after delay
        Timer t = new Timer(600, e -> {
            index++;
            loadQuestion();
        });
        t.setRepeats(false);
        t.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AIDigitalLiteracyApp::new);
    }
}