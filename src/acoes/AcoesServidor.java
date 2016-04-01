package acoes;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import dao.ServidorDAO;
import entidades.Servidor;
import excecoes.RegexException;
import util.ValidacaoServidor;

public class AcoesServidor {
	private ValidacaoServidor validacao;

	public AcoesServidor() {
		validacao = new ValidacaoServidor();
	}

	public void cadastro(Servidor s) {
		String sql = "INSERT INTO leg.servidor" + "(codServidor,cargaHoraria,grau,codCargoServidor)"
				+ "VALUES(?,?,?,?)";
		try {
			validacao.validaDadosDoServidor(s);
			ServidorDAO dao = new ServidorDAO();
			dao.cadastro(s, sql);
			JOptionPane.showMessageDialog(null, "Servidor cadastrado com sucesso!!", "SQL",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "SQL", JOptionPane.ERROR_MESSAGE);
		} catch (RegexException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO DE ENTRADA", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void remove(Servidor s) {
		String sql = "DELETE FROM leg.usuario WHERE codUsuario=?";
		try {
			ServidorDAO dao = new ServidorDAO();
			dao.remove(s, sql);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "SQL", JOptionPane.ERROR_MESSAGE);
		}
	}
}
