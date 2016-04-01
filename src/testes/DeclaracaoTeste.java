package testes;

import java.sql.SQLException;

import org.junit.Test;

import dao.DeclaracaoDAO;
import junit.framework.TestCase;

public class DeclaracaoTeste extends TestCase {
	DeclaracaoDAO pD;
	@Test
	public void testeTabelaVizia() throws SQLException{
		pD = new DeclaracaoDAO();
		assertEquals(pD.tabelaVazia("SELECT * FROM leg.declaracao "
				+ "WHERE statusDeclaracao=?"),true);
	}
}