package connectjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectJDBC {
	static final String URL = "jdbc:postgresql://localhost:5432/jdbc";
	static final String USER = "postgres";
	static final String PASSWORD = "admin";

	public static Connection connectToDB() throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		Connection connect = DriverManager.getConnection(URL, USER, PASSWORD);

		if (connect != null) {
			return connect;
		}
		return null;
	}
}
