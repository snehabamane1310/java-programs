import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DivisionSelectionPage extends JFrame implements ActionListener {
    JButton divisionAButton, divisionBButton;

    public DivisionSelectionPage() {
        setTitle("Select Division");
        setLayout(new FlowLayout());

        divisionAButton = new JButton("Division A");
        divisionAButton.addActionListener(this);
        add(divisionAButton);

        divisionBButton = new JButton("Division B");
        divisionBButton.addActionListener(this);
        add(divisionBButton);

        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == divisionAButton) {
            // Open the student data entry page for Division A
            new StudentDataEntryPage("A");
        } else if (e.getSource() == divisionBButton) {
            // Open the student data entry page for Division B
            new StudentDataEntryPage("B");
        }
        dispose(); // Close the division selection page
    }

    public static void main(String[] args) {
        new DivisionSelectionPage();
    }
}
