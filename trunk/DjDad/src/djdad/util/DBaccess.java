package djdad.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBaccess {
public static Connection getConn(){
	Connection conn = null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/djdad","root","root");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}catch (SQLException e) {
		// TODO: handle exception
	}
	
	return conn;
}
}
