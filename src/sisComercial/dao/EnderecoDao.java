package sisComercial.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import sisComercial.model.Endereco;
import sisComercial.util.AcoesBasicas;
import sisComercial.util.ConexaoDb;

public class EnderecoDao extends ConexaoDb implements AcoesBasicas<Endereco> {

	@Override
	public void salvar(Endereco endereco) {
		open();
		String sql = "INSERT INTO endereco (id_endereco, cep, logradouro,numero,complemento,id_cidade) VALUES (?, ?, ?,?,?,?)";
		try {
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, endereco.getId());
			stm.setString(2, endereco.getCep());
			stm.setString(3, endereco.getLogradouro());
			stm.setString(4, endereco.getNumero());
			stm.setString(5, endereco.getComplemento());
			stm.setString(6, endereco.getCidade().getId());
			stm.execute();
		} catch (SQLException e) {
			System.err.println("Erro ao criar o Endereco!! " + e.getMessage());
		} finally {
			close();
		}

	}

	@Override
	public void apagar(Endereco endereco) {

	}

	@Override
	public void alterar(Endereco endereco) {

	}

}
