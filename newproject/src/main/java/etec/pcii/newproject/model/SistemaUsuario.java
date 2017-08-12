package etec.pcii.newproject.model;

public class SistemaUsuario extends Pessoa {

	private String login;
	private String senha;
	
	public SistemaUsuario(String nomeCompleto, String login,String senha){
	super(nomeCompleto);
	this.login = login;
	this.senha = senha;
	}
}
