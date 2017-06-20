package sisComercial.model;

import java.util.UUID;

public class Estado {
	private String id;
	private String nomeEstado;
	private String sigla;
	
	public Estado() {
		this.id = UUID.randomUUID().toString();
	}

	public Estado(String nomeEstado, String sigla) {
		this();
		this.nomeEstado = nomeEstado;
		this.sigla = sigla;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNomeEstado() {
		return nomeEstado;
	}

	public void setNomeEstado(String nomeEstado) {
		this.nomeEstado = nomeEstado;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	
	
}
