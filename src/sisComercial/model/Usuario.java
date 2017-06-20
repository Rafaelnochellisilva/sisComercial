package sisComercial.model;

import java.util.UUID;

public class Usuario {
	private String id;
	private String nome;
	private String senha;
	private String telefone;
	private TipoDeAcesso tipoDeAcesso;
	public Usuario() {
		this.id = UUID.randomUUID().toString();
	}
	public Usuario(String nome, String senha, String telefone, TipoDeAcesso tipoDeAcesso) {
		this();
		this.nome = nome;
		this.senha = senha;
		this.telefone = telefone;
		this.tipoDeAcesso = tipoDeAcesso;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public TipoDeAcesso getTipoDeAcesso() {
		return tipoDeAcesso;
	}
	public void setTipoDeAcesso(TipoDeAcesso tipoDeAcesso) {
		this.tipoDeAcesso = tipoDeAcesso;
	}
	
	
	
	
	
}
