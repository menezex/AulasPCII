package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	public Connection getMysqlConnection() throws Exception{
		String stringDeConexão = "jdbc:mysql://localhost/escola;user=root;";
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(stringDeConexão,"root","");
		return connection;
	}
}
