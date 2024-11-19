import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordGuessGame extends JFrame {
    private final String secretWord = "apple"; // The word to guess
    private final String[] hints = {
            "It's a fruit.",
            "It's red or green.",
            "It keeps the doctor away."
    };
    private int attempts = 0;

    private JLabel instructionLabel;
    private JTextField guessField;
    private JButton submitButton;
    private JLabel feedbackLabel;

    public WordGuessGame() {
        setTitle("Word Guess Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);

        // Main panel setup
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(240, 248, 255));
        mainPanel.setLayout(new BorderLayout(10, 10));
        add(mainPanel);

        // Top panel for input and button
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 1, 10, 10));
        inputPanel.setBackground(new Color(240, 248, 255));
        mainPanel.add(inputPanel, BorderLayout.NORTH);

        // Instruction label
        instructionLabel = new JLabel("Guess the word! You have 3 attempts.", JLabel.CENTER);
        instructionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        instructionLabel.setForeground(new Color(25, 25, 112));
        mainPanel.add(instructionLabel, BorderLayout.CENTER);

        // Guess field at the top
        guessField = new JTextField();
        guessField.setFont(new Font("Arial", Font.PLAIN, 14));
        inputPanel.add(guessField);

        // Submit button below the input field
        submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.BOLD, 14));
        submitButton.setBackground(new Color(173, 216, 230));
        submitButton.setForeground(Color.BLACK);
        inputPanel.add(submitButton);

        // Feedback label at the bottom
        feedbackLabel = new JLabel("Hint: " + hints[0], JLabel.CENTER);
        feedbackLabel.setFont(new Font("Arial", Font.ITALIC, 14));
        feedbackLabel.setForeground(new Color(0, 100, 0));
        mainPanel.add(feedbackLabel, BorderLayout.SOUTH);

        // Submit button action listener
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userGuess = guessField.getText().trim().toLowerCase();
                attempts++;

                if (userGuess.equals(secretWord)) {
                    feedbackLabel.setText("Correct! The word is: " + secretWord);
                    feedbackLabel.setForeground(new Color(34, 139, 34));
                    submitButton.setEnabled(false);
                } else if (attempts < 3) {
                    feedbackLabel.setText("Hint: " + hints[attempts]);
                } else {
                    feedbackLabel.setText("Game over! The word was: " + secretWord);
                    feedbackLabel.setForeground(new Color(139, 0, 0));
                    submitButton.setEnabled(false);
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            WordGuessGame game = new WordGuessGame();
            game.setVisible(true);
        });
    }
}
