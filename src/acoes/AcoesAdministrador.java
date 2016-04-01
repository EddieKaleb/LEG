package acoes;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import dao.AdministradorDAO;
import entidades.Administrador;
import excecoes.RegexException;
import util.ValidacaoAdministrador;

public class AcoesAdministrador {
	private ValidacaoAdministrador validacao;

	public AcoesAdministrador() {
		validacao = new ValidacaoAdministrador();
	}

	public void cadastro(Administrador a){
		String sql = "INSERT INTO leg.administrador" + "(codAdministrador,login, senha)"
				+ "VALUES(?,?,?)";
		try {
			validacao.validaDadosDoAdministrador(a);
			AdministradorDAO dao = new AdministradorDAO();
			dao.cadastra(a,sql);
			JOptionPane.showMessageDialog(null,"Administrador cadastrado com sucesso!!","SQL", JOptionPane.INFORMATION_MESSAGE);
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(),"SQL", JOptionPane.ERROR_MESSAGE);
		} catch (RegexException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),"ERRO DE ENTRADA", JOptionPane.ERROR_MESSAGE);
		}
	}
	public static boolean login(String login, String senha){
	String sql = "SELECT * FROM leg.administrador WHERE login=? AND senha=?";
	boolean logado = false;
		try {
			AdministradorDAO dao = new AdministradorDAO();
			 logado = dao.login(sql, login, senha);
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(),"SQL", JOptionPane.ERROR_MESSAGE);
		}
		return logado;
	}	
}
