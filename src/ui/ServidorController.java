package ui;

import java.io.IOException;
import java.sql.SQLException;

import dao.ProcessoDAO;
import entidades.Processo;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ServidorController {
	@FXML
	private Button btnAbrirProcesso, btnMeusProcessos, btnMeusDados, btnVoltarLogin, btnVoltar;
	@FXML
	private TableView<Processo> tableviewProcesso;
	@FXML
	private TableColumn<Processo, String> clm1, clm2, clm3, clm4, clm5, clm6;
	@FXML
	public void initialize()throws SQLException{
		tableviewProcesso.setVisible(false);
		btnVoltar.setVisible(false);
	}
	public void clickBtnVoltar() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("servidor.fxml"));
		Scene scene = new Scene(root);
		Main.primaryStage.setTitle("LEG");
		Main.primaryStage.setScene(scene);
		Main.primaryStage.show();
	}

	public void clickBtnVoltarLogin() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
		Scene scene = new Scene(root);
		Main.primaryStage.setTitle("LEG");
		Main.primaryStage.setScene(scene);
		Main.primaryStage.show();
	}
	
	public void clickBtnAbrirProcesso() throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("abrirProcesso.fxml"));
		Scene scene = new Scene(root);
		Main.primaryStage.setTitle("LEG");
		Main.primaryStage.setScene(scene);
		Main.primaryStage.show();
	}
	
	public void clickBtnMeusProcessos() throws IOException, SQLException{
		tableviewProcesso.setVisible(true);
		btnVoltar.setVisible(true);
		clm1.setCellValueFactory(new PropertyValueFactory<Processo, String>("codigo"));
		clm2.setCellValueFactory(new PropertyValueFactory<Processo, String>("codigoSol"));
		clm3.setCellValueFactory(new PropertyValueFactory<Processo, String>("status"));
		clm4.setCellValueFactory(new PropertyValueFactory<Processo, String>("data"));
		clm5.setCellValueFactory(new PropertyValueFactory<Processo, String>("tipo"));
		clm6.setCellValueFactory(new PropertyValueFactory<Processo, String>("descricao"));
		ProcessoDAO pD = new ProcessoDAO();
		tableviewProcesso.setItems(pD.lista("SELECT * FROM processo WHERE codSolicitante=?"));
	}
	
	public void clickBtnMeusDados() throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("meusDados.fxml"));
		Scene scene = new Scene(root);
		Main.primaryStage.setTitle("LEG");
		Main.primaryStage.setScene(scene);
		Main.primaryStage.show();
	}
	
}
