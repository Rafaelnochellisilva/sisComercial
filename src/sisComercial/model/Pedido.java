package sisComercial.model;

import java.util.Calendar;
import java.util.UUID;

public class Pedido {
	private String id;	
	private Calendar dataPedido;
	private String status;
	private double total;
	private Mesa mesa;
	private long numero;
	
	public Pedido() {
		this.id = UUID.randomUUID().toString();
	}

	public Pedido(Calendar dataPedido, String status, double total, Mesa mesa,long numero) {
		this();
		this.dataPedido = Calendar.getInstance();
		this.status = status;
		this.total = total;
		this.mesa = mesa;
		this.numero = numero;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Calendar getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Calendar dataPedido) {
		this.dataPedido = dataPedido;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}
	
	
	
	
}
