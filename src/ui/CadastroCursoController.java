package ui;

import java.io.IOException;

import acoes.AcoesCurso;
import acoes.AcoesDiscente;
import acoes.AcoesUsuario;
import entidades.Curso;
import entidades.Discente;
import entidades.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CadastroCursoController {
	@FXML
	private Button btnVoltar;
	@FXML
	private TextField txtCodigo, txtNome, txtEmenta, txtCargaHoraria, txtDescricao;
	
	public void clickBtnVoltar() throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("administrador.fxml"));
		Scene scene = new Scene(root);
		Main.primaryStage.setTitle("LEG");
		Main.primaryStage.setScene(scene);
		Main.primaryStage.show();
	}
	
	public void clickBtnCadastrar() throws IOException, ClassNotFoundException{
		Curso c = new Curso();
		c.setCodigo(txtCodigo.getText());
		c.setNome(txtNome.getText());
		c.setEmenta(txtEmenta.getText());
		c.setCargaHoraria(txtCargaHoraria.getText());
		c.setDescricao(txtDescricao.getText());
		AcoesCurso aC = new AcoesCurso();
		aC.cadastro(c);
	}
}
