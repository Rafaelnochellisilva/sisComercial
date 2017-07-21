package sisComercial.model;

import java.math.BigDecimal;
import java.util.UUID;

public class ItemCardapio {
	private String id;	
	private int quantidade;
	private Cardapio cardapio;
	private Pedido pedido;
	private BigDecimal preco;
	private String descricao;
	

	public ItemCardapio() {
		this.id = UUID.randomUUID().toString();
	}

	public ItemCardapio(int quantidade, Cardapio cardapio, Pedido pedido) {
		this();	
		this.quantidade = quantidade;
		this.cardapio = cardapio;
		this.pedido = pedido;
	}

	public String getId() {
		return id;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setId(String id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "ItemCardapio [id=" + id + ", quantidade=" + quantidade + ", cardapio=" + cardapio + ", pedido=" + pedido
				+ ", preco=" + preco + ", descricao=" + descricao + "]";
	}

	
}
