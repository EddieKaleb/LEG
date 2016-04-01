package ui;

import java.io.IOException;

import acoes.AcoesCargo;
import entidades.Cargo;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CadastroCargoController {
	@FXML
	private Button btnVoltar;
	@FXML
	private TextField txtCodigo, txtNome, txtRamal, txtDescricao;
	
	public void clickBtnVoltar() throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("administrador.fxml"));
		Scene scene = new Scene(root);
		Main.primaryStage.setTitle("LEG");
		Main.primaryStage.setScene(scene);
		Main.primaryStage.show();
	}
	
	public void clickBtnCadastrar() throws IOException, ClassNotFoundException{
		Cargo c = new Cargo();
		c.setCodigo(txtCodigo.getText());
		c.setNome(txtNome.getText());
		c.setRamal(txtRamal.getText());
		c.setDescricao(txtDescricao.getText());
		AcoesCargo aC = new AcoesCargo();
		aC.cadastro(c);
	}
}
