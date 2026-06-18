import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class SmartAssistGUI extends JFrame implements ActionListener {

    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton, clearButton, exitButton;
    private HashMap<String, String> knowledgeBase;

    public SmartAssistGUI() {

        setTitle("SmartAssist AI Chatbot");
        setSize(900, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // ================= KNOWLEDGE BASE =================
        knowledgeBase = new HashMap<>();

        knowledgeBase.put("hello", "Hello! Welcome to SmartAssist.");
        knowledgeBase.put("hi", "Hi! How can I help you?");
        knowledgeBase.put("college1", "Cambridge Engineering College Main campus k R Puram .");
        knowledgeBase.put("college2", "Cambridge Engineering College North Campus Devanahalli.");
        knowledgeBase.put("principal", "Dr. B V Ravishankar is the Principal.");
        knowledgeBase.put("library", "Library timings are 8:30 AM to 8 PM.");
        knowledgeBase.put("placement", "Top companies visit the campus every year.");
        knowledgeBase.put("fees", "Contact the accounts section for fee details.");
        knowledgeBase.put("hod", "The Head of Department manages academic activities.");
        knowledgeBase.put("ai", "Artificial Intelligence enables machines to learn.");
        knowledgeBase.put("ml", "Machine Learning is a subset of AI.");
        knowledgeBase.put("java", "Java is an object-oriented programming language.");
        knowledgeBase.put("python", "Python is a high-level programming language.");
        knowledgeBase.put("bye", "Thank you for using SmartAssist. Goodbye!");
        knowledgeBase.put("help", "Ask about college, courses, AI, placements, etc.");
        knowledgeBase.put("hod", "The Head of Department manages academic activities.");
        knowledgeBase.put("dean", "The Dean oversees academic and administrative functions.");
        knowledgeBase.put("vision", "To provide quality education and innovation.");
        knowledgeBase.put("mission", "To develop skilled and responsible professionals.");
        knowledgeBase.put("chairman", "Mr. Ramesh Patil is the Chairman of the institution.");
        knowledgeBase.put("vice principal", "The Vice Principal assists in academic administration.");

        knowledgeBase.put("cse subjects", "Data Structures, DBMS, Java, Python, OS, CN.");
        knowledgeBase.put("ece subjects", "Digital Electronics, VLSI, Embedded Systems.");
        knowledgeBase.put("civil subjects", "Surveying, Structural Analysis, Concrete Technology.");
        knowledgeBase.put("mech subjects", "Thermodynamics, Fluid Mechanics, CAD.");

        knowledgeBase.put("lab", "Modern laboratories are available for all departments.");
        knowledgeBase.put("computer lab", "The computer lab has high-speed internet and modern systems.");
        knowledgeBase.put("physics lab", "Physics lab supports practical experiments.");
        knowledgeBase.put("chemistry lab", "Chemistry lab is equipped with advanced instruments.");

        knowledgeBase.put("nss", "National Service Scheme encourages social service activities.");
        knowledgeBase.put("ncc", "National Cadet Corps develops discipline and leadership.");
        knowledgeBase.put("cultural club", "The Cultural Club organizes events and competitions.");
        knowledgeBase.put("coding club", "The Coding Club conducts coding contests and workshops.");
        knowledgeBase.put("robotics club", "The Robotics Club works on automation projects.");

        knowledgeBase.put("internship", "Internship opportunities are provided through industry partnerships.");
        knowledgeBase.put("training", "Technical and soft-skill training programs are conducted.");
        knowledgeBase.put("career guidance", "Career guidance sessions help students plan their future.");
        knowledgeBase.put("resume", "Resume-building workshops are conducted regularly.");

        knowledgeBase.put("recruiters", "Top recruiters include TCS, Infosys, Wipro, and Accenture.");
        knowledgeBase.put("highest package", "The highest package varies each year.");
        knowledgeBase.put("average package", "Average package information is available from the placement cell.");

        knowledgeBase.put("holiday", "Holiday schedules are announced by the administration.");
        knowledgeBase.put("working hours", "College working hours are 8:30 AM to 4 PM.");
        knowledgeBase.put("uniform", "Students are expected to follow the dress code on Monday.");
        knowledgeBase.put("rules", "Students must maintain discipline and attendance.");

        knowledgeBase.put("mba", "MBA program focuses on management and leadership skills.");
        knowledgeBase.put("mca", "MCA program provides advanced computer application knowledge.");
        knowledgeBase.put("btech", "B.Tech is a four-year undergraduate engineering program.");
        knowledgeBase.put("mtech", "M.Tech is a postgraduate engineering program.");

        knowledgeBase.put("artificial intelligence", "AI enables computers to perform intelligent tasks.");
        knowledgeBase.put("data science", "Data Science involves analyzing and interpreting data.");
        knowledgeBase.put("blockchain", "Blockchain is a secure distributed ledger technology.");
        knowledgeBase.put("big data", "Big Data deals with large and complex datasets.");

        knowledgeBase.put("java project", "Java projects help students gain practical programming experience.");
        knowledgeBase.put("python project", "Python projects are useful in AI, ML, and automation.");
        knowledgeBase.put("final year project", "Final year projects demonstrate technical skills and innovation.");

        knowledgeBase.put("Wifi Password", "Wifi password is Cambridge@123.");
        knowledgeBase.put("atm", "ATM facilities are available near the back gate.");
        knowledgeBase.put("Bus Timings", "Bus timings Of our college is from 8:20Am to 4:20 Pm.");
        knowledgeBase.put("lost and found", "Lost and found services are available at the administration office.");

        knowledgeBase.put("smartassist", "SmartAssist is an AI-based chatbot for user assistance.");
        knowledgeBase.put("help", "You can ask questions about college, courses, facilities, and technology.");
        knowledgeBase.put("thanks", "You're welcome! Happy to help.");
        knowledgeBase.put("Thank You", "You're welcome! Have a great day.");
                knowledgeBase.put("thanks", "You're welcome!");

        // ================= TOP HEADER =================
        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(70, 130, 180));

        JLabel title = new JLabel("SMARTASSIST AI CHATBOT SYSTEM");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Verdana", Font.BOLD, 22));

        topPanel.add(title);

        // ================= CHAT AREA =================
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setFont(new Font("Arial", Font.PLAIN, 15));
        chatArea.setBackground(new Color(245, 245, 245));

        JScrollPane scrollPane = new JScrollPane(chatArea);

        chatArea.append("========================================\n");
        chatArea.append("        WELCOME TO SMARTASSIST\n");
        chatArea.append("========================================\n\n");
        chatArea.append("Type or click buttons to ask questions.\n\n");

        // ================= QUICK BUTTON PANEL =================
        JPanel quickPanel = new JPanel(new GridLayout(6, 1, 5, 5));
        quickPanel.setBackground(Color.WHITE);
        quickPanel.setBorder(BorderFactory.createTitledBorder("Quick Access"));

        JButton btnPrincipal = new JButton("Principal");
        JButton btnHOD = new JButton("HOD");
        JButton btnCollege = new JButton("College");
        JButton btnAI = new JButton("AI");
        JButton btnLibrary = new JButton("Library");
        JButton btnFees = new JButton("Fees");
        JButton btnchairman = new JButton("Chairman");
        JButton btnbustimings = new JButton("Bus timings");
        JButton btnwifipassword = new JButton("Wifi Password");
        JButton btnthankyou = new JButton("Thank You");

        quickPanel.add(btnPrincipal);
        quickPanel.add(btnHOD);
        quickPanel.add(btnCollege);
        quickPanel.add(btnAI);
        quickPanel.add(btnLibrary);
        quickPanel.add(btnFees);
        quickPanel.add(btnchairman);
        quickPanel.add(btnbustimings);
        quickPanel.add(btnwifipassword);
        quickPanel.add(btnthankyou);

        // ================= BOTTOM INPUT PANEL =================
        JPanel bottomPanel = new JPanel(new BorderLayout(10, 10));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        inputField = new JTextField();
        inputField.setFont(new Font("Arial", Font.PLAIN, 16));

        JPanel buttonPanel = new JPanel();

        sendButton = new JButton("Send");
        clearButton = new JButton("Clear");
        exitButton = new JButton("Exit");

        sendButton.setBackground(new Color(144, 238, 144));
        clearButton.setBackground(new Color(255, 255, 153));
        exitButton.setBackground(new Color(255, 160, 122));

        buttonPanel.add(sendButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(exitButton);

        bottomPanel.add(inputField, BorderLayout.CENTER);
        bottomPanel.add(buttonPanel, BorderLayout.EAST);

        // ================= ADD COMPONENTS =================
        add(topPanel, BorderLayout.NORTH);
        add(quickPanel, BorderLayout.WEST);
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // ================= EVENTS =================

        sendButton.addActionListener(this);

        inputField.addActionListener(e -> sendButton.doClick());

        clearButton.addActionListener(e -> {
            chatArea.setText("");
            chatArea.append("Chat Cleared!\n\n");
        });

        exitButton.addActionListener(e -> System.exit(0));

        // ===== BUTTON ACTIONS =====
        btnPrincipal.addActionListener(e -> sendQuick("principal"));
        btnHOD.addActionListener(e -> sendQuick("hod"));
        btnCollege.addActionListener(e -> sendQuick("college"));
        btnAI.addActionListener(e -> sendQuick("ai"));
        btnLibrary.addActionListener(e -> sendQuick("library"));
        btnFees.addActionListener(e -> sendQuick("fees"));
        btnchairman.addActionListener(e -> sendQuick("chairman"));
        btnbustimings.addActionListener(e -> sendQuick("Bus Timings"));
        btnwifipassword.addActionListener(e -> sendQuick("Wifi Password"));
        btnthankyou.addActionListener(e -> sendQuick("Thank You"));
        


        setVisible(true);
    }

    // ================= SEND BUTTON =================
    @Override
    public void actionPerformed(ActionEvent e) {

        String query = inputField.getText().trim().toLowerCase();

        if (!query.isEmpty()) {

            chatArea.append("You: " + query + "\n");

            String response = knowledgeBase.getOrDefault(query,
                    "Sorry! Information not found. Try buttons.");

            chatArea.append("SmartAssist: " + response + "\n\n");

            inputField.setText("");
        }
    }

    // ================= QUICK BUTTON FUNCTION =================
    private void sendQuick(String text) {

        chatArea.append("You: " + text + "\n");

        String response = knowledgeBase.getOrDefault(text,
                "Sorry! Information not found.");

        chatArea.append("SmartAssist: " + response + "\n\n");
    }

    // ================= MAIN METHOD =================
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SmartAssistGUI());
    }
}