import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class DigitalClock {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Digital Clock");

        JLabel timeLabel = new JLabel();
        timeLabel.setBounds(50, 50, 200, 50);
        timeLabel.setFont(timeLabel.getFont().deriveFont(20f));

        frame.add(timeLabel);

        frame.setSize(300, 200);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true) {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            timeLabel.setText(sdf.format(new Date()));

            try {
                Thread.sleep(1000);
            } catch (Exception e) {}
        }
    }
}