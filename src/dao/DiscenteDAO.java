package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import conexao.ConnectionFactory;
import entidades.Cargo;
import entidades.Discente;
public class DiscenteDAO {
	private Connection connection;

	public DiscenteDAO() throws SQLException {
		this.connection = (Connection) new ConnectionFactory().getConnection();
	}

	public void cadastro(Discente d, String sql) throws SQLException {
		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
		stmt.setString(1, Discente.usuario.getCodigo());
		stmt.setString(2, d.getSemestre());
		stmt.setString(3, Discente.usuario.getCodigo());
		stmt.execute();
		stmt.close();
	}
	public void remove(Discente d, String sql) throws SQLException {
		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
		stmt.setString(1, Discente.usuario.getCodigo());
		stmt.execute();
		stmt.close();
	}
}
