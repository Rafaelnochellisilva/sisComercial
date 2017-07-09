package sisComercial.dao;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import sisComercial.model.Pedido;
import sisComercial.util.AcoesBasicas;
import sisComercial.util.ConexaoDb;

public class PedidoDao extends ConexaoDb implements AcoesBasicas<Pedido> {

	@Override
	public void salvar(Pedido pedido) {
		open();
		try {
			String sql = "INSERT INTO pedido(id_pedido,data,status,total,id_mesa,numero)VALUES(?,?,?,?,?,?);";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, pedido.getId());
			stm.setDate(2, new Date(pedido.getDataPedido().getTimeInMillis()));
			stm.setString(3, pedido.getStatus());
			stm.setDouble(4, pedido.getTotal());
			stm.setString(5, pedido.getMesa().getId());
			stm.setLong(6, pedido.getNumero());
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

}
