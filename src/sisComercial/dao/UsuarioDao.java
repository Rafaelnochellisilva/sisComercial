package sisComercial.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import sisComercial.model.Usuario;
import sisComercial.util.AcoesBasicas;
import sisComercial.util.ConexaoDb;

public class UsuarioDao extends ConexaoDb implements AcoesBasicas<Usuario> {

	@Override
	public void salvar(Usuario usuario) {
		open();
		String sql ="INSERT INTO usuario (id_usuario, nome, senha, telefone,tipoAcesso) VALUES (?, ?, ?, ?,?)";
		try {
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, usuario.getId());
			stm.setString(2, usuario.getNome());
			stm.setString(3, usuario.getSenha());
			stm.setString(4, usuario.getTelefone());
			stm.setString(5, usuario.getTipoDeAcesso().name());
			stm.execute();
		} catch (SQLException e) {
			System.err.println("Erro ao criar o Usuario!! " + e.getMessage());
		}finally {
			close();
		}
		
	}

	@Override
	public void apagar(Usuario usuario) {
		
		
	}

	@Override
	public void alterar(Usuario usuario) {
		
		
	}



}
