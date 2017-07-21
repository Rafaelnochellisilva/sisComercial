package sisComercial.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import sisComercial.dao.CardapioDao;
import sisComercial.dao.CategoriaDao;
import sisComercial.dao.ItemCardapioDao;
import sisComercial.dao.MesaDao;
import sisComercial.dao.PedidoDao;
import sisComercial.model.Cardapio;
import sisComercial.model.Categoria;
import sisComercial.model.ItemCardapio;
import sisComercial.model.Mesa;
import sisComercial.model.Pedido;
import sisComercial.model.StatusMesa;

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
		/*Mesa mesa = new Mesa(4, true, "ocupada", "4");
		MesaDao mesaDao = new MesaDao();
		mesaDao.salvar(mesa);
		List<Mesa> mesas = mesaDao.listarMesas();
		
		for (Mesa mesa2 : mesas) {
			if(mesa2.getStatus().equals("ocupada"))
			System.out.println(mesa2.getNumero());
		}*/
		
		
		


		/*Categoria refeicao =new Categoria("Refeição", "Ativa") ;
		Categoria refrigerante = new Categoria("Refrigerante", "Ativa");
		Categoria suco = new Categoria("Suco", "Ativa");;
		Categoria marmitex = new Categoria("Marmitex", "Ativa");;
		Categoria doce = new Categoria("Doce", "Ativa");*/
		
		/*CategoriaDao categoriaDao = new CategoriaDao();		
		Categoria refeicao = categoriaDao.buscaCategoria("33500f8b-7c38-4031-9ab0-1f18d12ef449");				
		Categoria refrigerante = categoriaDao.buscaCategoria("77e9e6aa-9cd2-4446-990b-7bec795eeec8");		
		Categoria suco = categoriaDao.buscaCategoria("29f7ba4a-108f-4267-ade1-6b7566c6a572");		
		Categoria marmitex = categoriaDao.buscaCategoria("9c60c0b1-2068-4f95-a134-2658582436f2");		
		Categoria doce = categoriaDao.buscaCategoria("f6f284f6-554e-4983-b78e-dc5e22fac136");
		
		MesaDao mesaDao = new MesaDao();
		
		Mesa mesa1 = mesaDao.buscaMesa("52012000-6f6d-4cea-ae4d-a0ef66be982a");
		Mesa mesa2 = mesaDao.buscaMesa("dbffd9fb-1391-4cc7-aee0-b037c000068c");
		Mesa mesa3 = mesaDao.buscaMesa("f85905f4-d2ff-42d0-9609-814f0603f0d9");
		Mesa mesa4 = mesaDao.buscaMesa("47cce11f-e714-4f07-8f5e-37186d49a597");
		//System.out.println(mesa1);
		
		
		//Cardapio cardapio = new Cardapio("Refeição", 12.00, "Ativo",refeicao);
		CardapioDao cardapioDao =new CardapioDao();
		
		Cardapio cocaCola1 = cardapioDao.buscaCardapio("d4306554-6331-41e5-8022-45d0e1dacc3b");
		Cardapio cocaCola2 = cardapioDao.buscaCardapio("1322272d-0d37-4d5e-8cea-dcd52208b3e7");
		Cardapio refeicao2 = cardapioDao.buscaCardapio("e41c9ac5-bb72-4a6e-86fb-01ca4d4c89cd");
		Cardapio marmitexMedia = cardapioDao.buscaCardapio("ed339a1a-2ad6-4c51-9d00-dfda4191fa7e");
		Cardapio cocacolaLata = cardapioDao.buscaCardapio("c628d349-c0c6-48ab-938c-64d53b0f1fb6");
		System.out.println(cocaCola1);
		Pedido pedido =new Pedido(Calendar.getInstance(), "Aberto", 49.5, mesa2);
		PedidoDao pedidoDao = new PedidoDao();
		//pedidoDao.salvar(pedido);
		
		List<Pedido>pedidos = pedidoDao.listarPedidos();
		System.out.println(pedidos.get(0));
		
		Pedido ped = pedidoDao.buscarPedido("a8f26b97-2aa4-475c-aa07-a834d0b232cd");
		System.out.println(ped);
		
		/*ItemCardapio itemCardapio = new ItemCardapio(2, cocacolaLata, pedidos.get(0));*/
		//ItemCardapioDao itemCardapioDao = new ItemCardapioDao();
		/*itemCardapioDao.salvar(itemCardapio);*/
		
		//List<ItemCardapio>listaC = itemCardapioDao.itensCardapio("a8f26b97-2aa4-475c-aa07-a834d0b232cd");
		//double ds =itemCardapioDao.buscarItemcardapio("a8f26b97-2aa4-475c-aa07-a834d0b232cd");
		// System.out.println(ds);*/
		//System.out.println(listaC);
		System.out.println(StatusMesa.retornaStatusMesa());

		
		
		
		//Cardapio cardapio = new Cardapio();
		
	}
}
