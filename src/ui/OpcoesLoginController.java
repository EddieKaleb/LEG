package ui;

import java.io.IOException;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class OpcoesLoginController {
	@FXML
	private Button btnAdministrador, btnServidor, btnDiscente;
	public static int opcao;
	
	public void clickBtnD() throws IOException{
		opcao = 1;
		Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
		Scene screen = new Scene(root, 800, 530);
		Main.primaryStage.setTitle("LEG");
		Main.primaryStage.setScene(screen);
		Main.primaryStage.show();
	}
	
	public void clickBtnS() throws IOException{
		opcao = 2;
		Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
		Scene screen = new Scene(root, 800, 530);
		Main.primaryStage.setTitle("LEG");
		Main.primaryStage.setScene(screen);
		Main.primaryStage.show();
	}
		
	public void clickBtnA() throws IOException{
		opcao = 3;
		Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
		Scene screen = new Scene(root, 800, 530);
		Main.primaryStage.setTitle("LEG");
		Main.primaryStage.setScene(screen);
		Main.primaryStage.show();
	}
	
	public void clickBtnSair() throws IOException{
		Platform.exit();
	}
	
	
	
	
	
}
