package sisComercial.controller;

import java.math.BigDecimal;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.text.TabableView;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sisComercial.dao.ItemCardapioDao;
import sisComercial.dao.MesaDao;
import sisComercial.dao.PedidoDao;
import sisComercial.model.ItemCardapio;
import sisComercial.model.Mesa;
import sisComercial.model.Pedido;
import sisComercial.util.EspecificacoesSoftware;
import sisComercial.util.Local;

public class CaixaMesaController /*extends Application*/ implements Initializable {
	@FXML
	private AnchorPane anchorPaneCaixaPedidoMesa;
	@FXML
	private TableView<Mesa>tableViewmesa;	
	@FXML
	private TableColumn<Mesa, Integer>tableColunmQtdLugar;
	@FXML
	private TableColumn<Mesa, String>tableColunmNumeroMesa;
	@FXML
	private Label labelNumeroPedido;
	@FXML
	private Label labelToTalPedido;
	
	@FXML
	private TableView<ItemCardapio> tableViewItensCardapio;
	@FXML
	private TableColumn<ItemCardapio, String> tableColunmDiscriminacao;
	@FXML
	private TableColumn<ItemCardapio, Integer> tableColunmQuantidade;
	@FXML
	private TableColumn<ItemCardapio, Double> tableColunmPreco;
	@FXML
	private TextField textViewTroco;
	@FXML
	private Label labelTroco;
	
	private List<Mesa>listaDeMesas;
	private ObservableList<Mesa>observableListMesas;
	
	private final MesaDao mesaDao = new MesaDao();
	private final PedidoDao pedidoDao =new PedidoDao();
	private final ItemCardapioDao itemCardapioDao = new ItemCardapioDao();
	
	private List<ItemCardapio> itensDoCardapio;
	private ObservableList<ItemCardapio>observableListItemCardapio;
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		chamarMesas();
		tableViewmesa.getSelectionModel().selectedItemProperty().addListener((observable,oldValue,newValue)->selecionarItemMesa(newValue));
		
	}
	
	public  void chamarMesas(){		
		tableColunmQtdLugar.setCellValueFactory(new PropertyValueFactory<>("capacidade"));
		tableColunmNumeroMesa.setCellValueFactory(new PropertyValueFactory<>("numero"));		
		listaDeMesas = mesaDao.listarMesas();
		for (Mesa mesa : listaDeMesas) {
			if(mesa.getStatus().equals("ocupada"))
			observableListMesas = FXCollections.observableArrayList(listaDeMesas);
			tableViewmesa.setItems(observableListMesas);
		}
		
	}
	
	public void selecionarItemMesa(Mesa mesa){
		Pedido pedido = pedidoDao.buscarPedido(mesa.getId());
		labelNumeroPedido.setText(String.valueOf(pedido.getNumero()));
		itensCardapio(pedido);
		
        	
		
		
	}
	
	public void itensCardapio(Pedido pedido) {
		String valorTroco = "";
		String valorPedido = "";

		double totalPedido = itemCardapioDao.buscarItemcardapio(pedido.getId());
		tableColunmDiscriminacao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
		tableColunmQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
		tableColunmPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
		itensDoCardapio = itemCardapioDao.itensCardapio(pedido.getId());
		observableListItemCardapio = FXCollections.observableArrayList(itensDoCardapio);
		tableViewItensCardapio.setItems(observableListItemCardapio);
		valorPedido = String.valueOf(totalPedido);
		labelToTalPedido.setText(String.valueOf(totalPedido));
		valorTroco = textViewTroco.getText();

	}
	
	
	

}
