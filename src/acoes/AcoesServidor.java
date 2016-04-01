package acoes;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import dao.ServidorDAO;
import entidades.Servidor;
import excecoes.RegexException;
import util.ValidacaoServidor;
/**
 * Classe com m�todos de a��o do Servidor
 * @author Eddie
 *
 */
public class AcoesServidor {
	private ValidacaoServidor validacao;
/**
 * Construtor 
 */
	public AcoesServidor() {
		validacao = new ValidacaoServidor();
	}
/**
 * M�todo que cadastra servidor atrav�s da classe DAO
 * @param s
 */
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
/**
 * M�todo que remove servidor atrav�s da classe DAO
 * @param s
 */
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
