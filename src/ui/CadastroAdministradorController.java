package ui;

import java.io.IOException;

import javax.swing.JOptionPane;

import acoes.AcoesAdministrador;
import acoes.AcoesUsuario;
import entidades.Administrador;
import entidades.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CadastroAdministradorController {
	@FXML
	private Button btnVoltar;
	@FXML
	private TextField txtCodigo, txtNome, txtDtNascimento, txtCpf, txtEndereco, txtTelefone, txtEmail;
	@FXML
	private TextField txtLogin, txtSenha;
	
	public void clickBtnVoltar() throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("administrador.fxml"));
		Scene scene = new Scene(root);
		Main.primaryStage.setTitle("LEG");
		Main.primaryStage.setScene(scene);
		Main.primaryStage.show();
	}
	
	public void clickBtnCadastrar() throws IOException, ClassNotFoundException{
		Usuario u = new Usuario();
		u.setCodigo(txtCodigo.getText());
		u.setNome(txtNome.getText());
		u.setDtNascimento(txtDtNascimento.getText());
		u.setCpf(txtCpf.getText());;
		u.setEndereco(txtEndereco.getText());
		u.setTelefone(txtTelefone.getText());
		u.setEmail(txtEmail.getText());
		u.setTipo(3);
		AcoesUsuario aU = new AcoesUsuario();
		aU.cadastro(u);
		Administrador a = new Administrador(u);
		a.setLogin(txtLogin.getText());
		a.setSenha(txtSenha.getText());
		AcoesAdministrador aA = new AcoesAdministrador();
		aA.cadastro(a);
		
	}
}
