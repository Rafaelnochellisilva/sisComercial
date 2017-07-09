package sisComercial.model;

import java.util.UUID;

public class Categoria {
	private String id;
	private String nomeCategoria;
	private String status;
	
	public Categoria() {
		this.id = UUID.randomUUID().toString();
	}

	public Categoria(String nomeCategoria, String status) {
		this();
		this.nomeCategoria = nomeCategoria;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
