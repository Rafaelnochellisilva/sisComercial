package sisComercial.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import sisComercial.model.Estado;
import sisComercial.util.AcoesBasicas;
import sisComercial.util.ConexaoDb;

public class EstadoDao extends ConexaoDb implements AcoesBasicas<Estado> {

	@Override
	public void salvar(Estado estado) {
		open();
		String sql ="INSERT INTO estado (id_estado, nome, sigla) VALUES (?, ?, ?)";
		try {
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, estado.getId());
			stm.setString(2, estado.getNomeEstado());
			stm.setString(3, estado.getSigla());			
			stm.execute();
		} catch (SQLException e) {
			System.err.println("Erro ao criar o Estado!! " + e.getMessage());
		}finally {
			close();
		}
		
	}

	@Override
	public void apagar(Estado estado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(Estado estado) {
		// TODO Auto-generated method stub
		
	}

}
