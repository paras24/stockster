/**
 * 
 */
package globalsol.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author manoj.singh
 *
 */
public class Database {
	
	public Connection getConnection(){
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/globalsoldb","root","root");
			Statement smt = conn.createStatement();
			ResultSet rst = smt.executeQuery("select * from services");
			while (rst.next()) {
				
				System.out.println(rst.getInt("id"));
				System.out.println(rst.getString("title"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return conn;
	}
	
	public static void main(String[] args) {
		Database obj = new Database();
		obj.getConnection();
	}

}
