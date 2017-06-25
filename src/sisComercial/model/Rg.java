package sisComercial.model;

import java.util.Calendar;
import java.util.UUID;

public class Rg {
	private String id;
	private String orgaoEmissor;
	private Calendar dataEmissao;
	private String numeroRg;

	public Rg() {
		this.id = UUID.randomUUID().toString();
	}

	public Rg(String orgaoEmissor, Calendar dataEmissao, String numeroRg) {
		this();
		this.orgaoEmissor = orgaoEmissor;
		this.dataEmissao = dataEmissao;
		this.numeroRg = numeroRg;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrgaoEmissor() {
		return orgaoEmissor;
	}

	public void setOrgaoEmissor(String orgaoEmissor) {
		this.orgaoEmissor = orgaoEmissor;
	}

	public Calendar getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Calendar dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public String getNumeroRg() {
		return numeroRg;
	}

	public void setNumeroRg(String numeroRg) {
		this.numeroRg = numeroRg;
	}

}
