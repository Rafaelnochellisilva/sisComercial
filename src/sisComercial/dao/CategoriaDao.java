package sisComercial.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import sisComercial.model.Categoria;
import sisComercial.util.AcoesBasicas;
import sisComercial.util.ConexaoDb;

public class CategoriaDao extends ConexaoDb implements AcoesBasicas<Categoria> {

	@Override
	public void salvar(Categoria categoria) {
		open();
		try {
			String sql = "INSERT INTO categoria(id_categoria,nome,status)VALUES(?,?,?)";
			PreparedStatement stm = conn.prepareStatement(sql);	
			if(!verificaCategoria(categoria.getNomeCategoria())){
				stm.setString(1, categoria.getId());
				stm.setString(2, categoria.getNomeCategoria());
				stm.setString(3, categoria.getStatus());
				stm.execute();
		}
		} catch (SQLException e) {
			System.err.println("Erro ao Criar Categoria!!");
		} finally {
			close();
		}

	}

	@Override
	public void apagar(Categoria categoria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(Categoria categoria) {
		// TODO Auto-generated method stub
		
	}
	public boolean verificaCategoria(String nome) {
        try {
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM categoria WHERE nome = ?");
            stm.setString(1, nome);
            ResultSet rs = stm.executeQuery();
            if (rs.next())
                return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    } 

	public Categoria buscaCategoria(String id) {
		Categoria categoria = null;
		open();
		try {
			String sql = "SELECT * FROM categoria WHERE id_categoria = ?";
			ResultSet rs;
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, id);
			rs = stm.executeQuery();
			
			while (rs.next()) {
				String nome = rs.getString("nome");
				String status = rs.getString("status");
				categoria = new Categoria(nome, status);
				categoria.setId(id);

			}
		} catch (SQLException e) {
			System.err.println("Categoria Invalida!!" + e.getMessage());
		} finally {
			close();
		}
		return categoria;

	}


}
