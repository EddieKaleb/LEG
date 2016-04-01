package ui;

import java.io.IOException;

import acoes.AcoesProcesso;
import entidades.Processo;
import excecoes.RegexException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AtualizarProcessoController {
	@FXML
	private Button btnAtualizar, btnVoltar; 
	@FXML
	private TextField txtCodigo, txtStatus;
	
	public void clickBtnAtualizar() throws RegexException{
		Processo p = new Processo();
		p.setCodigo(txtCodigo.getText());
		p.setStatus(txtStatus.getText());
		AcoesProcesso aP = new AcoesProcesso();
		aP.altera(p);		
	}
	public void clickBtnVoltar() throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("administrador.fxml"));
		Scene screen = new Scene(root, 800, 530);
		Main.primaryStage.setTitle("LEG");
		Main.primaryStage.setScene(screen);
		Main.primaryStage.show();
	}
	
	
}
