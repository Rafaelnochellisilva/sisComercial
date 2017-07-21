package sisComercial.model;

import java.util.UUID;

public class Mesa {
	private String id;
	private int capacidade;
	private boolean reserva;	
	private String status;
	private String numero;
	
	public Mesa() {
		this.id = UUID.randomUUID().toString();
		
	}

	public Mesa(int capacidade, boolean reserva, String status, String numero) {
		this();
		this.capacidade = capacidade;
		this.reserva = reserva;
		this.status = status;
		this.numero = numero;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public boolean isReserva() {
		return reserva;
	}

	public void setReserva(boolean reserva) {
		this.reserva = reserva;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Mesa [id=" + id + ", capacidade=" + capacidade + ", reserva=" + reserva + ", status=" + status
				+ ", numero=" + numero + "]";
	}
	

}
	
	
	

	

	
	
	
	
	

