package br.com.teste.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/java_web_aplication?autoReconnect=true&useSSL=false";
	
	public static Connection createConnectionToMySql() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		
		return connection;
	}
	
	public static void main(String[] args) throws Exception {
		Connection con  = createConnectionToMySql();
		
		if(con != null) {
			System.out.println("conexao bem sucedida");
			con.close();
		}
	}
	
}
