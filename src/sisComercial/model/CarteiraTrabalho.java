package sisComercial.model;

import java.util.UUID;

public class CarteiraTrabalho {
	private String id;
	private String numeroCatTrabalho;
	private String serie;
	
	public CarteiraTrabalho() {
		this.id = UUID.randomUUID().toString();
	}

	public CarteiraTrabalho(String numeroCatTrabalho, String serie) {
		this();
		this.numeroCatTrabalho = numeroCatTrabalho;
		this.serie = serie;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNumeroCatTrabalho() {
		return numeroCatTrabalho;
	}

	public void setNumeroCatTrabalho(String numeroCatTrabalho) {
		this.numeroCatTrabalho = numeroCatTrabalho;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}
	
	
}
