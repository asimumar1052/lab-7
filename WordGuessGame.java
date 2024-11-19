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
    private JLabel attemptsLabel;

    public WordGuessGame() {
        setTitle("Word Guess Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 350);
        setLocationRelativeTo(null); // Center the window on screen

        // Main panel setup
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(240, 248, 255));
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        add(mainPanel);

        // Title label
        JLabel titleLabel = new JLabel("Welcome to the Word Guess Game!");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(new Color(25, 25, 112));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 0, 10, 0); // Spacing
        mainPanel.add(titleLabel, gbc);

        // Instruction label
        instructionLabel = new JLabel("Guess the word! You have 3 attempts.");
        instructionLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        instructionLabel.setForeground(new Color(25, 25, 112));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        mainPanel.add(instructionLabel, gbc);

        // Guess field and submit button
        guessField = new JTextField();
        guessField.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(guessField, gbc);

        submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.BOLD, 14));
        submitButton.setBackground(new Color(173, 216, 230));
        submitButton.setForeground(Color.BLACK);
        submitButton.setFocusPainted(false);
        gbc.gridx = 1;
        gbc.gridy = 2;
        mainPanel.add(submitButton, gbc);

        // Feedback label
        feedbackLabel = new JLabel("Hint: " + hints[0]);
        feedbackLabel.setFont(new Font("Arial", Font.ITALIC, 14));
        feedbackLabel.setForeground(new Color(0, 100, 0));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        mainPanel.add(feedbackLabel, gbc);

        // Attempts label
        attemptsLabel = new JLabel("Attempts left: 3");
        attemptsLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        attemptsLabel.setForeground(new Color(255, 69, 0));
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        mainPanel.add(attemptsLabel, gbc);

        // Submit button action listener
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userGuess = guessField.getText().trim().toLowerCase();
                attempts++;

                if (userGuess.equals(secretWord)) {
                    feedbackLabel.setText("Correct! The word is: " + secretWord);
                    feedbackLabel.setForeground(new Color(34, 139, 34));
                    attemptsLabel.setText("Attempts left: 0");
                    submitButton.setEnabled(false);
                } else if (attempts < 3) {
                    feedbackLabel.setText("Hint: " + hints[attempts]);
                    attemptsLabel.setText("Attempts left: " + (3 - attempts));
                } else {
                    feedbackLabel.setText("Game over! The word was: " + secretWord);
                    feedbackLabel.setForeground(new Color(139, 0, 0));
                    attemptsLabel.setText("Attempts left: 0");
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
