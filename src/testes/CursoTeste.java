package testes;

import java.sql.SQLException;

import org.junit.Test;

import dao.CursoDAO;
import junit.framework.TestCase;

public class CursoTeste extends TestCase {
	CursoDAO cD;
	@Test
	public void testeExiste() throws SQLException{
		cD = new CursoDAO();
		assertEquals(cD.existe("SELECT * FROM leg.curso WHERE codCurso=?","1"),true);
	}
	


}
