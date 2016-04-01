package ui;

import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import acoes.AcoesDeclaracao;
import acoes.AcoesProcesso;
import entidades.Declaracao;
import entidades.Usuario;
import excecoes.RegexException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SolicitarDeclaracaoController {

	@FXML
	public Button btnVoltar, btnCadastrar;
	@FXML
	public TextField txtTipo, txtDescricao;
	public static Usuario u;

	public void clickBtnVoltar() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("discente.fxml"));
		Scene scene = new Scene(root);
		Main.primaryStage.setTitle("LEG");
		Main.primaryStage.setScene(scene);
		Main.primaryStage.show();
	}

	@FXML
	public void clickBtnCadastrar() throws SQLException, RegexException {
		u = new Usuario();
		u.setCodigo(LoginController.login);
		Declaracao d = new Declaracao();
		d.setCodigoSol(LoginController.login);
		d.setDescricao(txtDescricao.getText());
		d.setTipo(txtTipo.getText());
		d.setStatus("Aguardando análise");
		AcoesDeclaracao aD = new AcoesDeclaracao();
		aD.cadastro(d);
	}
}
