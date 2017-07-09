package sisComercial.model;

import java.util.UUID;

public class Cardapio {
	private String id;
	private String descricao;
	private double preco;
	private String status;
	private Categoria categoria;
	
	public Cardapio() {
		this.id =UUID.randomUUID().toString();
	}

	public Cardapio(String descricao, double preco, String status, Categoria categoria) {
		this();
		this.descricao = descricao;
		this.preco = preco;
		this.status = status;
		this.categoria = categoria;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	
	

	

}
