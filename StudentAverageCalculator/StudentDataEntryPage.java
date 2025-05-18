import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class StudentDataEntryPage extends JFrame implements ActionListener {
    JTextField rollField, nameField, mark1Field, mark2Field, mark3Field;
    JButton submitButton;
    String division;

    final String DB_URL = "jdbc:mysql://localhost:3306/studentdb";
    final String USER = "root";
    final String PASS = "root";

    public StudentDataEntryPage(String division) {
        this.division = division;
        setTitle("Enter Student Data - Division " + division);
        setLayout(new GridLayout(6, 2));

        add(new JLabel("Roll No:"));
        rollField = new JTextField();
        add(rollField);

        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Mark 1:"));
        mark1Field = new JTextField();
        add(mark1Field);

        add(new JLabel("Mark 2:"));
        mark2Field = new JTextField();
        add(mark2Field);

        add(new JLabel("Mark 3:"));
        mark3Field = new JTextField();
        add(mark3Field);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        add(submitButton);

        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String roll = rollField.getText();
            String name = nameField.getText();
            float mark1 = Float.parseFloat(mark1Field.getText());
            float mark2 = Float.parseFloat(mark2Field.getText());
            float mark3 = Float.parseFloat(mark3Field.getText());

            float total = mark1 + mark2 + mark3;
            float percentage = (total / 300) * 100;
            String grade = getGrade(percentage);

            String query = "INSERT INTO division_" + division + " (roll_no, name, mark1, mark2, mark3, total, percentage, grade) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, roll);
            stmt.setString(2, name);
            stmt.setFloat(3, mark1);
            stmt.setFloat(4, mark2);
            stmt.setFloat(5, mark3);
            stmt.setFloat(6, total);
            stmt.setFloat(7, percentage);
            stmt.setString(8, grade);
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(this, "Student data added successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private String getGrade(float percentage) {
        if (percentage >= 90) return "A+";
        else if (percentage >= 80) return "A";
        else if (percentage >= 70) return "B";
        else if (percentage >= 60) return "C";
        else if (percentage >= 50) return "D";
        else return "F";
    }

    public static void main(String[] args) {
        new StudentDataEntryPage("A");
    }
}
