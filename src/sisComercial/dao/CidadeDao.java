package sisComercial.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import sisComercial.model.Cidade;
import sisComercial.util.AcoesBasicas;
import sisComercial.util.ConexaoDb;

public class CidadeDao extends ConexaoDb implements AcoesBasicas<Cidade>  {

	@Override
	public void salvar(Cidade cidade) {
		open();
		String sql ="INSERT INTO cidade (id_cidade, nomeCidade, id_estado) VALUES (?, ?, ?)";
		try {
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, cidade.getId());
			stm.setString(2, cidade.getNomeCidade());
			stm.setString(3, cidade.getEstado().getId());			
			stm.execute();
		} catch (SQLException e) {
			System.err.println("Erro ao criar o Cidade!! " + e.getMessage());
		}finally {
			close();
		}
		
	}

	@Override
	public void apagar(Cidade cidade) {
		
		
	}

	@Override
	public void alterar(Cidade cidade) {
		
		
	}

}
