package testes;

import java.sql.SQLException;

import org.junit.Test;

import dao.UsuarioDAO;
import junit.framework.TestCase;

public class UsuarioTeste extends TestCase {
	UsuarioDAO uD;
	@Test
	public void testeExiste() throws SQLException{
		uD = new UsuarioDAO();
		assertEquals(uD.existe("SELECT * FROM leg.usuario WHERE codUsuario=?","20161001001"),true);
	}
	


}
