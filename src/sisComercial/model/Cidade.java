package sisComercial.model;

import java.util.UUID;

public class Cidade {
	private String id;
	private String nomeCidade;
	private Estado estado;
	
	public Cidade() {
		this.id = UUID.randomUUID().toString();
	}

	public Cidade(String nomeCidade, Estado estado) {
		this();
		this.nomeCidade = nomeCidade;
		this.estado = estado;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNomeCidade() {
		return nomeCidade;
	}

	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	
	
}
