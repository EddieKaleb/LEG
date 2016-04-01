package acoes;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import dao.DiscenteDAO;
import entidades.Discente;
import excecoes.RegexException;
import util.ValidacaoDiscente;

public class AcoesDiscente {
	private ValidacaoDiscente validacao;

	public AcoesDiscente() {
		validacao = new ValidacaoDiscente();
	}

	public void cadastro(Discente d) {
		String sql = "INSERT INTO leg.discente" + "(codDiscente,semestre, codCursoDiscente)" + "VALUES(?,?,?)";
		try {
			DiscenteDAO dao = new DiscenteDAO();
			validacao.validaDadosDoDiscente(d);
			dao.cadastro(d, sql);
			JOptionPane.showMessageDialog(null,"Discente cadastrado com sucesso!!","SQL", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "SQL", JOptionPane.ERROR_MESSAGE);
		} catch (RegexException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO DE ENTRADA", JOptionPane.ERROR_MESSAGE);
		}
	}
	public void remove(Discente d) {
		String sql = "DELETE FROM leg.usuario WHERE codUsuario=?";
		try {
			DiscenteDAO dao = new DiscenteDAO();
			dao.remove(d, sql);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(),"SQL", JOptionPane.ERROR_MESSAGE);
		}
	}
}
