package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.ConnectionFactory;
import entidades.Administrador;
import entidades.Administrador;
/**
 * Classe DAO do administrador
 * @author Eddie
 *
 */
public class AdministradorDAO {
	private Connection connection;
/**
 * Construtor
 * @throws SQLException
 */
	public AdministradorDAO() throws SQLException {
		this.connection = (Connection) new ConnectionFactory().getConnection();
	}
/**
 * Método que cadastra administrador 
 * @param a
 * @param sql
 * @throws SQLException
 */
	public void cadastra(Administrador a, String sql) throws SQLException {
		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
		stmt.setString(1, Administrador.usuario.getCodigo());
		stmt.setString(2, a.getLogin());
		stmt.setString(3, a.getSenha());
		stmt.execute();
		stmt.close();
	}
	/**
	 * Método que verifica login do administrador
	 * @param sql
	 * @param login
	 * @param senha
	 * @return
	 * @throws SQLException
	 */
	public boolean login(String sql, String login, String senha) throws SQLException {
		PreparedStatement stmt = (PreparedStatement) this.connection.prepareStatement(sql);
		stmt.setString(1, login);
		stmt.setString(2, senha);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			if((rs.getString("login").equals(login) && rs.getString("senha").equals(senha)))
					return true;
		}
		rs.close();
		stmt.close();
		return false;
	}
	/**
	 * Método que verifica se tabela do administrador está vazia
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public boolean tabelaVazia(String sql) throws SQLException{
		List<Administrador> administradores = new ArrayList<Administrador>();
		PreparedStatement stmt = (PreparedStatement) this.connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Administrador u = new Administrador();
			if(rs.getString("codAdministrador") != null)
			administradores.add(u);
		}
		if(administradores.size() <= 0)
			return  true;
		return false;
	} 
}
