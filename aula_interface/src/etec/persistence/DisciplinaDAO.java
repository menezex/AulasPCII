package etec.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import etec.model.Disciplina;

public class DisciplinaDAO<T extends Disciplina> implements IDAO<T>{

	private Connection conn;

	public DisciplinaDAO(Connection conn) {
		this.conn = conn;
	}
	
	
	@Override
	public void inserir(T t) throws Exception {
		String sql = "insert into disciplina (nome) values ('"+  ((Disciplina)t).getNome() +"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.execute();
	}


	@Override
	public List listar() throws Exception {
		// TODO Auto-generated method stub
		//
		return null;
	}
	
	
}
