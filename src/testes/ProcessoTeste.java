package testes;

import java.sql.SQLException;

import org.junit.Test;

import dao.ProcessoDAO;
import junit.framework.TestCase;

public class ProcessoTeste extends TestCase {
	ProcessoDAO pD;
	@Test
	public void testeTabelaVizia() throws SQLException{
		pD = new ProcessoDAO();
		assertEquals(pD.tabelaVazia("SELECT * FROM leg.processo "
				+ "WHERE statusProcesso=?"),true);
	}
}