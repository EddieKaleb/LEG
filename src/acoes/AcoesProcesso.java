package acoes;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import dao.ProcessoDAO;
import entidades.Processo;
import excecoes.RegexException;
import util.ValidacaoProcesso;
/**
 * Classe com m�todos de a��o do Processo
 * @author Eddie
 *
 */
public class AcoesProcesso {
	private ValidacaoProcesso validacao;
/**
 * Construtor
 */
	public AcoesProcesso() {
		validacao = new ValidacaoProcesso();
	}
/**
 * M�todo que cadastra processo atrav�s da classe DAO
 * @param p
 */
	public void cadastro(Processo p) {
		String sql = "INSERT INTO leg.processo(codSolicitante,tipoProcesso,descricaoProcesso,"
				+ "statusProcesso,dataProcesso) VALUES (?,?,?,?,?)";
		try {
			ProcessoDAO dao = new ProcessoDAO();
			validacao.validaDadosDoProcesso(p);
			dao.cadastro(p, sql);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "SQL", JOptionPane.ERROR_MESSAGE);
		} catch (RegexException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO DE ENTRADA", JOptionPane.ERROR_MESSAGE);
		}
	}
/**
 * M�todo que atualiza declara��o atrav�s da classe DAO
 * @param p
 * @throws RegexException
 */
	public void altera(Processo p) throws RegexException {
		String sql = "UPDATE leg.processo SET statusProcesso=?, dataProcesso=? WHERE codProcesso=?";
		try {
			ProcessoDAO dao = new ProcessoDAO();
			dao.altera(p, sql);
			JOptionPane.showMessageDialog(null, "Status de processo atualizado!", "SQL", JOptionPane.OK_OPTION);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "SQL", JOptionPane.ERROR_MESSAGE);
		}
	}
}
