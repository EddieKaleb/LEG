package acoes;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import dao.DeclaracaoDAO;
import entidades.Declaracao;
import excecoes.RegexException;
import util.ValidacaoDeclaracao;

public class AcoesDeclaracao {
	private ValidacaoDeclaracao validacao;

	public AcoesDeclaracao() {
		validacao = new ValidacaoDeclaracao();
	}

	public void cadastro(Declaracao d) throws RegexException{
		String sql = "INSERT INTO leg.declaracao" + "(codSolicitante,statusDeclaracao,dataDeclaracao"
				+ ",descricaoDeclaracao,tipoDeclaracao)" + "VALUES(?,?,?,?,?)";
		try{
			validacao.validaDadosDaDeclaracao(d);
			DeclaracaoDAO dao = new DeclaracaoDAO();
			dao.cadastro(d, sql);
			JOptionPane.showMessageDialog(null, "Declaracao solicitada com sucesso!");
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(),"SQL", JOptionPane.ERROR_MESSAGE);
		}
	}
	public void altera(Declaracao d) throws RegexException {
		String sql = "UPDATE leg.declaracao SET statusDeclaracao=?, dataDeclaracao=? WHERE codDeclaracao=?";
		try {
			DeclaracaoDAO dao = new DeclaracaoDAO();
			JOptionPane.showMessageDialog(null, "Status de declaração atualizado!", "SQL", JOptionPane.OK_OPTION);
			dao.altera(d, sql);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "SQL", JOptionPane.ERROR_MESSAGE);
		} 
	}
	public void lista(Declaracao d) {
		String sql = "SELECT * FROM leg.declaracao";
		try {
			DeclaracaoDAO dao = new DeclaracaoDAO();
			dao.lista(sql);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(),"SQL", JOptionPane.ERROR_MESSAGE);
		}
	}
}
