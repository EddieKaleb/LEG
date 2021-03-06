package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import conexao.ConnectionFactory;
import entidades.Administrador;
import entidades.Usuario;
import entidades.Usuario;
import entidades.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 * Classe DAO de Usu�rio
 * @author Eddie
 *
 */
public class UsuarioDAO {
	private Connection connection;
/**
 * Construtor
 * @throws SQLException
 */
	public UsuarioDAO() throws SQLException {
		this.connection = (Connection) new ConnectionFactory().getConnection();
	}
/**
 * M�todo que cadastra um Usu�rio
 * @param u
 * @param sql
 * @throws SQLException
 */
	public void add(Usuario u, String sql) throws SQLException {
		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
		stmt.setString(1, u.getCodigo());
		stmt.setString(2, u.getNome());
		stmt.setString(3, u.getDtNascimento());
		stmt.setString(4, u.getCpf());
		stmt.setString(5, u.getEndereco());
		stmt.setString(6, u.getTelefone());
		stmt.setString(7, u.getEmail());
		stmt.setInt(8, u.getTipo());
		stmt.execute();
		stmt.close();
	}
	/**
	 * M�todo que remove usu�rio(Servidor ou Discente)
	 * @param u
	 * @param sql
	 * @throws SQLException
	 */

	public void remove(Usuario u, String sql) throws SQLException {
		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
		stmt.setString(1, u.getCodigo());
		stmt.execute();
		stmt.close();
	}
	/**
	 * Classe que retorna lista de usuarios
	 * @param sql
	 * @return
	 * @throws SQLException
	 */

	public ObservableList<Usuario> lista(String sql) throws SQLException {
		ObservableList<Usuario> data = FXCollections.observableArrayList();
		PreparedStatement stmt = (PreparedStatement) this.connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Usuario u = new Usuario();
			u.setCodigo(rs.getString("codUsuario"));
			u.setNome(rs.getString("nome"));
			u.setEmail(rs.getString("email"));
			u.setEndereco(rs.getString("endereco"));
			u.setCpf(rs.getString("cpf"));
			u.setTelefone(rs.getString("telefone"));
			u.setDtNascimento(rs.getString("dtNascimento"));
			data.add(u);

		}
		rs.close();
		stmt.close();
		return data;
	}
/**
 * M�todo que verifica se login do us�rio est� correto
 * @param sql
 * @param login
 * @param senha
 * @param opcao
 * @return
 * @throws SQLException
 */
	public boolean login(String sql, String login, String senha, int opcao) throws SQLException {
		PreparedStatement stmt = (PreparedStatement) this.connection.prepareStatement(sql);
		stmt.setString(1, login);
		stmt.setString(2, senha);
		stmt.setInt(3, opcao);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			if ((rs.getString("codUsuario").equals(login) && rs.getString("dtNascimento").equals(senha))
					&& rs.getInt("tipo") == opcao)
				return true;
		}
		rs.close();
		stmt.close();
		return false;
	}
/**
 * M�todo que retorna dados do Usu�rio (Discente ou Administrador)
 * @param login
 * @return
 * @throws SQLException
 */
	public Usuario meusDados(String login) throws SQLException {
		String sql = "SELECT * FROM Usuario WHERE codUsuario=?";
		PreparedStatement stmt = (PreparedStatement) this.connection.prepareStatement(sql);
		stmt.setString(1, login);
		ResultSet rs = stmt.executeQuery();
		Usuario u = new Usuario();
		while (rs.next()) {
			u.setCodigo(rs.getString("codUsuario"));
			u.setNome(rs.getString("nome"));
			u.setEmail(rs.getString("email"));
			u.setEndereco(rs.getString("endereco"));
			u.setCpf(rs.getString("cpf"));
			u.setTelefone(rs.getString("telefone"));
			u.setDtNascimento(rs.getString("dtNascimento"));
		}
		rs.close();
		stmt.close();
		return u;
	}
	/**
	 * M�todo que verifica se tabela usu�rio est� vazia
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public boolean tabelaVazia(String sql) throws SQLException{
		List<Usuario> usuarios = new ArrayList<Usuario>();
		PreparedStatement stmt = (PreparedStatement) this.connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Usuario u = new Usuario();
			if(rs.getString("codUsuario") != null)
			usuarios.add(u);
		}
		System.out.println(usuarios.size());
		if(usuarios.size() <= 0)
			return  true;
		return false;
	}
	/**
	 * 	M�todo que verifica se tabela Usu�rio existe 
	 * @param sql
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public boolean existe(String sql, String id) throws SQLException{
		List<Usuario> usuarios = new ArrayList<Usuario>();
		PreparedStatement stmt = (PreparedStatement) this.connection.prepareStatement(sql);
		stmt.setString(1, id);
		ResultSet rs = stmt.executeQuery();
		Usuario u = new Usuario();
		while (rs.next()) {
			if(rs.getString("codUsuario") != null){
				u.setCodigo(rs.getString("codUsuario"));
				usuarios.add(u);
			}
		}
		if(usuarios.size() > 0)
			return  true;
		return false;
	}

}
