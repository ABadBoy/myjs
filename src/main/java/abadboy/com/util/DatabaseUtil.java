package abadboy.com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by peter zhao on 3/18/2016.
 */
public class DatabaseUtil {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/demo?useUnicode=true";

	//  Database credentials
	static final String USER = "root";
	static final String PASS = "root";



	public static Connection getConnection() {
		try {
			Connection conn = null;
			Statement stmt = null;

			Class.forName(JDBC_DRIVER).newInstance();
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			return conn;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
