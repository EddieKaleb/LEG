package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import conexao.ConnectionFactory;
import entidades.Declaracao;
import entidades.Declaracao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ui.LoginController;

public class DeclaracaoDAO {
	private Connection connection;

	public DeclaracaoDAO() throws SQLException {
		this.connection = (Connection) new ConnectionFactory().getConnection();
	}

	public void cadastro(Declaracao d, String sql) throws SQLException {
		java.sql.Date data = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
		stmt.setString(1, d.getCodigoSol());
		stmt.setString(2, d.getStatus());
		stmt.setDate(3, data);
		stmt.setString(4, d.getDescricao());
		stmt.setString(5, d.getTipo());
		stmt.execute();
		stmt.close();
	}
	public void altera(Declaracao d, String sql) throws SQLException {
		java.sql.Date data = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
		stmt.setString(1, d.getStatus());
		stmt.setDate(2, data);
		stmt.setString(3, d.getCodigo());
		stmt.execute();
		stmt.close();
	}
	public ObservableList<Declaracao> lista(String sql) throws SQLException {
		ObservableList<Declaracao> data = FXCollections.observableArrayList();
		PreparedStatement stmt = (PreparedStatement) this.connection.prepareStatement(sql);
		stmt.setString(1, LoginController.login);
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
			Declaracao d = new Declaracao();
			d.setCodigo(rs.getString("codDeclaracao"));
			d.setCodigoSol(rs.getString("codSolicitante"));
			d.setStatus(rs.getString("statusDeclaracao"));
			d.setDescricao(rs.getString("descricaoDeclaracao"));
			d.setData(rs.getString("dataDeclaracao"));
			d.setTipo(rs.getString("tipoDeclaracao"));
			data.add(d);
		}
		rs.close();
		stmt.close();
		return data;
	}
	public ObservableList<Declaracao> listaTodos(String sql) throws SQLException {
		ObservableList<Declaracao> data = FXCollections.observableArrayList();
		PreparedStatement stmt = (PreparedStatement) this.connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Declaracao d = new Declaracao();
			d.setCodigo(rs.getString("codDeclaracao"));
			d.setCodigoSol(rs.getString("codSolicitante"));
			d.setStatus(rs.getString("statusDeclaracao"));
			d.setDescricao(rs.getString("descricaoDeclaracao"));
			d.setData(rs.getString("dataDeclaracao"));
			d.setTipo(rs.getString("tipoDeclaracao"));
			data.add(d);
		}
		rs.close();
		stmt.close();
		return data;
	}
	public boolean tabelaVazia(String sql) throws SQLException{
		List<Declaracao> declaracoes = new ArrayList<Declaracao>();
		PreparedStatement stmt = (PreparedStatement) this.connection.prepareStatement(sql);
		stmt.setString(1, "Aguardando análise");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Declaracao u = new Declaracao();
			if(rs.getString("codDeclaracao") != null)
			declaracoes.add(u);
		}
		if(declaracoes.size() <= 0)
			return  true;
		return false;
	}
}
