package testes;

import java.sql.SQLException;

import org.junit.Test;

import dao.CargoDAO;
import junit.framework.TestCase;

public class CargoTeste extends TestCase {
	CargoDAO cD;
	@Test
	public void testeExiste() throws SQLException{
		cD = new CargoDAO();
		assertEquals(cD.existe("SELECT * FROM leg.cargo WHERE codCargo=?","1"),true);
	}
	


}
