package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import conexao.ConnectionFactory;
import entidades.Discente;

/**
 * Classe DAO de discente
 * @author Eddie
 *
 */
public class DiscenteDAO {
	private Connection connection;
/**
 * Construtor
 * @throws SQLException
 */
	public DiscenteDAO() throws SQLException {
		this.connection = (Connection) new ConnectionFactory().getConnection();
	}
/**
 * Método que cadastra Discente
 * @param d
 * @param sql
 * @throws SQLException
 */
	public void cadastro(Discente d, String sql) throws SQLException {
		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
		stmt.setString(1, Discente.usuario.getCodigo());
		stmt.setString(2, d.getSemestre());
		stmt.setString(3, Discente.usuario.getCodigo());
		stmt.execute();
		stmt.close();
	}
	/**
	 * Método que remove Discente
	 * @param d
	 * @param sql
	 * @throws SQLException
	 */
	public void remove(Discente d, String sql) throws SQLException {
		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
		stmt.setString(1, Discente.usuario.getCodigo());
		stmt.execute();
		stmt.close();
	}
	/**
	 * Método que verifica se tabela Discente está vazia
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public boolean tabelaVazia(String sql) throws SQLException{
		List<Discente> discentes = new ArrayList<Discente>();
		PreparedStatement stmt = (PreparedStatement) this.connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Discente u = new Discente();
			if(rs.getString("codDiscente") != null)
			discentes.add(u);
		}
		if(discentes.size() <= 0)
			return  true;
		return false;
	} 
}
