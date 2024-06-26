package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class MySqlDBConexion {

	private static ResourceBundle rb = ResourceBundle.getBundle("database");

	static {
		try {
			Class.forName(rb.getString("driver"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConexion() {
		Connection salida = null;
		try {
			salida = DriverManager.getConnection(
					rb.getString("url"),
					rb.getString("username"),
					rb.getString("password")
					);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return salida;
	}

}
