package ui;

import java.io.IOException;

import acoes.AcoesDeclaracao;
import entidades.Declaracao;
import excecoes.RegexException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AtualizarDeclaracaoController {
	@FXML
	private Button btnAtualizar, btnVoltar; 
	@FXML
	private TextField txtCodigo, txtStatus;
	
	public void clickBtnAtualizar() throws RegexException{
		Declaracao d = new Declaracao();
		d.setCodigo(txtCodigo.getText());
		d.setStatus(txtStatus.getText());
		AcoesDeclaracao aD = new AcoesDeclaracao();
		aD.altera(d);		
	}
	public void clickBtnVoltar() throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("administrador.fxml"));
		Scene screen = new Scene(root, 800, 530);
		Main.primaryStage.setTitle("LEG");
		Main.primaryStage.setScene(screen);
		Main.primaryStage.show();
	}
	
}
