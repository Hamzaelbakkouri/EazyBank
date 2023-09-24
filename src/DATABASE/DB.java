package DATABASE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            // Database connection parameters
            String url = "jdbc:postgresql://localhost:5000/postgres";
            String username = "postgres";
            String password = "hamza2018";

            try {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(url, username, password);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                System.err.println("PostgreSQL JDBC driver not found.");
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Database connection error.");
            }
        }
        return connection;
    }
}
