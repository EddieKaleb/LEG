package testes;

import java.sql.SQLException;

import org.junit.Test;

import dao.ServidorDAO;
import junit.framework.TestCase;

public class ServidorTeste extends TestCase {
	ServidorDAO pD;
	@Test
	public void testeTabelaVizia() throws SQLException{
		pD = new ServidorDAO();
		assertEquals(pD.tabelaVazia("SELECT * FROM leg.servidor"),true);
	}
}