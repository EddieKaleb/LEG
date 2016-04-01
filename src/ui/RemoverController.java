package ui;

import java.io.IOException;

import acoes.AcoesCargo;
import acoes.AcoesCurso;
import acoes.AcoesUsuario;
import entidades.Cargo;
import entidades.Curso;
import entidades.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class RemoverController {
	@FXML
	private Button btnVoltar, btnExcluir;
	@FXML
	private TextField txtCodigo;
	public static int i;
	public void clickBtnVoltar() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("administrador.fxml"));
		Scene screen = new Scene(root, 800, 530);
		Main.primaryStage.setTitle("LEG");
		Main.primaryStage.setScene(screen);
		Main.primaryStage.show();
	}
	
	public void clickBtnExcluir()throws IOException {
		if (i == 1) {
			AcoesUsuario aU = new AcoesUsuario();
			Usuario u = new Usuario();
			u.setCodigo(txtCodigo.getText());
			aU.remove(u);
		}if(i == 2){
			AcoesCurso aC = new AcoesCurso();
			Curso c = new Curso();
			c.setCodigo(txtCodigo.getText());
			aC.remove(c);
		}else if(i == 3){
			AcoesCargo aC = new AcoesCargo();
			Cargo c = new Cargo();
			c.setCodigo(txtCodigo.getText());
			aC.remove(c);
		}
	}
}
