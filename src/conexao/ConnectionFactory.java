package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Classe ConnectionFactory que fabrica uma conexão
 * @author Eddie
 *
 */
public class ConnectionFactory {
	/**
	 * Retorna a conexão criada
	 * @return
	 */
public Connection getConnection(){
		try{
			return DriverManager.getConnection("jdbc:mysql://localhost/leg","root","root");
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

}
