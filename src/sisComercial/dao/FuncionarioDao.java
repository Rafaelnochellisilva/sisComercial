package sisComercial.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import sisComercial.model.Funcionario;
import sisComercial.util.AcoesBasicas;
import sisComercial.util.ConexaoDb;

public class FuncionarioDao extends ConexaoDb implements AcoesBasicas<Funcionario> {

	@Override
	public void salvar(Funcionario funcionario) {
		open();
		String sql = "INSERT INTO funcionario(id_funcionario,nomeFuncionario,salarioBase,"
				+ "complementoSalarial,porcentagenAdiantSalario,salarioCarteira,salarioLiquido"
				+ ",vlAdiantamento,vlsaldoSalario,id_usuario,id_cpf,id_rg,id_cartTrab,id_endereco,dataNascimento) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		try {
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, funcionario.getId());
			stm.setString(2, funcionario.getNomeFuncionario());
			stm.setDouble(3, funcionario.getSalarioBase());
			stm.setDouble(4, funcionario.getComplementoSalarial());
			stm.setDouble(5, funcionario.getPorcentagenAdiantamento());
			stm.setDouble(6, funcionario.getSalarioCarteira());
			stm.setDouble(7, funcionario.getSalarioLiquido());
			stm.setDouble(8, funcionario.getVlAdiantamento());
			stm.setDouble(9, funcionario.getVlsaldoSalario());
			stm.setString(10, funcionario.getUsuario().getId());
			stm.setString(11, funcionario.getCpf().getId());
			stm.setString(12, funcionario.getRg().getId());
			stm.setString(13, funcionario.getCarteiraTrabalho().getId());
			stm.setString(14, funcionario.getEndereco().getId());
			stm.setDate(15, new Date(funcionario.getDataDeNascimento().getTimeInMillis()));
			stm.execute();				
		} catch (SQLException e) {
			System.err.println("Erro ao criar Funcionario!!"+e);
		}finally {
			close();
		}
		
	}

	@Override
	public void apagar(Funcionario funcionario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(Funcionario funcionario) {
		// TODO Auto-generated method stub
		
	}

}
