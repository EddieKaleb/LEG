package acoes;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import dao.CargoDAO;
import entidades.Cargo;
import excecoes.RegexException;
import util.ValidacaoCargo;

public class AcoesCargo {
	private ValidacaoCargo validacao;

	public AcoesCargo() {
		validacao = new ValidacaoCargo();
	}

	public void cadastro(Cargo c) {
		String sql = "INSERT INTO leg.cargo" + "(codCargo,nome,ramal,descricao)" + "VALUES(?,?,?,?)";
		try {
			CargoDAO dao = new CargoDAO();
			validacao.validaDadosDoCargo(c);
			dao.cadastra(c, sql);
			JOptionPane.showMessageDialog(null, "Cargo cadastrado com sucesso!!", "SQL",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "SQL", JOptionPane.ERROR_MESSAGE);
		} catch (RegexException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO DE ENTRADA", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void remove(Cargo c) {
		String sql = "DELETE FROM leg.cargo WHERE codCargo=?";
		String sql2 = "SELECT * FROM leg.cargo WHERE codCargo=?";
		try {
			CargoDAO dao = new CargoDAO();
			if (dao.existe(sql2, c.getCodigo())) {
				dao.remove(c, sql);
				JOptionPane.showMessageDialog(null, "Cargo excluído com sucesso!!", "SQL",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Cargo não cadastrado!!", "SQL", JOptionPane.ERROR_MESSAGE);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Existem usuários cadastrados neste cargo!", "SQL",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
