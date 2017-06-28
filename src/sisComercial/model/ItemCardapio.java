package sisComercial.model;

import java.util.UUID;

public class ItemCardapio {
	private String id;
	private double preco;
	private int quantidade;
	private Cardapio cardapio;
	private Pedido pedido;

	public ItemCardapio() {
		this.id = UUID.randomUUID().toString();
	}

	public ItemCardapio(double preco, int quantidade, Cardapio cardapio, Pedido pedido) {
		this();
		this.preco = preco;
		this.quantidade = quantidade;
		this.cardapio = cardapio;
		this.pedido = pedido;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Cardapio getCardapio() {
		return cardapio;
	}

	public void setCardapio(Cardapio cardapio) {
		this.cardapio = cardapio;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

}
