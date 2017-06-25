package sisComercial.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import sisComercial.model.Cpf;
import sisComercial.util.AcoesBasicas;
import sisComercial.util.ConexaoDb;

public class CpfDao extends ConexaoDb implements AcoesBasicas<Cpf> {

	@Override
	public void salvar(Cpf cpf) {
		open();
		String sql ="INSERT INTO cpf(id_cpf,numeroCpf)VALUES (?,?);";
		try {
			if(cpf.getNumeroCpf()!=null){
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, cpf.getId());
			stm.setString(2, cpf.getNumeroCpf());
			stm.execute();
			}
		} catch (SQLException e) {
			System.err.println("Erro ao criar o CPF!! " + e.getMessage());
		}finally {
			close();
		}
		
	}

	@Override
	public void apagar(Cpf cpf) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(Cpf cpf) {
		// TODO Auto-generated method stub
		
	}

}
