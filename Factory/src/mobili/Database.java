package mobili;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	private static String url = "jdbc:mysql://localhost:3306/factory";
	private static String username = "root";
	private static String password = "root";
	private static Connection connection;

	public static Connection createConnection() {
		try {
			// Create a connection
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
