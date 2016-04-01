package ui;

import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import acoes.AcoesDiscente;
import acoes.AcoesProcesso;
import acoes.AcoesServidor;
import dao.ProcessoDAO;
import entidades.Discente;
import entidades.Processo;
import entidades.Servidor;
import entidades.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AbrirProcessoController {
	@FXML
	public Button btnVoltar, btnCadastrar;
	@FXML
	public TextField txtTipo, txtDescricao;
	public static Usuario u;
	
	public void clickBtnVoltar() throws IOException {
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
	@FXML
	public void clickBtnCadastrar() throws SQLException{
		u = new Usuario();
		u.setCodigo(LoginController.login);
		Processo p = new Processo();
		p.setCodigoSol(LoginController.login);
		p.setDescricao(txtDescricao.getText());
		p.setTipo(txtTipo.getText());
		p.setStatus("Aguardando análise");
		AcoesProcesso aP = new AcoesProcesso();
		aP.cadastro(p);
		JOptionPane.showMessageDialog(null, "Processo solicitado com sucesso.");
		
	}
}
