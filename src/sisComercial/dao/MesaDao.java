package sisComercial.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(Mesa mesa) {
		// TODO Auto-generated method stub
		
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
