package acoes;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import dao.UsuarioDAO;
import entidades.Usuario;
import excecoes.RegexException;
import util.ValidacaoUsuario;
/**
 * Classe com m�todos de a��o do Usu�rio
 * @author Eddie
 *
 */
public class AcoesUsuario {
	private ValidacaoUsuario validacao;
/**
 * Construtor
 */
	public AcoesUsuario() {
		validacao = new ValidacaoUsuario();
	}
/**
 * M�todo que cadastra Usu�rio atrav�s da classe DAO
 * @param u
 */
	public void cadastro(Usuario u) {
		String sql = "INSERT INTO leg.usuario" + "(codUsuario,nome,dtNascimento,cpf,endereco,telefone,email,tipo)"
				+ "VALUES(?,?,?,?,?,?,?,?)";
		try {
			validacao.validaDadosDoUsuario(u);
			UsuarioDAO dao = new UsuarioDAO();
			dao.add(u, sql);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "SQL", JOptionPane.ERROR_MESSAGE);
		} catch (RegexException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO DE ENTRADA", JOptionPane.ERROR_MESSAGE);
		}
	}
/**
 * M�todo que remove usu�rio atrav�s de sua classe DAO
 * @param u
 */
	public void remove(Usuario u) {
		String sql = "DELETE FROM leg.usuario WHERE codUsuario=?";
		String sql2 = "SELECT * FROM leg.usuario WHERE codUsuario=? AND (tipo=1 OR tipo=2)";
		try {
			UsuarioDAO dao = new UsuarioDAO();
			if (dao.existe(sql2, u.getCodigo())){
				dao.remove(u, sql);
				JOptionPane.showMessageDialog(null, "Usu�rio exclu�do com sucesso!", "SQL",
						JOptionPane.INFORMATION_MESSAGE);
			}else{
				JOptionPane.showMessageDialog(null, "Usu�rio n�o cadastrado!", "SQL",
						JOptionPane.ERROR_MESSAGE);
			}
					
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "SQL", JOptionPane.ERROR_MESSAGE);
		}
	}
/**
 * M�todo que verifica se login e senha do usu�rio est�o corretos
 * @param login
 * @param senha
 * @param opcao
 * @return
 */
	public static boolean login(String login, String senha, int opcao) {
		String sql = "SELECT * FROM leg.usuario WHERE codUsuario=? AND dtNascimento=? AND tipo=?";
		boolean logado = false;
		try {
			UsuarioDAO dao = new UsuarioDAO();
			logado = dao.login(sql, login, senha, opcao);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "SQL", JOptionPane.ERROR_MESSAGE);
		}
		return logado;
	}
}
