package sisComercial.dao;

import java.awt.event.ItemEvent;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.text.html.parser.ParserDelegator;

import org.postgresql.core.Parser;

import sisComercial.model.Cardapio;
import sisComercial.model.ItemCardapio;
import sisComercial.model.Mesa;
import sisComercial.model.Pedido;
import sisComercial.util.AcoesBasicas;
import sisComercial.util.ConexaoDb;

public class ItemCardapioDao extends ConexaoDb implements AcoesBasicas<ItemCardapio> {

	@Override
	public void salvar(ItemCardapio itemCardapio) {
		open();
		try {
			String sql ="INSERT INTO item_cardapio(quantidade,id_cardapio,id_pedido,id_item_cardapio)VALUES(?,?,?,?);";
			PreparedStatement stm = conn.prepareStatement(sql);			
			stm.setInt(1, itemCardapio.getQuantidade());
			stm.setString(2, itemCardapio.getCardapio().getId());
			stm.setString(3, itemCardapio.getPedido().getId());
			stm.setString(4, itemCardapio.getId());			
			stm.execute();			
			
		} catch (SQLException e) {
			System.err.println("Erro ao Criar itemPedido!!"+e.getMessage());
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
	
	public List<ItemCardapio>itensCardapio(String id){
		ArrayList<ItemCardapio>itensCardapio = new ArrayList<>();		
		open();
		try{
			CardapioDao cardapioDao = new CardapioDao();
			Cardapio cardapio = null;
			PedidoDao pedidoDao = new PedidoDao();
			Pedido pedido = null;
			ResultSet rs;
			String sql="select * from item_cardapio i WHERE i.id_pedido= ?";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, id);
			rs = stm.executeQuery();
			while (rs.next()) {
				int quantidade = rs.getInt("quantidade");				
				String id_pedido = rs.getString("id_pedido");
				pedido = pedidoDao.buscarPedido(id_pedido);
				String id_cardapio = rs.getString("id_cardapio");
				cardapio = cardapioDao.buscaCardapio(id_cardapio);
				ItemCardapio item = new ItemCardapio(quantidade, cardapio, pedido);
				item.setId(rs.getString("id_item_cardapio"));
				item.setDescricao(cardapio.getDescricao());
				item.setPreco(new BigDecimal(String.valueOf(cardapio.getPreco())));
				itensCardapio.add(item);				
			}
			
		}catch (SQLException e) {
			System.err.println("Não foi possivél listar ItemPedido!"+e.getMessage());
		}finally {
			close();
		}
		return itensCardapio;
				
	}
	public double buscarItemcardapio(String id){
		open();
		double total = 0d;
		ResultSet rs;
		try {
			String sql = "SELECT sum(i.quantidade * c.preco) AS total_pedido FROM item_cardapio i,cardapio c WHERE i.id_pedido =? AND c.id_cardapio = i.id_cardapio";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, id);
			rs = stm.executeQuery();
			
			while (rs.next()) {
				total = rs.getDouble("total_pedido");
				
			}
			
		} catch (SQLException e) {
			System.err.println("Imposivel devolver o total"+e.getMessage());
		}finally {
			close();
		}
		return total;
		
	}
	
}
