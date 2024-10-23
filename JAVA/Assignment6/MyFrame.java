import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    private JButton b1, b2, b3, b4, b5, b6, b7;
    private JTextArea ta, result;

    public MyFrame() {
        setTitle("String Manipulations");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout(10, 10));

        // Create the main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Add label
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        mainPanel.add(new JLabel("Enter your text for String Manipulations:"), gbc);

        // Add text area
        ta = new JTextArea(8, 30);
        ta.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(ta);
        gbc.gridy = 1;
        mainPanel.add(scrollPane, gbc);

        // Create button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 2, 5, 5));
        b1 = new JButton("Count Words");
        b2 = new JButton("Count Characters");
        b3 = new JButton("Count Lines");
        b4 = new JButton("Sentence Case");
        b5 = new JButton("Reverse Words");
        b6 = new JButton("Reverse Text");
        b7 = new JButton("Reset Text");

        // Add buttons to button panel
        buttonPanel.add(b1);
        buttonPanel.add(b2);
        buttonPanel.add(b3);
        buttonPanel.add(b4);
        buttonPanel.add(b5);
        buttonPanel.add(b6);
        buttonPanel.add(b7);

        // Add button panel to main panel
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        mainPanel.add(buttonPanel, gbc);

        // Add result label
        gbc.gridy = 3;
        mainPanel.add(new JLabel("Your Result:"), gbc);

        // Add result text area
        result = new JTextArea(5, 30);
        result.setEnabled(false);
        JScrollPane resultScrollPane = new JScrollPane(result); // Add scroll pane
        gbc.gridy = 4;
        mainPanel.add(resultScrollPane, gbc);

        // Add main panel to the frame
        add(mainPanel, BorderLayout.CENTER);

        // Add action listeners for buttons
        addActionListeners();

        // Set frame visibility
        setVisible(true);
    }

    private void addActionListeners() {
        b1.addActionListener(e -> {
            int words = new StringFunctions(ta.getText()).getWordsCount();
            result.setText("Words Count: " + words);
        });

        b2.addActionListener(e -> {
            int chars = new StringFunctions(ta.getText()).getCharactersCount();
            result.setText("Characters Count: " + chars);
        });

        b3.addActionListener(e -> {
            int lines = new StringFunctions(ta.getText()).getLines();
            result.setText("Lines Count: " + lines);
        });

        b4.addActionListener(e -> {
            String sen = new StringFunctions(ta.getText()).makeSentenceCase();
            result.setText(sen);
        });

        b5.addActionListener(e -> {
            String newStr = new StringFunctions(ta.getText()).reverseWords();
            result.setText(newStr);
        });

        b6.addActionListener(e -> {
            StringBuilder txt = new StringFunctions(ta.getText()).reverseString();
            result.setText(String.valueOf(txt));
        });

        b7.addActionListener(e -> {
            ta.setText("");
            result.setText("");
        });
    }
}
