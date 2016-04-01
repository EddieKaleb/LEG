package acoes;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import dao.CursoDAO;
import entidades.Curso;
import excecoes.RegexException;
import util.ValidacaoCurso;
/**
 * Classe com m�todos de a��o do curso
 * @author Eddie
 *
 */

public class AcoesCurso {
	private ValidacaoCurso validacao;
	/**
	 * Construtor
	 */
	public AcoesCurso() {
		validacao = new ValidacaoCurso();
	}
	/**
	 * M�todo que cadastra um curso novo atrav�s da classe DAO
	 * @param c
	 */
	public void cadastro(Curso c) {
		String sql = "INSERT INTO leg.curso(codCurso,nome,ementa,cargaHoraria,descricao) VALUES(?,?,?,?,?)";
		try {
			CursoDAO dao = new CursoDAO();
			validacao.validaDadosDoCurso(c);
			dao.cadastra(c, sql);
			JOptionPane.showMessageDialog(null, "Curso cadastrado com sucesso!!", "SQL",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "SQL", JOptionPane.ERROR_MESSAGE);
		} catch (RegexException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO DE ENTRADA", JOptionPane.ERROR_MESSAGE);
		}
	}
	/**
	 * Classe que remove um curso atrav�s da classe DAO
	 * @param c
	 */
	public void remove(Curso c) {
		String sql = "DELETE FROM leg.curso WHERE codCurso=?";
		String sql2 = "SELECT * FROM leg.curso WHERE codCurso=?";
		try {
			CursoDAO dao = new CursoDAO();
			if (dao.existe(sql2, c.getCodigo())) {
				dao.remove(c, sql);
				JOptionPane.showMessageDialog(null, "Curso exclu�do com sucesso!!", "SQL",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Curso n�o cadastrado!!", "SQL", JOptionPane.ERROR_MESSAGE);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Existem usu�rios cadastrados neste curso!", "SQL",
					JOptionPane.ERROR_MESSAGE);
		}
	}

}
