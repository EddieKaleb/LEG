package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.ConnectionFactory;
import entidades.Cargo;
import entidades.Cargo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CargoDAO {
	private Connection connection;
	public CargoDAO() throws SQLException {
		this.connection = (Connection) new ConnectionFactory().getConnection();
	}
	public void cadastra(Cargo c, String sql) throws SQLException {
		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
		stmt.setString(1, c.getCodigo());
		stmt.setString(2, c.getNome());
		stmt.setString(3, c.getRamal());
		stmt.setString(4, c.getDescricao());
		stmt.execute();
		stmt.close();
	}
	public void remove(Cargo c, String sql) throws SQLException {
		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
		stmt.setString(1, c.getCodigo());
		stmt.execute();
		stmt.close();
	}
	public ObservableList<Cargo> lista(String sql) throws SQLException {
		ObservableList<Cargo> data = FXCollections.observableArrayList();
		PreparedStatement stmt = (PreparedStatement) this.connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Cargo c = new Cargo();
			c.setCodigo(rs.getString("codCargo"));
			c.setNome(rs.getString("nome"));
			c.setDescricao(rs.getString("descricao"));
			c.setRamal(rs.getString("ramal"));
			data.add(c);
		}
		rs.close();
		stmt.close();
		return data;
	}
	public boolean tabelaVazia(String sql) throws SQLException{
		List<Cargo> cargos = new ArrayList<Cargo>();
		PreparedStatement stmt = (PreparedStatement) this.connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Cargo u = new Cargo();
			if(rs.getString("codCargo") != null)
			cargos.add(u);
			
		}
		if(cargos.size() <= 0)
			return  true;
		return false;
	}

}
