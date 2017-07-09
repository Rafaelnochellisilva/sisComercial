package sisComercial.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import sisComercial.model.CarteiraTrabalho;
import sisComercial.model.Categoria;
import sisComercial.util.AcoesBasicas;
import sisComercial.util.ConexaoDb;

public class CarteiraTrabalhoDao extends ConexaoDb implements AcoesBasicas<CarteiraTrabalho> {

	@Override
	public void salvar(CarteiraTrabalho carteiraTrabalho) {
		open();
		String sql = "INSERT INTO carteiraTrabalho(id_cartTrab,numCarteira,serie) VALUES (?,?,?);";
		try {
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, carteiraTrabalho.getId());
			stm.setString(2, carteiraTrabalho.getNumeroCatTrabalho());
			stm.setString(3, carteiraTrabalho.getSerie());
			stm.execute();
		} catch (SQLException e) {
			System.err.println("Erro ao Criar Cateira de Trabalho!!"+""+e);
		}finally {
			close();
		}
		
	}

	@Override
	public void apagar(CarteiraTrabalho carteiraTrabalho) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(CarteiraTrabalho carteiraTrabalho) {
		// TODO Auto-generated method stub
		
	}
	  
	
}
