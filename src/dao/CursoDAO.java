package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import conexao.ConnectionFactory;
import entidades.Curso;
import entidades.Curso;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CursoDAO {
	private Connection connection;

	public CursoDAO() throws SQLException {
		this.connection = (Connection) new ConnectionFactory().getConnection();
	}
	
	public void cadastra(Curso c, String sql) throws SQLException {
		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
		stmt.setString(1, c.getCodigo());
		stmt.setString(2, c.getNome());
		stmt.setString(3, c.getEmenta());
		stmt.setString(4, c.getCargaHoraria());
		stmt.setString(5, c.getDescricao());
		stmt.execute();
		stmt.close();
	}
	public void remove(Curso c, String sql) throws SQLException {
		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
		stmt.setString(1, c.getCodigo());
		stmt.execute();
		stmt.close();
	}
	public ObservableList<Curso> lista(String sql) throws SQLException {
		ObservableList<Curso> data = FXCollections.observableArrayList();
		PreparedStatement stmt = (PreparedStatement) this.connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Curso c = new Curso();
			c.setCodigo(rs.getString("codCurso"));
			c.setNome(rs.getString("nome"));
			c.setDescricao(rs.getString("descricao"));
			c.setCargaHoraria(rs.getString("cargaHoraria"));
			c.setEmenta(rs.getString("ementa"));
			data.add(c);
		}
		rs.close();
		stmt.close();
		return data;
	}
	public boolean tabelaVazia(String sql) throws SQLException{
		List<Curso> cursos = new ArrayList<Curso>();
		PreparedStatement stmt = (PreparedStatement) this.connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Curso u = new Curso();
			if(rs.getString("codCurso") != null)
			cursos.add(u);
			
		}
		if(cursos.size() <= 0)
			return  true;
		return false;
	}
	public boolean existe(String sql, String id) throws SQLException{
		List<Curso> cursos = new ArrayList<Curso>();
		PreparedStatement stmt = (PreparedStatement) this.connection.prepareStatement(sql);
		stmt.setString(1, id);
		ResultSet rs = stmt.executeQuery();
		Curso u = new Curso();
		while (rs.next()) {
			if(rs.getString("codCurso") != null){
				u.setCodigo(rs.getString("codCurso"));
				cursos.add(u);
			}
		}
		if(cursos.size() > 0)
			return  true;
		return false;
	}
}
