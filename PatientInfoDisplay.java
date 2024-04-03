import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PatientInfoDisplay {
    // JDBC URL, username, and password
    static final String JDBC_URL = "jdbc:oracle:thin:@//localhost:1521/xe";
    static final String USERNAME = "your_username";
    static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {

            Statement statement = connection.createStatement();

            String query = "SELECT id, name, problem, bill FROM patients";
            ResultSet resultSet = statement.executeQuery(query);

            System.out.println("Patient Information:");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String problem = resultSet.getString("problem");
                double bill = resultSet.getDouble("bill");

                System.out.println("ID: " + id + ", Name: " + name + ", Problem: " + problem + ", Bill: $" + bill);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
