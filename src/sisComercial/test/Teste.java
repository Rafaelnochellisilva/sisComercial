package sisComercial.test;

import sisComercial.dao.CidadeDao;
import sisComercial.dao.EnderecoDao;
import sisComercial.dao.EstadoDao;
import sisComercial.dao.UsuarioDao;
import sisComercial.model.Cidade;
import sisComercial.model.Endereco;
import sisComercial.model.Estado;
import sisComercial.model.TipoDeAcesso;
import sisComercial.model.Usuario;

public class Teste {
	public static void main(String[] args) {
		/*Usuario usuario =new Usuario("Rafael", "rafa1983", "(44)3023-7710",TipoDeAcesso.ADMINISTRADOR);
		UsuarioDao usuarioDao = new UsuarioDao();
		usuarioDao.salvar(usuario);*/
		
		Estado estado =new Estado("Paraná", "PR");
		EstadoDao estadoDao=new EstadoDao();
		estadoDao.salvar(estado);
		
		Cidade cidade = new Cidade("Maringá",estado);
		CidadeDao cidadedao = new CidadeDao();
		cidadedao.salvar(cidade);
		
		Endereco endereco =new Endereco("87060-410", "Rua Marcilho Zequin ", "583", "Assobradado A", cidade);
		EnderecoDao enderecodao = new EnderecoDao();
		enderecodao.salvar(endereco);
		
		
	}
}
