package sisComercial.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import sisComercial.model.ItemCardapio;
import sisComercial.util.AcoesBasicas;
import sisComercial.util.ConexaoDb;

public class ItemCardapioDao extends ConexaoDb implements AcoesBasicas<ItemCardapio> {

	@Override
	public void salvar(ItemCardapio itemCardapio) {
		open();
		try {
			String sql ="INSERT INTO item_cardapio(preco,quantidade,id_cardapio,id_pedido,id_item_cardapio)VALUES(?,?,?,?,?);";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setDouble(1, itemCardapio.getPreco());
			stm.setInt(2, itemCardapio.getQuantidade());
			stm.setString(3, itemCardapio.getCardapio().getId());
			stm.setString(4, itemCardapio.getPedido().getId());
			stm.setString(5, itemCardapio.getId());
			stm.execute();			
			
		} catch (SQLException e) {
			System.err.println("Erro ao Criar itemPedido!!"+e);
		}finally {
			close();
		}
		
	}

	@Override
	public void apagar(ItemCardapio itemCardapio) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(ItemCardapio itemCardapio) {
		// TODO Auto-generated method stub
		
	}
	
}
