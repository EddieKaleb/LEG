package acoes;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import dao.UsuarioDAO;
import entidades.Usuario;
import excecoes.RegexException;
import util.ValidacaoUsuario;

public class AcoesUsuario {
	private ValidacaoUsuario validacao;

	public AcoesUsuario() {
		validacao = new ValidacaoUsuario();
	}

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

	public void remove(Usuario u) {
		String sql = "DELETE FROM leg.usuario WHERE codUsuario=?";
		String sql2 = "SELECT * FROM leg.usuario WHERE codUsuario=? AND (tipo=1 OR tipo=2)";
		try {
			UsuarioDAO dao = new UsuarioDAO();
			if (dao.existe(sql2, u.getCodigo())){
				dao.remove(u, sql);
				JOptionPane.showMessageDialog(null, "Usuário excluído com sucesso!", "SQL",
						JOptionPane.INFORMATION_MESSAGE);
			}else{
				JOptionPane.showMessageDialog(null, "Usuário não cadastrado!", "SQL",
						JOptionPane.ERROR_MESSAGE);
			}
					
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "SQL", JOptionPane.ERROR_MESSAGE);
		}
	}

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
