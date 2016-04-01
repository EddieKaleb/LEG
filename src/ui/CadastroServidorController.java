package ui;

import java.io.IOException;

import acoes.AcoesServidor;
import acoes.AcoesUsuario;
import entidades.Cargo;
import entidades.Servidor;
import entidades.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CadastroServidorController {
	
	@FXML
	private Button btnVoltar;
	@FXML
	private TextField txtCodigo, txtNome, txtDtNascimento, txtCpf, txtEndereco, txtTelefone, txtEmail, txtCodCargo;
	@FXML
	private TextField txtCargaHoraria, txtGrau;
	
	public void clickBtnVoltar() throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("administrador.fxml"));
		Scene scene = new Scene(root);
		Main.primaryStage.setTitle("LEG");
		Main.primaryStage.setScene(scene);
		Main.primaryStage.show();
	}
	
	public void clickBtnCadastrar() throws IOException, ClassNotFoundException{
		Usuario u = new Usuario();
		Cargo c = new Cargo();
		Servidor s = new Servidor(u,c);
		u.setCodigo(txtCodigo.getText());
		u.setNome(txtNome.getText());
		u.setDtNascimento(txtDtNascimento.getText());
		u.setCpf(txtCpf.getText());;
		u.setEndereco(txtEndereco.getText());
		u.setTelefone(txtTelefone.getText());
		u.setEmail(txtEmail.getText());
		u.setTipo(2);
		AcoesUsuario aU = new AcoesUsuario();
		aU.cadastro(u);
		Servidor.cargo.setCodigo(txtCodCargo.getText());
		s.setCargaHoraria(txtCargaHoraria.getText());
		s.setGrau(txtGrau.getText());
		AcoesServidor aS = new AcoesServidor();
		aS.cadastro(s);
	}
	
}
