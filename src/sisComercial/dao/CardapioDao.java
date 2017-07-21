package sisComercial.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import sisComercial.model.Cardapio;
import sisComercial.model.Categoria;
import sisComercial.model.Mesa;
import sisComercial.util.AcoesBasicas;
import sisComercial.util.ConexaoDb;

public class CardapioDao extends ConexaoDb implements AcoesBasicas<Cardapio> {

	@Override
	public void salvar(Cardapio cardapio) {
		open();
		try {
			String sql = "INSERT INTO cardapio (id_cardapio,nome,preco,status,id_categoria)VALUES (?,?,?,?,?)";
			PreparedStatement stm = conn.prepareStatement(sql);
			if (!verificaCardapio(cardapio.getDescricao())) {
				stm.setString(1, cardapio.getId());
				stm.setString(2, cardapio.getDescricao());
				stm.setDouble(3, cardapio.getPreco());
				stm.setString(4, cardapio.getStatus());
				stm.setString(5, cardapio.getCategoria().getId());
				stm.execute();
			}
		} catch (SQLException e) {
			System.err.println("Erro a o criar Cardapio!!" + e.getMessage());
		} finally {
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
	
	public boolean verificaCardapio(String descricao) {
        try {
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM cardapio WHERE nome = ?");
            stm.setString(1, descricao);
            ResultSet rs = stm.executeQuery();
            if (rs.next())
                return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    } 
	
	public Cardapio buscaCardapio(String id) {
		Cardapio cardapio = null;
		open();
		try {
			Categoria categoria = null;
			CategoriaDao categoriaDao = new CategoriaDao();
			String sql = "SELECT * FROM cardapio WHERE id_cardapio = ?";
			ResultSet rs;
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, id);
			rs = stm.executeQuery();
			
			while (rs.next()) {
				String descricao = rs.getString("nome");
				double preco = rs.getDouble("preco");
				String status = rs.getString("status");				
				categoria = categoriaDao.buscaCategoria(rs.getString("id_categoria"));
			    cardapio = new Cardapio(descricao, preco, status, categoria);
				cardapio.setId(rs.getString("id_cardapio"));

			}
		} catch (SQLException e) {
			System.err.println("Cardapio Invalido!!" + e.getMessage());
		} finally {
			close();
		}
		return cardapio;

	}

}

	
	
