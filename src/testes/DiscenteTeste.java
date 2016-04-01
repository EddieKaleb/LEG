package testes;

import java.sql.SQLException;

import org.junit.Test;

import dao.DiscenteDAO;
import junit.framework.TestCase;

public class DiscenteTeste extends TestCase {
	DiscenteDAO pD;
	@Test
	public void testeTabelaVizia() throws SQLException{
		pD = new DiscenteDAO();
		assertEquals(pD.tabelaVazia("SELECT * FROM leg.discente"),false);
	}
}