package sisComercial.dao;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import sisComercial.model.Mesa;
import sisComercial.model.Pedido;
import sisComercial.util.AcoesBasicas;
import sisComercial.util.ConexaoDb;

public class PedidoDao extends ConexaoDb implements AcoesBasicas<Pedido> {

	@Override
	public void salvar(Pedido pedido) {
		open();
		try {
			String sql = "INSERT INTO pedido(id_pedido,data,status,total,id_mesa)VALUES(?,?,?,?,?);";
			PreparedStatement stm = conn.prepareStatement(sql);			
			stm.setString(1, pedido.getId());
			stm.setDate(2, new Date(pedido.getDataPedido().getTimeInMillis()));
			stm.setString(3, pedido.getStatus());
			stm.setDouble(4, pedido.getTotal());
			stm.setString(5, pedido.getMesa().getId());			
			stm.execute();
			
		} catch (SQLException e) {
			System.err.println("Erro ao criar Pedido!!"+e);
		}finally {
			close();
		}
		
	}

	@Override
	public void apagar(Pedido pedido) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(Pedido pedido) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean verificaPedido(Long numero) {
        try {
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM pedido WHERE numero = ?");
            stm.setLong(1,numero);
            ResultSet rs = stm.executeQuery();
            if (rs.next())
                return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    } 
	
	public List<Pedido>listarPedidos(){
		ArrayList<Pedido>pedidos = new ArrayList<>();
		open();
		try{
			MesaDao mesaDao = new MesaDao();
			Mesa mesa = null;
			ResultSet rs;
			String sql="SELECT * FROM pedido";
			PreparedStatement stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id_pedido");
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("data"));				
				String status = rs.getString("status");
				double total = rs.getDouble("total");
				String id_mesa = rs.getString("id_mesa");
				mesa = mesaDao.buscaMesa(id_mesa);
				long numero = rs.getLong("numero");
				Pedido pedido = new Pedido(data, status, total,mesa);
				pedido.setId(id);
				pedido.setNumero(numero);
				pedidos.add(pedido);				
			}
			
		}catch (SQLException e) {
			System.err.println("Não foi possivél listar Pedido!"+e.getMessage());
		}finally {
			close();
		}
		return pedidos;
				
	}
	public Pedido buscarPedido(String id) {
		Pedido pedido = null;
		open();
		try {
			MesaDao mesaDao = new MesaDao();
			Mesa mesa = null;
			String sql = "SELECT * FROM pedido p,mesa  m WHERE p.id_mesa  = ?";
			ResultSet rs;
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, id);
			rs = stm.executeQuery();
			
			while (rs.next()) {
				String id_pedido = rs.getString("id_pedido");
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("data"));				
				String status = rs.getString("status");
				double total = rs.getDouble("total");
				String id_mesa = rs.getString("id_mesa");
				mesa = mesaDao.buscaMesa(id_mesa);
				long numero = rs.getLong("numero");
			    pedido = new Pedido(data, status, total,mesa);
				pedido.setId(id_pedido);
				pedido.setNumero(numero);

			}
		} catch (SQLException e) {
			System.err.println("Mesa Invalida!!" + e.getMessage());
		} finally {
			close();
		}
		return pedido;

	}
	

}
