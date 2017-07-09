package sisComercial.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import sisComercial.model.Cardapio;
import sisComercial.util.AcoesBasicas;
import sisComercial.util.ConexaoDb;

public class CardapioDao extends ConexaoDb implements AcoesBasicas<Cardapio> {

	@Override
	public void salvar(Cardapio cardapio) {
		open();
		try {
			String sql = "INSERT INTO cardapio (id_cardapio,nome,preco,status,id_categoria)VALUES (?,?,?,?,?)";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, cardapio.getId());
			stm.setString(2, cardapio.getDescricao());
			stm.setDouble(3, cardapio.getPreco());
			stm.setString(4, cardapio.getStatus());
			stm.setString(5, cardapio.getCategoria().getId());
			stm.execute();
		} catch (SQLException e) {
			System.err.println("Erro a o criar Cardapio!!"+e);
		}finally {
			close();
		}
		
		
	}

	@Override
	public void apagar(Cardapio cardapio) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(Cardapio cardapio){
			
		
	}

}

	
	
