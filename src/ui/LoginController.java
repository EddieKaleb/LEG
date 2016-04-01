package ui;

import java.awt.HeadlessException;
import java.io.IOException;

import javax.swing.JOptionPane;

import acoes.AcoesAdministrador;
import acoes.AcoesUsuario;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginController {
	@FXML
	private Button btnSignIn, btnVoltarOpcoes;
	@FXML
	private TextField txtLogin, txtSenha;
	public static String login, senha;
	
	public void initialize(){
		txtLogin.setStyle("-fx-border-color:black");
		txtSenha.setStyle("-fx-border-color:black");
	}
	
	public void clickBtnSignIn() throws IOException, HeadlessException, ClassNotFoundException {
		login = txtLogin.getText();
		senha = txtSenha.getText();
		AcoesUsuario uA = new AcoesUsuario();
		if (AcoesUsuario.login(login, senha, 1) && OpcoesLoginController.opcao == 1) {
			Parent root = FXMLLoader.load(getClass().getResource("discente.fxml"));
			Scene screen = new Scene(root, 800, 530);
			Main.primaryStage.setTitle("LEG");
			Main.primaryStage.setScene(screen);
			Main.primaryStage.show();
			JOptionPane.showMessageDialog(null, "BEM-VINDO !!!", "SAUDAÇÕES", JOptionPane.OK_OPTION);
		} else if (AcoesUsuario.login(login, senha, 2) && OpcoesLoginController.opcao == 2) {
			Parent root = FXMLLoader.load(getClass().getResource("servidor.fxml"));
			Scene screen = new Scene(root, 800, 530);
			Main.primaryStage.setTitle("LEG");
			Main.primaryStage.setScene(screen);
			Main.primaryStage.show();
			JOptionPane.showMessageDialog(null, "BEM-VINDO !!!", "SAUDAÇÕES", JOptionPane.OK_OPTION);
		} else if (AcoesAdministrador.login(login, senha) && OpcoesLoginController.opcao == 3) {
			Parent root = FXMLLoader.load(getClass().getResource("administrador.fxml"));
			Scene screen = new Scene(root, 800, 530);
			Main.primaryStage.setTitle("LEG");
			Main.primaryStage.setScene(screen);
			Main.primaryStage.show();
			JOptionPane.showMessageDialog(null, "BEM-VINDO !!!", "SAUDAÇÕES", JOptionPane.OK_OPTION);
		} else {
			txtLogin.setStyle("-fx-border-color:red");
			txtSenha.setStyle("-fx-border-color:red");
			JOptionPane.showMessageDialog(null, "Login e/ou senha incorreto(s)!", "SQL", JOptionPane.ERROR_MESSAGE);
		}
		
	}

	public void clickBtnVoltarOpcoes() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("opcoesLogin.fxml"));
		Scene screen = new Scene(root, 800, 530);
		Main.primaryStage.setTitle("LEG");
		Main.primaryStage.setScene(screen);
		Main.primaryStage.show();
	}
}
