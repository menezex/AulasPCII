package etec.pc.projeto.persistence;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	public Connection getMysqlConnection() throws Exception{
		String stringDeConex�o = "jdbc:mysql://localhost/escola";
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(stringDeConex�o,"root","");
		return connection;
	}
}