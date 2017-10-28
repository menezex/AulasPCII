package etec.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import etec.model.Pessoa;
import etec.persistence.*;

public class PessoaDAO<T extends Pessoa> implements IDAO<T>{
	
	Connection conn;
	
	public PessoaDAO(Connection conn) {
		this.conn = conn;
	}
	

	

	
	public void inserir(T o) throws Exception {
		String sql = "insert into pessoa (nome) values ('"+   ((Pessoa)o).getLogin()    +"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.execute();		
	}




    @Override
	public List listar() throws Exception {
		
	List<Pessoa> listaDePessoas = new ArrayList<>();
		PreparedStatement prepareStatement = conn.prepareStatement("select * from pessoa");
		ResultSet rs = prepareStatement.executeQuery();
		while(rs.next()) {
			String nome = rs.getString("nome");
			Pessoa p = new Pessoa(nome);
			listaDePessoas.add(p);
		}
		return listaDePessoas;		
	}
	
    
	public boolean checkLogin (String pessoa) throws Exception {
		Connection conn = ConexaoFactory.getMysqlConnection();
		String sql ="SELECT * FROM pessoa WHERE nome = ?";
		boolean check = false;
		
		PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, pessoa);
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				check = true;
			}else {
				JOptionPane.showMessageDialog(null, "Usuario ou senha estão invalidos");
			}
		return check;
		
}
	
}
