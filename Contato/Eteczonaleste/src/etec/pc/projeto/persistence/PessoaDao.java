package etec.pc.projeto.persistence;

import java.sql.Connection;
import etec.pc.projeto.model.UsuarioSistema;

public class PessoaDao {

	Connection conn;
	
	public PessoaDao(Connection conn){
		this.conn = conn;		
		
	}
	
	public void inserir (UsuarioSistema a){
		String sql = "Insert into Pessoa (nome) values('"+a.getLogin()+"')";
		
		System.out.println(sql);
		
	}
}
