package sisComercial.controller;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import org.omg.PortableInterceptor.LOCATION_FORWARD;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sisComercial.util.Local;

public class InicialController implements Initializable {
	@FXML
	private MenuItem menuItemCaixa;
	@FXML
	private AnchorPane anchorPanePrincipal;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
		
		
	}
	@FXML
	public void acessarCaixa() throws IOException{
		AnchorPane a =(AnchorPane)FXMLLoader.load(getClass().getResource(Local.CaixaPath));
		anchorPanePrincipal.getChildren().setAll(a);
	}
	@FXML
	public void acessarCadastroMesa() throws IOException{
		AnchorPane a =(AnchorPane)FXMLLoader.load(getClass().getResource(Local.CadastroMesaPath));
		anchorPanePrincipal.getChildren().setAll(a);
	}


	

}
