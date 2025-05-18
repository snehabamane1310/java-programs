import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conn {
    public Connection c;
    public Statement s;

    public conn() {
        try {
            // Load the MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection to the MySQL database
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "root");

            // Create a statement object for executing queries
            s = c.createStatement();

            if (c != null) {
                System.out.println("Connection successful!");
            }

        } catch (Exception e) {
            // Print the error stack trace if connection fails
            System.err.println("Connection failed: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return c;
    }

    public static void main(String[] args) {
        new conn();
    }
}
