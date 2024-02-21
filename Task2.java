import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Task2 extends JFrame implements ActionListener {
    private JLabel[] labels;
    private JTextField[] textFields;
    private JButton calculateButton;

    public Task2() {
        super("Student Grade Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));
        labels = new JLabel[5];
        textFields = new JTextField[5];
        String[] subjects = {"Subject 1", "Subject 2", "Subject 3", "Subject 4", "Subject 5"};

        for (int i = 0; i < 5; i++) {
            labels[i] = new JLabel(subjects[i]);
            textFields[i] = new JTextField();
            panel.add(labels[i]);
            panel.add(textFields[i]);
        }

        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(calculateButton);

        add(panel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateButton) {
            int totalMarks = 0;
            int numSubjects = 0;

            for (int i = 0; i < 5; i++) {
                String marksText = textFields[i].getText();
                if (!marksText.isEmpty()) {
                    try {
                        int marks = Integer.parseInt(marksText);
                        totalMarks += marks;
                        numSubjects++;
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(this, "Invalid input for Subject " + (i + 1),
                                "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
            }

            if (numSubjects == 0) {
                JOptionPane.showMessageDialog(this, "Enter marks for at least one subject",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            double averagePercentage = (double) totalMarks / (numSubjects * 100) * 100;
            String grade = calculateGrade(averagePercentage);

            JOptionPane.showMessageDialog(this, "Total Marks: " + totalMarks +
                    "\nAverage Percentage: " + String.format("%.2f", averagePercentage) + "%" +
                    "\nGrade: " + grade);
        }
    }

    private String calculateGrade(double percentage) {
        if (percentage >= 90) {
            return "A+";
        } else if (percentage >= 80) {
            return "A";
        } else if (percentage >= 70) {
            return "B";
        } else if (percentage >= 60) {
            return "C";
        } else if (percentage >= 50) {
            return "D";
        } else {
            return "F";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Task2::new);
    }
}
