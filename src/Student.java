import javax.swing.*;

public class Student {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run()
            {
               createAndShowUI();
            }
        });
    }

    private static void createAndShowUI() {
        JFrame frame = new JFrame("Student Grades Calculator");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Student Grades ");
        titleLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        panel.add(titleLabel);

        for (int i = 0; i < 10; i++) {
            panel.add(createStudentPanel(i + 1));
        }

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    private static JPanel createStudentPanel(int studentNumber) {
        JPanel studentPanel = new JPanel();
        studentPanel.setBorder(BorderFactory.createTitledBorder("Student " + studentNumber));

        JLabel nameLabel = new JLabel("Full Name:");
        JTextField nameField = new JTextField(20);

        JLabel mathLabel = new JLabel("Math Score:");
        JTextField mathField = new JTextField(5);

        JLabel englishLabel = new JLabel("English Score:");
        JTextField englishField = new JTextField(5);

        JLabel physicsLabel = new JLabel("Physics Score:");
        JTextField physicsField = new JTextField(5);

        JLabel chemistryLabel = new JLabel("Chemistry Score:");
        JTextField chemistryField = new JTextField(5);

        JLabel biologyLabel = new JLabel("Biology Score:");
        JTextField biologyField = new JTextField(5);

        JLabel gradeLabel = new JLabel("Grade:");
        JTextField gradeField = new JTextField(2);
        gradeField.setEditable(false);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(e -> {
            int mathScore = Integer.parseInt(mathField.getText());
            int englishScore = Integer.parseInt(englishField.getText());
            int physicsScore = Integer.parseInt(physicsField.getText());
            int chemistryScore = Integer.parseInt(chemistryField.getText());
            int biologyScore = Integer.parseInt(biologyField.getText());
            int total;

            total = mathScore + englishScore + physicsScore + chemistryScore + biologyScore;
            int average = total / 5;
            char grade;
            String message;

            if (average >= 80) {
                grade = 'A';
                message = "Excellent work";
                gradeField.setText(String.valueOf(grade));
            } else {
                if (average >= 70 && average <= 79) {
                    grade = 'B';
                    message = "Good job";
                } else if (average >= 60 && average <= 69) {
                    grade = 'C';
                    message = "Average";
                } else if (average >= 50 && average <= 59) {
                    grade = 'D';
                    message = "Work Harder";
                } else {
                    grade = 'F';
                    message = "Fail";
                }
                gradeField.setText(String.valueOf(grade));
            }

            JOptionPane.showMessageDialog(null, message);

        });

        studentPanel.add(nameLabel);
        studentPanel.add(nameField);
        studentPanel.add(mathLabel);
        studentPanel.add(mathField);
        studentPanel.add(englishLabel);
        studentPanel.add(englishField);
        studentPanel.add(physicsLabel);
        studentPanel.add(physicsField);
        studentPanel.add(chemistryLabel);
        studentPanel.add(chemistryField);
        studentPanel.add(biologyLabel);
        studentPanel.add(biologyField);
        studentPanel.add(gradeLabel);
       studentPanel.add(gradeField);

        studentPanel.add(calculateButton);

        return studentPanel;
    }
}
