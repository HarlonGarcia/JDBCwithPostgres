package connectjdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {
	public static void main(String[] args) {
		try {
			Connection con = ConnectJDBC.connectToDB();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
