package sisComercial.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import sisComercial.model.Rg;
import sisComercial.util.AcoesBasicas;
import sisComercial.util.ConexaoDb;

public class RgDao extends ConexaoDb implements AcoesBasicas<Rg>{

	@Override
	public void salvar(Rg rg) {
		open();
		String sql = "INSERT INTO rg(id_rg,orgaoEmissor,dataEmissao,numeroRg) VALUES (?,?,?,?) ";
		try {
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1,rg.getId());
			stm.setString(2, rg.getOrgaoEmissor());
			stm.setDate(3, new Date(rg.getDataEmissao().getTimeInMillis()));
			stm.setString(4, rg.getNumeroRg());
			stm.execute();
		} catch (SQLException e) {
			System.err.println("Erro ao cliar RG!!"+e);
		}finally {
			close();
		}
		
	}

	@Override
	public void apagar(Rg rg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(Rg rg) {
		// TODO Auto-generated method stub
		
	}
	
	
}
