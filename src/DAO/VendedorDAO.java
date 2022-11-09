package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import connectjdbc.ConnectJDBC;

public class VendedorDAO {
	private Connection con;
	
	public VendedorDAO() throws SQLException, ClassNotFoundException {
		con = ConnectJDBC.connectToDB();
	}
}
