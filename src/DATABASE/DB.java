package DATABASE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    public static void connection() {
        // Database connection parameters
        String url = "jdbc:postgresql://localhost:5000/postgres";
        String username = "postgres";
        String password = "hamza2018";

        try {
            Class.forName("org.postgresql.Driver");

            Connection connection = DriverManager.getConnection(url, username, password);
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("PostgreSQL JDBC driver not found.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Database connection error.");
        }
    }
}
