package sisComercial.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sisComercial.dao.MesaDao;
import sisComercial.model.Mesa;
import sisComercial.util.Local;

public class MesasController implements Initializable{
	@FXML
	private TableView<Mesa> tableViewMesas;
	@FXML
	private TableColumn<Mesa, Integer> tableColunmCapacidade;
	@FXML
	private TableColumn<Mesa, String>tableColunmStatus;
	@FXML
	private TableColumn<Mesa, Boolean> tableColunmReservada;
	@FXML
	private TableColumn<Mesa,String>tableColunmNumero;
	
	private MesaDao mesaDao = new MesaDao();
	private List<Mesa>mesas;
	private ObservableList<Mesa> observablelistMesas;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		carregarTabelaDeMesas();
		tableViewMesas.getSelectionModel().selectedItemProperty().addListener((observable,oldValue,newValue)->selecionarItemTabelaMesa(newValue));
	}
	
	public void carregarTabelaDeMesas(){
		tableColunmCapacidade.setCellValueFactory(new PropertyValueFactory<>("capacidade"));
		tableColunmNumero.setCellValueFactory(new PropertyValueFactory<>("numero"));
		tableColunmStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
		tableColunmReservada.setCellValueFactory(new PropertyValueFactory<>("reservada"));
		mesas = mesaDao.listarMesas();
		observablelistMesas = FXCollections.observableArrayList(mesas);
		tableViewMesas.setItems(observablelistMesas);
	}
	private void selecionarItemTabelaMesa(Mesa mesa) {
		
		
		
		
	}
	@FXML
	public void botaoInserirMesa() throws IOException{
		Mesa mesa = new Mesa();
		boolean confirma = abreTelaCadastraMesa(mesa);
		if(confirma){
			mesaDao.salvar(mesa);
			carregarTabelaDeMesas();
		}
	}
	@FXML
	public void botaoAlterarMesa() throws IOException{		
		Mesa mesa =tableViewMesas.getSelectionModel().getSelectedItem();
		if(mesa != null){
			boolean confirma = abreTelaCadastraMesa(mesa);
			if(confirma){				
				mesaDao.alterar(mesa);
				carregarTabelaDeMesas();
			}
		}else{
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setContentText("Por favor, escolha uma mesa");
			alert.show();
		}
	}

	@FXML
	public void botaoExcluir() {
		Mesa mesa = tableViewMesas.getSelectionModel().getSelectedItem();
		if (mesa != null) {

			mesaDao.apagar(mesa);
			carregarTabelaDeMesas();

		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setContentText("Por favor, escolha uma mesa");
			alert.show();
		}
	}

	private boolean abreTelaCadastraMesa(Mesa mesa) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(CadastroMesaController.class.getResource(Local.CadastroMesaAdicionarPath));
		AnchorPane page = (AnchorPane)loader.load();
		Stage  dialogStage = new Stage();
		dialogStage.setTitle("Cadastro de Mesa");
		Scene scene = new Scene(page);
		dialogStage.setScene(scene);
		
		CadastroMesaController controller = loader.getController();
		controller.setStage(dialogStage);
		controller.setMesa(mesa);		
		controller.selecionarMesa(mesa);
		
		
		
		dialogStage.showAndWait();
		return controller.isConfirmar();
	}

}
