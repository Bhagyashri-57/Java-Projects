import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TicTacToe extends JFrame implements ActionListener {

    JButton[] buttons = new JButton[9];
    boolean playerX = true;

    public TicTacToe() {
        setTitle("Tic Tac Toe");
        setSize(400, 400);
        setLayout(new GridLayout(3, 3));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton("");
            buttons[i].setFont(new Font("Arial", Font.BOLD, 50));
            buttons[i].addActionListener(this);
            add(buttons[i]);
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();

        if (!button.getText().equals(""))
            return;

        if (playerX) {
            button.setText("X");
        } else {
            button.setText("O");
        }

        playerX = !playerX;
        checkWinner();
    }

    private void checkWinner() {
        int[][] win = {
            {0,1,2}, {3,4,5}, {6,7,8},
            {0,3,6}, {1,4,7}, {2,5,8},
            {0,4,8}, {2,4,6}
        };

        for (int[] w : win) {
            String a = buttons[w[0]].getText();
            String b = buttons[w[1]].getText();
            String c = buttons[w[2]].getText();

            if (!a.equals("") && a.equals(b) && b.equals(c)) {
                JOptionPane.showMessageDialog(this, a + " Wins!");

                int choice = JOptionPane.showConfirmDialog(
                        this,
                        "Play Again?",
                        "Game Over",
                        JOptionPane.YES_NO_OPTION);

                if (choice == JOptionPane.YES_OPTION) {
                    resetGame();
                } else {
                    System.exit(0);
                }
            }
        }
    }

    private void resetGame() {
        for (JButton button : buttons) {
            button.setText("");
        }
        playerX = true;
    }

    public static void main(String[] args) {
        new TicTacToe();
    }
}