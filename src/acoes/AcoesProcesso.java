package acoes;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import dao.ProcessoDAO;
import entidades.Processo;
import excecoes.RegexException;
import util.ValidacaoProcesso;

public class AcoesProcesso {
	private ValidacaoProcesso validacao;

	public AcoesProcesso() {
		validacao = new ValidacaoProcesso();
	}

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
