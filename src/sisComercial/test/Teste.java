package sisComercial.test;

import java.util.List;

import sisComercial.dao.MesaDao;
import sisComercial.model.Mesa;

public class Teste {
	public static void main(String[] args) {
		/*Usuario usuario =new Usuario("Rafael", "rafa1983", "(44)3023-7710",TipoDeAcesso.ADMINISTRADOR);
		UsuarioDao usuarioDao = new UsuarioDao();
		usuarioDao.salvar(usuario);
		
		Estado estado =new Estado("Paraná", "PR");
		EstadoDao estadoDao=new EstadoDao();
		estadoDao.salvar(estado);
		
		Cidade cidade = new Cidade("Maringá",estado);
		CidadeDao cidadedao = new CidadeDao();
		cidadedao.salvar(cidade);
		
		Endereco endereco =new Endereco("87060-410", "Rua Marcilho Zequin ", "583", "Assobradado A", cidade);
		EnderecoDao enderecodao = new EnderecoDao();
		enderecodao.salvar(endereco);
		
		String numeroCpf= "04003817966";
		Cpf cpf = new Cpf(numeroCpf);
		CpfDao cpfdao = new CpfDao();
		cpfdao.salvar(cpf);
		
		//System.out.println("O numero do cpe é"+cpf.getNumeroCpf());
		
		Rg rg = new Rg("sspr", Calendar.getInstance(), "89988998");
		RgDao rgDao = new RgDao();
		rgDao.salvar(rg);
		
		//System.out.println(rg.getId()+rg.getOrgaoEmissor()+rg.getDataEmissao()+rg.getNumeroRg());
		
		CarteiraTrabalho carteiraTrabalho = new CarteiraTrabalho("111213222", "43334");
		CarteiraTrabalhoDao carteiraTrabalhoDao = new CarteiraTrabalhoDao();
		carteiraTrabalhoDao.salvar(carteiraTrabalho);
		
		Funcionario funcionario = new Funcionario("Rafael Nochelli da Silva", 1222.6, 322.7, 45.6, 1499.9, 1233.9, 433.7, 1988.7, usuario, cpf, rg, carteiraTrabalho, endereco, Calendar.getInstance());
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		funcionarioDao.salvar(funcionario);*/
		
		/*Categoria categoria = new Categoria("Bebida","ativa");
		CategoriaDao categoriaDao = new CategoriaDao();		
		categoriaDao.salvar(categoria);
		//System.out.println(categoriaDao.verificaCategoria("Comida"));
		
		/*Cardapio cardapio = new Cardapio("Garaná Antartica 2 litros",123.5,"ativo",categoria);
		CardapioDao cardapioDao =new CardapioDao();
		cardapioDao.salvar(cardapio);*/
		//Server server =new Server();
		Mesa mesa = new Mesa(4, true, "ocupada", "4");
		MesaDao mesaDao = new MesaDao();
		/*mesaDao.salvar(mesa);*/
		List<Mesa> mesas = mesaDao.listarMesas();
		
		for (Mesa mesa2 : mesas) {
			if(mesa2.getStatus().equals("ocupada"))
			System.out.println(mesa2.getNumero());
		}
		
	}
}
