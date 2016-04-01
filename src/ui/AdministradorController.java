package ui;

import java.io.IOException;
import java.sql.SQLException;

import acoes.AcoesCargo;
import acoes.AcoesCurso;
import dao.CargoDAO;
import dao.CursoDAO;
import dao.DeclaracaoDAO;
import dao.ProcessoDAO;
import dao.UsuarioDAO;
import entidades.Cargo;
import entidades.Curso;
import entidades.Declaracao;
import entidades.Processo;
import entidades.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class AdministradorController {
	@FXML
	private Button btnVoltarLogin;
	@FXML
	private TableView<Usuario> tableviewUsuario;
	@FXML
	private TableView<Curso> tableviewCurso;
	@FXML
	private TableView<Cargo> tableviewCargo;
	@FXML
	private TableColumn<Usuario, String> clmNome, clmDtNascimento, clmCodUsuario, clmCpf, clmEndereco, clmTelefone,
			clmEmail;
	@FXML
	private TableColumn<Curso, String> clmCodCurso, clmNomeCurso, clmEmentaCurso, clmDescricaoCurso, clmCargaHorariaCurso;
	@FXML
	private TableColumn<Cargo, String> clmCodCargo, clmNomeCargo, clmRamal, clmDescricaoCargo;
	@FXML
	private MenuItem iCadastroServidor, iCadastroDiscente, iCadastroAdministrador, iCadastroCurso, iCadastroCargo;
	@FXML
	private MenuItem iServidores, iDiscentes, iCargos, iCursos, iExibirProcessos, iAtualizarProcesso;
	@FXML
	private MenuItem iAtualizarDeclaracao, iExibirDeclaracoes;
	@FXML
	private MenuItem iCargo, iCurso, iServidorDiscente, iInicio, iSair;
	@FXML
	private TableView<Processo> tableviewProcesso;
	@FXML
	private TableView<Declaracao> tableviewDeclaracao;
	@FXML
	private TableColumn<Processo, String> clm1, clm2, clm3, clm4, clm5, clm6;
	@FXML
	private TableColumn<Declaracao, String> clm1_2, clm2_2, clm3_2, clm4_2, clm5_2, clm6_2;

	public void initialize() throws SQLException, ClassNotFoundException {	
		CursoDAO cD = new CursoDAO();
		CargoDAO carD = new CargoDAO();
		UsuarioDAO uD = new UsuarioDAO();
		ProcessoDAO pD = new ProcessoDAO();
		DeclaracaoDAO dD = new DeclaracaoDAO();
		tableviewUsuario.setVisible(false);
		tableviewCurso.setVisible(false);
		tableviewCargo.setVisible(false);
		tableviewProcesso.setVisible(false);
		tableviewDeclaracao.setVisible(false);
		if(cD.tabelaVazia("SELECT * FROM curso")){
			iCadastroDiscente.setDisable(true);
			iCurso.setDisable(true);
			
		}
		if(carD.tabelaVazia("SELECT * FROM cargo")){
			iCadastroServidor.setDisable(true);
			iCargo.setDisable(true);
		}
		if(uD.tabelaVazia("SELECT * FROM usuario WHERE tipo=1 OR tipo=2;")){
			iServidorDiscente.setDisable(true);
		}
		if(pD.tabelaVazia("SELECT * FROM processo WHERE statusProcesso=?"))
			iAtualizarProcesso.setDisable(true);
		if(dD.tabelaVazia("SELECT * FROM declaracao WHERE statusDeclaracao=?"))
			iAtualizarDeclaracao.setDisable(true);
		
		
		startTableViewUsuario();
		startTableViewCurso();
		startTableViewCargo();
	}

	public void sair() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("opcoesLogin.fxml"));
		Scene scene = new Scene(root);
		Main.primaryStage.setTitle("LEG");
		Main.primaryStage.setScene(scene);
		Main.primaryStage.show();
	}
	public void inicio() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("administrador.fxml"));
		Scene scene = new Scene(root);
		Main.primaryStage.setTitle("LEG");
		Main.primaryStage.setScene(scene);
		Main.primaryStage.show();
	}

	public void cadastroServidor() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("cadastroServidor.fxml"));
		Scene scene = new Scene(root);
		Main.primaryStage.setTitle("LEG");
		Main.primaryStage.setScene(scene);
		Main.primaryStage.show();
	}

	public void cadastroDiscente() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("cadastroDiscente.fxml"));
		Scene scene = new Scene(root);
		Main.primaryStage.setTitle("LEG");
		Main.primaryStage.setScene(scene);
		Main.primaryStage.show();
	}

	public void cadastroAdministrador() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("cadastroAdministrador.fxml"));
		Scene scene = new Scene(root);
		Main.primaryStage.setTitle("LEG");
		Main.primaryStage.setScene(scene);
		Main.primaryStage.show();
	}

	public void cadastroCurso() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("cadastroCurso.fxml"));
		Scene scene = new Scene(root);
		Main.primaryStage.setTitle("LEG");
		Main.primaryStage.setScene(scene);
		Main.primaryStage.show();
	}

	public void cadastroCargo() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("cadastroCargo.fxml"));
		Scene scene = new Scene(root);
		Main.primaryStage.setTitle("LEG");
		Main.primaryStage.setScene(scene);
		Main.primaryStage.show();
	}

	public void startTableViewUsuario() {
		clmCodUsuario.setCellValueFactory(new PropertyValueFactory<Usuario, String>("codigo"));
		clmNome.setCellValueFactory(new PropertyValueFactory<Usuario, String>("nome"));
		clmDtNascimento.setCellValueFactory(new PropertyValueFactory<Usuario, String>("dtNascimento"));
		clmCpf.setCellValueFactory(new PropertyValueFactory<Usuario, String>("cpf"));
		clmEndereco.setCellValueFactory(new PropertyValueFactory<Usuario, String>("endereco"));
		clmTelefone.setCellValueFactory(new PropertyValueFactory<Usuario, String>("telefone"));
		clmEmail.setCellValueFactory(new PropertyValueFactory<Usuario, String>("email"));
	}

	public void startTableViewCurso() {
		clmCodCurso.setCellValueFactory(new PropertyValueFactory<Curso, String>("codigo"));
		clmNomeCurso.setCellValueFactory(new PropertyValueFactory<Curso, String>("nome"));
		clmEmentaCurso.setCellValueFactory(new PropertyValueFactory<Curso, String>("ementa"));
		clmDescricaoCurso.setCellValueFactory(new PropertyValueFactory<Curso, String>("descricao"));
		clmCargaHorariaCurso.setCellValueFactory(new PropertyValueFactory<Curso, String>("cargaHoraria"));
	}
	
	public void startTableViewCargo() {
		clmCodCargo.setCellValueFactory(new PropertyValueFactory<Cargo, String>("codigo"));
		clmNomeCargo.setCellValueFactory(new PropertyValueFactory<Cargo, String>("nome"));
		clmRamal.setCellValueFactory(new PropertyValueFactory<Cargo, String>("ramal"));
		clmDescricaoCargo.setCellValueFactory(new PropertyValueFactory<Cargo, String>("descricao"));
	}

	public void tableViewDiscentes() throws SQLException, ClassNotFoundException {
		tableviewUsuario.setVisible(true);
		tableviewCurso.setVisible(false);
		tableviewCargo.setVisible(false);
		tableviewProcesso.setVisible(false);
		tableviewDeclaracao.setVisible(false);
		UsuarioDAO uD = new UsuarioDAO();
		tableviewUsuario.setItems(uD.lista("SELECT * FROM leg.usuario WHERE tipo=1"));
	}
	
	public void tableViewServidores() throws SQLException, ClassNotFoundException {
		tableviewUsuario.setVisible(true);
		tableviewCurso.setVisible(false);
		tableviewCargo.setVisible(false);
		tableviewProcesso.setVisible(false);
		tableviewDeclaracao.setVisible(false);
		UsuarioDAO uD = new UsuarioDAO();
		tableviewUsuario.setItems(uD.lista("SELECT * FROM leg.usuario WHERE tipo=2"));
	}

	public void tableViewCursos() throws SQLException, ClassNotFoundException {
		tableviewUsuario.setVisible(false);
		tableviewCurso.setVisible(true);
		tableviewCargo.setVisible(false);
		tableviewProcesso.setVisible(false);
		tableviewDeclaracao.setVisible(false);
		CursoDAO cD = new CursoDAO();
		tableviewCurso.setItems(cD.lista("SELECT * FROM leg.curso"));
	}

	public void tableViewCargos() throws ClassNotFoundException, SQLException {
		tableviewUsuario.setVisible(false);
		tableviewCurso.setVisible(false);
		tableviewCargo.setVisible(true);
		tableviewProcesso.setVisible(false);
		tableviewDeclaracao.setVisible(false);
		CargoDAO cD = new CargoDAO();
		tableviewCargo.setItems(cD.lista("SELECT * FROM leg.cargo ORDER BY cargo.codCargo"));
	}
	
	public void exibirProcessos() throws IOException, SQLException{
		tableviewUsuario.setVisible(false);
		tableviewCurso.setVisible(false);
		tableviewCargo.setVisible(false);
		tableviewProcesso.setVisible(true);
		tableviewDeclaracao.setVisible(false);
		clm1.setCellValueFactory(new PropertyValueFactory<Processo, String>("codigo"));
		clm2.setCellValueFactory(new PropertyValueFactory<Processo, String>("codigoSol"));
		clm3.setCellValueFactory(new PropertyValueFactory<Processo, String>("status"));
		clm4.setCellValueFactory(new PropertyValueFactory<Processo, String>("data"));
		clm5.setCellValueFactory(new PropertyValueFactory<Processo, String>("tipo"));
		clm6.setCellValueFactory(new PropertyValueFactory<Processo, String>("descricao"));
		
		ProcessoDAO pD = new ProcessoDAO();
		tableviewProcesso.setItems(pD.listaTodos("SELECT * FROM leg.processo "
				+ "WHERE statusProcesso='Aguardando análise'"));
	}
	
	public void exibirDeclaracoes() throws SQLException{
		tableviewUsuario.setVisible(false);
		tableviewCurso.setVisible(false);
		tableviewCargo.setVisible(false);
		tableviewProcesso.setVisible(false);
		tableviewDeclaracao.setVisible(true);
		clm1_2.setCellValueFactory(new PropertyValueFactory<Declaracao, String>("codigo"));
		clm2_2.setCellValueFactory(new PropertyValueFactory<Declaracao, String>("codigoSol"));
		clm3_2.setCellValueFactory(new PropertyValueFactory<Declaracao, String>("status"));
		clm4_2.setCellValueFactory(new PropertyValueFactory<Declaracao, String>("data"));
		clm5_2.setCellValueFactory(new PropertyValueFactory<Declaracao, String>("tipo"));
		clm6_2.setCellValueFactory(new PropertyValueFactory<Declaracao, String>("descricao"));
		
		DeclaracaoDAO dD = new DeclaracaoDAO();
		tableviewDeclaracao.setItems(dD.listaTodos("SELECT * FROM leg.declaracao "
				+ "WHERE statusDeclaracao='Aguardando análise'"));
	}
	
	public void atualizarDeclaracao() throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("atualizarDeclaracao.fxml"));
		Scene screen = new Scene(root, 800, 530);
		Main.primaryStage.setTitle("LEG");
		Main.primaryStage.setScene(screen);
		Main.primaryStage.show();
	}
	
	public void atualizarProcesso() throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("atualizarProcesso.fxml"));
		Scene screen = new Scene(root, 800, 530);
		Main.primaryStage.setTitle("LEG");
		Main.primaryStage.setScene(screen);
		Main.primaryStage.show();
	}
	
	public void removerUsuario() throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("removerUsuario.fxml"));
		Scene screen = new Scene(root, 800, 530);
		Main.primaryStage.setTitle("LEG");
		Main.primaryStage.setScene(screen);
		Main.primaryStage.show();
		RemoverController.i = 1;
	}
	public void removerCurso() throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("removerCurso.fxml"));
		Scene screen = new Scene(root, 800, 530);
		Main.primaryStage.setTitle("LEG");
		Main.primaryStage.setScene(screen);
		Main.primaryStage.show();
		RemoverController.i = 2;

	}
	public void removerCargo() throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("removerCargo.fxml"));
		Scene screen = new Scene(root, 800, 530);
		Main.primaryStage.setTitle("LEG");
		Main.primaryStage.setScene(screen);
		Main.primaryStage.show();
		RemoverController.i = 3;
	}
}
