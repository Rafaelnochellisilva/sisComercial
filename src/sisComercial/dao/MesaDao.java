package sisComercial.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sisComercial.model.Categoria;
import sisComercial.model.Mesa;
import sisComercial.util.AcoesBasicas;
import sisComercial.util.ConexaoDb;

public class MesaDao extends ConexaoDb implements AcoesBasicas<Mesa> {

	@Override
	public void salvar(Mesa mesa) {
		open();
		try {
			String sql = "INSERT INTO mesa (id_mesa,capacidade,de_reserva,status,numero)VALUES(?,?,?,?,?);";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1,mesa.getId());
			stm.setInt(2, mesa.getCapacidade());
			stm.setBoolean(3, mesa.isReserva());
			stm.setString(4, mesa.getStatus());
			stm.setString(5, mesa.getNumero());
			stm.execute();			
		} catch (SQLException e) {
			System.err.println("Erro ao criar Mesa!!"+e);
		}finally {
			close();
		}
		
	}

	@Override
	public void apagar(Mesa mesa) {
		open();
		try{
			String sql=" DELETE FROM mesa WHERE id_mesa = ?";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, mesa.getId());
			stm.executeUpdate();
		}catch (SQLException e) {
			 System.err.println("Erro ao apagar a mesa!! " + e.getMessage());
		}finally {
			close();
		}
		
	}

	@Override
	public void alterar(Mesa mesa) {
		open();
		try{
			String sql = "UPDATE mesa SET  capacidade = ?, de_reserva = ? , status = ?, numero = ? WHERE id_mesa = ?;";
			PreparedStatement stm = conn.prepareStatement(sql);			
			stm.setInt(1, mesa.getCapacidade());
			stm.setBoolean(2, mesa.isReserva());
			stm.setString(3, mesa.getStatus());
			stm.setString(4, mesa.getNumero());
			stm.setString(5, mesa.getId());
			stm.executeUpdate();			
		}catch (SQLException e) {
			System.err.println("Erro ao Atualizar a mesa"+e.getMessage());
		}finally {
			close();
		}
		
	}
	
	public Mesa buscaMesa(String id) {
		Mesa mesa = null;
		open();
		try {
			String sql = "SELECT * FROM mesa WHERE id_mesa = ?";
			ResultSet rs;
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, id);
			rs = stm.executeQuery();
			
			while (rs.next()) {
				int capacidade = rs.getInt("capacidade");
				String status = rs.getString("status");
				boolean reserva = rs.getBoolean("de_reserva");
				String numero = rs.getString("numero");
				mesa = new Mesa(capacidade, reserva,status, numero);
				mesa.setId(id);

			}
		} catch (SQLException e) {
			System.err.println("Mesa Invalida!!" + e.getMessage());
		} finally {
			close();
		}
		return mesa;

	}
	public List<Mesa>listarMesas(){
		ArrayList<Mesa>mesas = new ArrayList<>();
		open();
		try{
			ResultSet rs;
			String sql="SELECT * FROM mesa";
			PreparedStatement stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id_mesa");
				int capacidade =rs.getInt("capacidade");
				boolean reserva = rs.getBoolean("de_reserva");
				String status = rs.getString("status");
				String numero = rs.getString("numero");
				Mesa mesa =new Mesa(capacidade,reserva,status,numero);
				mesa.setId(id);
				mesas.add(mesa);				
			}
			
		}catch (SQLException e) {
			System.err.println("Não foi possivél listar mesas!"+e);
		}finally {
			close();
		}
		return mesas;
				
	}
	

}
