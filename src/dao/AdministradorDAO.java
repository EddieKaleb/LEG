package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import conexao.ConnectionFactory;
import entidades.Administrador;

public class AdministradorDAO {
	private Connection connection;

	public AdministradorDAO() throws SQLException {
		this.connection = (Connection) new ConnectionFactory().getConnection();
	}

	public void cadastra(Administrador a, String sql) throws SQLException {
		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
		stmt.setString(1, Administrador.usuario.getCodigo());
		stmt.setString(2, a.getLogin());
		stmt.setString(3, a.getSenha());
		stmt.execute();
		stmt.close();
	}
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
}
