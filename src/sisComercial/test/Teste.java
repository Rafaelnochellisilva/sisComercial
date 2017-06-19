package sisComercial.test;

import sisComercial.dao.UsuarioDao;
import sisComercial.model.TipoDeAcesso;
import sisComercial.model.Usuario;

public class Teste {
	public static void main(String[] args) {
		/*Usuario usuario =new Usuario("Rafael", "rafa1983", "(44)3023-7710");
		UsuarioDao usuarioDao = new UsuarioDao();
		usuarioDao.salvar(usuario);*/
		
		System.out.println(TipoDeAcesso.valueOf("ADMINISTRADO" ));
	}
}
