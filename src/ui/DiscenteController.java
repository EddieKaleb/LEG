package ui;

import java.io.IOException;
import java.sql.SQLException;

import dao.DeclaracaoDAO;
import dao.ProcessoDAO;
import entidades.Declaracao;
import entidades.Processo;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class DiscenteController {
	@FXML
	private Button btnVoltarLogin, btnAbrirProcesso, btnMeusProcessos,  btnVoltar;
	@FXML
	private Button btnSolicitarDeclaracao,btnMeusDados,btnMinhasDeclaracoes;
	@FXML
	private TableView<Processo> tableviewProcesso;
	@FXML
	private TableView<Declaracao> tableviewDeclaracao;
	@FXML
	private TableColumn<Processo, String> clm1, clm2, clm3, clm4, clm5, clm6;
	@FXML
	private TableColumn<Declaracao, String> clm1_2, clm2_2, clm3_2, clm4_2, clm5_2, clm6_2;
	
	public void initialize()throws SQLException{
		tableviewProcesso.setVisible(false);
		tableviewDeclaracao.setVisible(false);
		btnVoltar.setVisible(false);
	}
	
	public void clickBtnVoltarLogin() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
		Scene scene = new Scene(root);
		Main.primaryStage.setTitle("LEG");
		Main.primaryStage.setScene(scene);
		Main.primaryStage.show();
	}
	public void clickBtnVoltar() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("discente.fxml"));
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
		tableviewProcesso.setItems(pD.lista("SELECT * FROM leg.processo WHERE codSolicitante=?"));
	}
	
	public void clickBtnMeusDados() throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("meusDados.fxml"));
		Scene scene = new Scene(root);
		Main.primaryStage.setTitle("LEG");
		Main.primaryStage.setScene(scene);
		Main.primaryStage.show();
	}
	
	public void clickBtnSolicitarDeclaracao() throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("solicitarDeclaracao.fxml"));
		Scene scene = new Scene(root);
		Main.primaryStage.setTitle("LEG");
		Main.primaryStage.setScene(scene);
		Main.primaryStage.show();
	}
	
	public void clickBtnMinhasDeclaracoes() throws IOException, SQLException{
		tableviewDeclaracao.setVisible(true);
		btnVoltar.setVisible(true);
		clm1_2.setCellValueFactory(new PropertyValueFactory<Declaracao, String>("codigo"));
		clm2_2.setCellValueFactory(new PropertyValueFactory<Declaracao, String>("codigoSol"));
		clm3_2.setCellValueFactory(new PropertyValueFactory<Declaracao, String>("status"));
		clm4_2.setCellValueFactory(new PropertyValueFactory<Declaracao, String>("data"));
		clm5_2.setCellValueFactory(new PropertyValueFactory<Declaracao, String>("tipo"));
		clm6_2.setCellValueFactory(new PropertyValueFactory<Declaracao, String>("descricao"));
		
		DeclaracaoDAO dD = new DeclaracaoDAO();
		tableviewDeclaracao.setItems(dD.lista("SELECT * FROM leg.declaracao WHERE codSolicitante=?"));
	}
	
	
	
	
	
}
