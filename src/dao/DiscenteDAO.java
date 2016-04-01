package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.ConnectionFactory;
import entidades.Cargo;
import entidades.Discente;
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
