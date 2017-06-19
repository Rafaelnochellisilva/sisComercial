package sisComercial.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoDb {
	private static final String URL = "jdbc:postgresql://localhost:5432/";
	private static final String DATABASE = "sisComercial";	
	private static final String USERNAME = "postgres";
	private static final String PASSWORD = "rafa1983";

	protected Connection conn;
	protected Statement stm;

	public void open(){
		conn = null;
		try {			
			conn = DriverManager.getConnection(URL + DATABASE, USERNAME, PASSWORD);
			stm = conn.createStatement();
		} catch (SQLException e) {
			System.err.println(e);
		} 
		
		System.out.println("Conectado");
	}

	public void close() {
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			System.err.println("Erro ao fechar conexão com o banco:" + e);
		}
	}

}
