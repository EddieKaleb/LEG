package ui;

import java.io.IOException;
import java.sql.SQLException;

import dao.UsuarioDAO;
import entidades.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MeusDadosController {
	@FXML
	private Button btnVoltar;
	@FXML 
	private Label lb1,lb2,lb3,lb4,lb5,lb6,lb7;
	public void initialize() throws IOException, SQLException{
		UsuarioDAO uD = new UsuarioDAO();
		Usuario u = uD.meusDados(LoginController.login);
		lb1.setText(u.getNome());
		lb2.setText(u.getCodigo());
		lb3.setText(u.getDtNascimento());
		lb4.setText(u.getCpf());
		lb5.setText(u.getEndereco());
		lb6.setText(u.getTelefone());
		lb7.setText(u.getEmail());
	}
	public void clickBtnVoltar() throws IOException{
		if(OpcoesLoginController.opcao == 1){
			Parent root = FXMLLoader.load(getClass().getResource("discente.fxml"));
			Scene scene = new Scene(root);
			Main.primaryStage.setTitle("LEG");
			Main.primaryStage.setScene(scene);
			Main.primaryStage.show();
		}
		if(OpcoesLoginController.opcao == 2){
			Parent root = FXMLLoader.load(getClass().getResource("servidor.fxml"));
			Scene scene = new Scene(root);
			Main.primaryStage.setTitle("LEG");
			Main.primaryStage.setScene(scene);
			Main.primaryStage.show();
		}
	}
}
