package acoes;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import dao.AdministradorDAO;
import entidades.Administrador;
import excecoes.RegexException;
import util.ValidacaoAdministrador;
/**
 * Classe com métodos de ação do Administrador
 * @author Eddie
 *
 */
public class AcoesAdministrador {
	private ValidacaoAdministrador validacao;
	/**
	 * Construtor
	 */
	public AcoesAdministrador() {
		validacao = new ValidacaoAdministrador();
	}
	/**
	 * Método que cadastra um administrador utilizando a classe DAO
	 * @param a
	 */
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
	/**
	 * Método que verifica se login e senha do administrador estão corretos
	 * @param login
	 * @param senha
	 * @return
	 */
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
