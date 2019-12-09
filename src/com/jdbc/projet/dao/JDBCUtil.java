package com.jdbc.projet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
	
	private static final String url = "jdbc:mysql://localhost/amazon";
	private static final String login = "root";
	private static final String passwd = "";
	private static final String driver = "com.mysql.jdbc.Driver";

	
	public static Connection seConnecter() throws ClassNotFoundException, SQLException {
		// Chargement du driver
		Class.forName(driver);
		return DriverManager.getConnection(url, login, passwd);
	}
}
