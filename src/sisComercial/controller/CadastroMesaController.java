package sisComercial.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sisComercial.model.Mesa;
import sisComercial.model.Status;
import sisComercial.model.StatusMesa;

public class CadastroMesaController implements Initializable {
	@FXML
	private TextField textViewNumeroMesa;
	@FXML
	private ComboBox<Status> comboboxStatus;
	@FXML
	private TextField textViewCapacidade;
	@FXML 
	private Button btnComfirmar;
	@FXML
	private Button btnCancelar;
	
	private Stage stage;
	private Mesa mesa;
	private boolean confirmar = false;
	private List<Status> statusMesa;
	private ObservableList<Status>observableStatus;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		statusMesa = StatusMesa.retornaStatusMesa();
		observableStatus = FXCollections.observableArrayList(statusMesa);
		comboboxStatus.setItems(observableStatus);
		
		
	}

	public Button getBtnComfirmar() {
		return btnComfirmar;
	}

	public void setBtnComfirmar(Button btnComfirmar) {
		this.btnComfirmar = btnComfirmar;
	}

	public Button getBtnCancelar() {
		return btnCancelar;
	}

	public void setBtnCancelar(Button btnCancelar) {
		this.btnCancelar = btnCancelar;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public boolean isConfirmar() {
		return confirmar;
	}

	public void setConfirmar(boolean confirmar) {
		this.confirmar = confirmar;
	}

	@FXML
	private void comfirmarCadastro() {
		if (validaEntradaDeDadosMesa()) {
			mesa.setCapacidade(Integer.parseInt(textViewCapacidade.getText()));
			mesa.setReserva(false);
			mesa.setStatus(String.valueOf(comboboxStatus.getSelectionModel().getSelectedItem()));
			mesa.setNumero(textViewNumeroMesa.getText());

			confirmar = true;
			stage.close();
		}
	}
	@FXML
	private void cancelarCadastro (){
		stage.close();
	}

	public void selecionarMesa(Mesa mesa) {
		if (mesa.getCapacidade() !=0){
			textViewCapacidade.setText(String.valueOf(mesa.getCapacidade()));
			textViewNumeroMesa.setText(mesa.getNumero());
		} else {
			textViewCapacidade.setText(null);
			textViewNumeroMesa.setText("");
		}
	}
	public boolean validaEntradaDeDadosMesa(){
		String erro = "";
		if(textViewCapacidade.getText() ==null || textViewCapacidade.getText().length() ==0){
			erro +="Capacidade Invalida";
		}
		if(textViewNumeroMesa.getText() == null || textViewNumeroMesa.getText().length() ==0){
			erro += "Numero da Mesa Invalida";
		}
		if(comboboxStatus.getPromptText() == null || comboboxStatus.getPromptText().length() ==0){
			comboboxStatus.setPromptText("livre");
		}
		
		if(erro.length() == 0){
			return true;
		}else{
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erro ao tentar Cadastrar a mesa!");
			alert.setHeaderText("Campos invalidos, por favor tente novamente...");
			alert.setContentText(erro);
			alert.show();
			return false;
		}
		
		
		
	}
	

}
