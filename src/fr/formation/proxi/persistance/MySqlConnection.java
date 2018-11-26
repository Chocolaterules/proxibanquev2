package fr.formation.proxi.persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import fr.formation.proxi.persistance.MySqlConnection;

public class MySqlConnection {
	
	private static final MySqlConnection INSTANCE= new MySqlConnection();
	private Connection conn;

	public Connection getConn() {
		return conn;
	}

	public static MySqlConnection getInstance() {
		return INSTANCE;
	}
	
	public MySqlConnection() {
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proxiv2?serverTimezone=Europe/Paris", "root", "root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
