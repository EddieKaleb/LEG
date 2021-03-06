package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.ConnectionFactory;
import entidades.Servidor;
import entidades.Servidor;
/**
 * Classe DAO de Servidor
 * @author Eddie
 *
 */
public class ServidorDAO {
	private Connection connection;
/**
 * Construtor
 * @throws SQLException
 */
	public ServidorDAO() throws SQLException {
		this.connection = (Connection) new ConnectionFactory().getConnection();
	}
	/**
	 * M�todo que cadastra Servidor
	 * @param s
	 * @param sql
	 * @throws SQLException
	 */

	public void cadastro(Servidor s, String sql) throws SQLException {
		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
		stmt.setString(1, Servidor.usuario.getCodigo());
		stmt.setString(2, s.getCargaHoraria());
		stmt.setString(3, s.getGrau());
		stmt.setString(4, Servidor.cargo.getCodigo());
		stmt.execute();
		stmt.close();
	}
/**
 * M�todo que remove Servidor
 * @param s
 * @param sql
 * @throws SQLException
 */
	public void remove(Servidor s, String sql) throws SQLException {
		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
		stmt.setString(1, Servidor.usuario.getCodigo());
		stmt.execute();
		stmt.close();
	}
	/**
	 * M�todo que verifica se tabela Servidor est� vazia
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public boolean tabelaVazia(String sql) throws SQLException{
		List<Servidor> servidores = new ArrayList<Servidor>();
		PreparedStatement stmt = (PreparedStatement) this.connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Servidor u = new Servidor();
			if(rs.getString("codServidor") != null)
			servidores.add(u);
		}
		if(servidores.size() <= 0)
			return  true;
		return false;
	} 
}
