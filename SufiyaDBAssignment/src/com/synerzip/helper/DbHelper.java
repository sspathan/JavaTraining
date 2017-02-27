package com.synerzip.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



// TODO: Auto-generated Javadoc
/**
 * The Class DbHelper.
 */
public class DbHelper {

	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 * @throws SQLException the SQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		Connection con = null;
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student" , "root" , "");
		return con;
	}
}
