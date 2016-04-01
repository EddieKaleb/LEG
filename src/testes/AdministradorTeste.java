package testes;

import java.sql.SQLException;

import org.junit.Test;

import dao.AdministradorDAO;
import junit.framework.TestCase;

public class AdministradorTeste extends TestCase {
	AdministradorDAO pD;
	@Test
	public void testeTabelaVizia() throws SQLException{
		pD = new AdministradorDAO();
		assertEquals(pD.tabelaVazia("SELECT * FROM leg.administrador"),false);
	}
}