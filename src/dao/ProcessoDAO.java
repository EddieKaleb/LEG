package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import conexao.ConnectionFactory;
import entidades.Processo;
import entidades.Processo;
import entidades.Processo;
import entidades.Processo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ui.LoginController;
/**
 * Classe DAO de Processo
 * @author Eddie
 *
 */
public class ProcessoDAO {
	private Connection connection;
/**
 * Construtor da classe
 * @throws SQLException
 */
	public ProcessoDAO() throws SQLException {
		this.connection = (Connection) new ConnectionFactory().getConnection();
	}
	/**
	 * Método que cadastra processo
	 * @param p
	 * @param sql
	 * @throws SQLException
	 */

	public void cadastro(Processo p, String sql) throws SQLException {
		java.sql.Date data = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, p.getCodigoSol());
			stmt.setString(2, p.getTipo());
			stmt.setString(3, p.getDescricao());
			stmt.setString(4, "Aguardando análise");
			stmt.setDate(5, data);
			stmt.execute();
			stmt.close();
	}
	/**
	 * Método que altera processo
	 * @param p
	 * @param sql
	 * @throws SQLException
	 */
	public void altera(Processo p, String sql) throws SQLException {
		java.sql.Date data = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
		stmt.setString(1, p.getStatus());
		stmt.setDate(2, data);
		stmt.setString(3, p.getCodigo());
		stmt.execute();
		stmt.close();
	}
	/**
	 * Método que retorna lista de processos
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public ObservableList<Processo> lista(String sql) throws SQLException {
		ObservableList<Processo> data = FXCollections.observableArrayList();
		PreparedStatement stmt = (PreparedStatement) this.connection.prepareStatement(sql);
		stmt.setString(1, LoginController.login);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Processo p = new Processo();
			p.setCodigo(rs.getString("codProcesso"));
			p.setCodigoSol(rs.getString("codSolicitante"));
			p.setStatus(rs.getString("statusProcesso"));
			p.setDescricao(rs.getString("descricaoProcesso"));
			p.setData(rs.getString("dataProcesso"));
			p.setTipo(rs.getString("tipoProcesso"));
			data.add(p);
		}
		rs.close();
		stmt.close();
		return data;
	}
	/**
	 * Método que retorna lista com todos os processos
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public ObservableList<Processo> listaTodos(String sql) throws SQLException {
		ObservableList<Processo> data = FXCollections.observableArrayList();
		PreparedStatement stmt = (PreparedStatement) this.connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Processo p = new Processo();
			p.setCodigo(rs.getString("codProcesso"));
			p.setCodigoSol(rs.getString("codSolicitante"));
			p.setStatus(rs.getString("statusProcesso"));
			p.setDescricao(rs.getString("descricaoProcesso"));
			p.setData(rs.getString("dataProcesso"));
			p.setTipo(rs.getString("tipoProcesso"));
			data.add(p);
		}
		rs.close();
		stmt.close();
		return data;
	}
	/**
	 * Método que verifica se tabela processo está vazia 
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public boolean tabelaVazia(String sql) throws SQLException{
		List<Processo> processos = new ArrayList<Processo>();
		PreparedStatement stmt = (PreparedStatement) this.connection.prepareStatement(sql);
		stmt.setString(1, "Aguardando análise");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Processo u = new Processo();
			if(rs.getString("codProcesso") != null)
			processos.add(u);
		}
		if(processos.size() <= 0)
			return  true;
		return false;
	}
}
