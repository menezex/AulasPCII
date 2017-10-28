
package etec;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import etec.model.Disciplina;
import etec.model.Pessoa;
import etec.persistence.ConexaoFactory;
import etec.persistence.DisciplinaDAO;
import etec.persistence.PessoaDAO;

public class Aplicacao {

	public static void main(String[] args) throws Exception {
		
		String nomeDaPessoaQueEstaQuerendoSeLogar = "Gabriel";
		
		Connection mysqlConnection = new ConexaoFactory().getMysqlConnection();
		
		PessoaDAO pessoaDAO = new PessoaDAO(mysqlConnection);		
		Pessoa zezinho = new Pessoa("Zezinho");		
		
		Disciplina dPCII = new Disciplina();
		dPCII.setNome("PCII");
		
		DisciplinaDAO discDAO = new DisciplinaDAO(mysqlConnection);
		discDAO.inserir(dPCII);
		
		pessoaDAO.inserir(zezinho); //PESSOAL AQUI DÁ ERRO POR CAUSA DO GENERICS
		
		//
		List<Pessoa> listaDePessoasCadastradasNoBanco = pessoaDAO.listar();
		
		for(Pessoa pessoaCadastrada : listaDePessoasCadastradasNoBanco) {						
			if(pessoaCadastrada.getLogin().equals(nomeDaPessoaQueEstaQuerendoSeLogar)) {
				System.out.println("Pessoa logada com sucesso");
			}
		}
		
		
		//List<Pessoa> listaDePessoas = new ArrayList();
		//listaDePessoas.add(zezinho);
		//listaDePessoas.add(dPCII);
		
		
		
		//discDAO.inserir(dPCII);		
	}
	
}
