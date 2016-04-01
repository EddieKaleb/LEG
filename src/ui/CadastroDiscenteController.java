package ui;

import java.io.IOException;

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

public class CadastroDiscenteController {
	@FXML
	private Button btnVoltar;
	@FXML
	private TextField txtCodigo, txtNome, txtDtNascimento, txtCpf, txtEndereco, txtTelefone, txtEmail, txtSemestre, txtCodCurso;
	
	public void clickBtnVoltar() throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("administrador.fxml"));
		Scene scene = new Scene(root);
		Main.primaryStage.setTitle("LEG");
		Main.primaryStage.setScene(scene);
		Main.primaryStage.show();
	}
	
	public void clickBtnCadastrar() throws IOException, ClassNotFoundException{
		Usuario u = new Usuario();
		Curso c = new Curso();
		Discente d = new Discente(u,c);
		u.setCodigo(txtCodigo.getText());
		u.setNome(txtNome.getText());
		u.setDtNascimento(txtDtNascimento.getText());
		u.setCpf(txtCpf.getText());;
		u.setEndereco(txtEndereco.getText());
		u.setTelefone(txtTelefone.getText());
		u.setEmail(txtEmail.getText());
		u.setTipo(1);
		
		AcoesUsuario aU = new AcoesUsuario();
		aU.cadastro(u);
		d.setSemestre(txtSemestre.getText());
		Discente.curso.setCodigo(txtCodCurso.getText());
		AcoesDiscente aD = new AcoesDiscente();
		aD.cadastro(d);
	}
}
