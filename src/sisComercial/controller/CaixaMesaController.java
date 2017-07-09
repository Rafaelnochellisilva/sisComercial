package sisComercial.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sisComercial.dao.MesaDao;
import sisComercial.model.Mesa;
import sisComercial.util.EspecificacoesSoftware;
import sisComercial.util.Local;

public class CaixaMesaController extends Application implements Initializable {
	@FXML
	private TableView<Mesa>tableViewmesa;
	@FXML
	private TableColumn<Mesa, Integer>tableColunmQtdLugar;
	@FXML
	private TableColumn<Mesa, String>tableColunmNumeroMesa;
	
	private List<Mesa>listaDeMesas;
	private ObservableList<Mesa>observableListMesas;
	
	private final MesaDao mesaDao = new MesaDao();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		chamarMesas();
		
	}
	
	public  void chamarMesas(){
		tableColunmQtdLugar.setCellValueFactory(new PropertyValueFactory<>("capacidade"));
		tableColunmNumeroMesa.setCellValueFactory(new PropertyValueFactory<>("numero"));		
		listaDeMesas = mesaDao.listarMesas();		
		observableListMesas = FXCollections.observableArrayList(listaDeMesas);
		tableViewmesa.setItems(observableListMesas);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		  Parent root = FXMLLoader.load(getClass().getResource(Local.CaixaPath));
	        Scene scene = new Scene(root);
	        stage.setScene(scene);
	        stage.setResizable(false);
	        stage.setTitle(EspecificacoesSoftware.getNome());
	        stage.centerOnScreen();
	        stage.show();
		
	}
	public static void main(String[] args) {		
		launch(args);
	    
	}

}
