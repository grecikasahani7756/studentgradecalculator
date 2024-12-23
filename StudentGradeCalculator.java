import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentGradeCalculator extends JFrame {
    
    private JTextField subject1Field, subject2Field, subject3Field, subject4Field, subject5Field;
    private JButton calculateButton;
    private JLabel totalMarksLabel, averageLabel, gradeLabel;
    private JPanel resultPanel;

    public StudentGradeCalculator() {
        setTitle("Student Grade Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel titleLabel = new JLabel("Enter Marks for 5 Subjects (out of 100):");
        add(titleLabel);

        subject1Field = new JTextField(5);
        subject2Field = new JTextField(5);
        subject3Field = new JTextField(5);
        subject4Field = new JTextField(5);
        subject5Field = new JTextField(5);

        add(new JLabel("Subject 1:"));
        add(subject1Field);
        add(new JLabel("Subject 2:"));
        add(subject2Field);
        add(new JLabel("Subject 3:"));
        add(subject3Field);
        add(new JLabel("Subject 4:"));
        add(subject4Field);
        add(new JLabel("Subject 5:"));
        add(subject5Field);

        calculateButton = new JButton("Calculate Grade");
        add(calculateButton);

        resultPanel = new JPanel();
        resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.Y_AXIS));
        totalMarksLabel = new JLabel("Total Marks: ");
        averageLabel = new JLabel("Average Percentage: ");
        gradeLabel = new JLabel("Grade: ");
        
        resultPanel.add(totalMarksLabel);
        resultPanel.add(averageLabel);
        resultPanel.add(gradeLabel);
        add(resultPanel);

        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateGrade();
            }
        });
    }

    private void calculateGrade() {
        try {
            int subject1 = Integer.parseInt(subject1Field.getText());
            int subject2 = Integer.parseInt(subject2Field.getText());
            int subject3 = Integer.parseInt(subject3Field.getText());
            int subject4 = Integer.parseInt(subject4Field.getText());
            int subject5 = Integer.parseInt(subject5Field.getText());

            if (subject1 < 0 || subject1 > 100 || subject2 < 0 || subject2 > 100 || 
                subject3 < 0 || subject3 > 100 || subject4 < 0 || subject4 > 100 || 
                subject5 < 0 || subject5 > 100) {
                JOptionPane.showMessageDialog(this, "Marks must be between 0 and 100.");
                return;
            }

            int totalMarks = subject1 + subject2 + subject3 + subject4 + subject5;
            double averagePercentage = totalMarks / 5.0;

            String grade = calculateGrade(averagePercentage);

            totalMarksLabel.setText("Total Marks: " + totalMarks);
            averageLabel.setText("Average Percentage: " + String.format("%.2f", averagePercentage) + "%");
            gradeLabel.setText("Grade: " + grade);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid marks.");
        }
    }

    private String calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return "A+";
        } else if (averagePercentage >= 80) {
            return "A";
        } else if (averagePercentage >= 70) {
            return "B+";
        } else if (averagePercentage >= 60) {
            return "B";
        } else if (averagePercentage >= 50) {
            return "C";
        } else {
            return "F";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StudentGradeCalculator().setVisible(true);
            }
        });
    }
}
